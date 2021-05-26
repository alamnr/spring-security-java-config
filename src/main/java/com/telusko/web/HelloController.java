package com.telusko.web;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.domain.AppUser;
import com.telusko.domain.UserRepo;

@Controller
public class HelloController {
	
	@Autowired
	AddService addService;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping("/")
	public String home() {
		//return "index.jsp";
		return "index";
	}
	
	@RequestMapping(value =  "/register", method = RequestMethod.GET)
	public String goRegister() {
	
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	
	public String register(@ModelAttribute AppUser user) {
		
		user.setRole("USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		return "redirect:/secure";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.GET )
	public String loginPage() {  
		return "login";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.GET)
	public String add(@RequestParam("t1") int t1, @RequestParam("t2") int t2,  HttpServletRequest request , HttpServletResponse response) { 
		int result = addService.addMe(t1,t2);
		request.setAttribute("result",  result);
		//return "display.jsp";
		return "display";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam("t1") int t1, @RequestParam("t2") int t2) {
		int result = addService.addMe(t1,t2);
		ModelAndView mv = new ModelAndView();
		//mv.setViewName("display.jsp");
		mv.setViewName("display");
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/about")
	public String about( )	{
		
		return "about";
	}
	
	@RequestMapping("/secure")
	public String securePage( )	{
		
		return "securePage";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject("message",ex.getMessage());
		return mv;
	}

}
