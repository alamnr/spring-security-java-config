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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.telusko.domain.AppUser;
import com.telusko.domain.UserRepo;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider  implements AuthenticationProvider{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/*@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		AppUser user = userRepo.findByUsername(token.getName());
		System.out.println(token.getCredentials().toString());
		System.out.println(user.getPassword());
		System.out.println(bCryptPasswordEncoder.matches(token.getCredentials().toString(),user.getPassword()));
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
	}*/
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;
		AppUser user = userRepo.findByUsername(token.getName());
		//System.out.println(token.getCredentials().toString());
		//System.out.println(user.getPassword());
		//System.out.println(bCryptPasswordEncoder.matches(token.getCredentials().toString(),user.getPassword()));
		if(user == null ) {
			throw new UsernameNotFoundException(token.getName());
		}
		if(!passwordEncoder.matches(token.getCredentials().toString(),user.getPassword())
				|| !token.getMake().equalsIgnoreCase("subaru")) {
			throw new BadCredentialsException("bad credentials");
		}
		return new CustomAuthenticationToken(user.getUsername(), user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole()),token.getMake());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return CustomAuthenticationToken.class.equals(authentication);
	}

}
