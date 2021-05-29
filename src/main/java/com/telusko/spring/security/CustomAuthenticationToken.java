package com.telusko.spring.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.telusko.domain.AppUser;

@SuppressWarnings("serial")
public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private String make;
	
	

	public CustomAuthenticationToken(String principal, String credentials,
			Collection<? extends GrantedAuthority> authorities, String make) {
		super(principal, credentials, authorities);
		this.make = make;
	}



	public CustomAuthenticationToken(String principal, String credentials, String make) {
		super(principal, credentials);
		this.make = make;
	}



	public String getMake() {
		return make;
	}
	
	
}
