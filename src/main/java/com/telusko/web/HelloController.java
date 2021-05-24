package com.telusko.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@Autowired
	AddService addService;

	@RequestMapping("/")
	public String home() {
		//return "index.jsp";
		return "index";
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
