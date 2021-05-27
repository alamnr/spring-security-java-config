package com.telusko.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.telusko.domain.AppUser;
import com.telusko.domain.UserRepo;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider  implements AuthenticationProvider{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		AppUser user = userRepo.findByUsername(token.getName());
		
		//if(user == null || !user.getPassword().equalsIgnoreCase(token.getCredentials().toString())) {
		if(user == null ) {
			throw new UsernameNotFoundException(token.getName());
		}
		if(!bCryptPasswordEncoder.matches(token.getCredentials().toString(),user.getPassword())) {
			throw new BadCredentialsException("bad credentials");
		}
		return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole()));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
