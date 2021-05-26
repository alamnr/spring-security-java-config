package com.telusko.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.telusko.domain.AppUser;
import com.telusko.domain.UserRepo;


@Component
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*AppUser user = userRepo.findByUsername(username);
		return new User(user.getUsername(),user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole()));*/
		
		return userRepo.findByUsername(username);
	}

}
