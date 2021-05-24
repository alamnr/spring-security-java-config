package com.telusko.web.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

//@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	

		
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("pass")).roles("USER")
        		.and().withUser("admin").password(passwordEncoder().encode("pass")).roles("USER","ADMIN");
    }
	
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    	.antMatchers("/static/**", "/about","/").permitAll()
	    	.antMatchers("/ghap").hasAnyRole("USER")
	    	.antMatchers("/secure","/add").hasRole("ADMIN")
	    	.anyRequest().authenticated()
	    	.and().exceptionHandling().accessDeniedPage("/WEB-INF/jsp/accessDenied.jsp")
	    	//.and().httpBasic();
	    	//.and().formLogin().permitAll()
	    	//.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").permitAll();
	    	.and().formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("custom_name")
	    	.passwordParameter("custom_password").defaultSuccessUrl("/", true).failureUrl("/login?error=true").permitAll()	    	
	    	.and().logout().deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutUrl("/logout")
	    	.logoutSuccessUrl("/login?logout=true").permitAll();
	        //.and().csrf().disable();
	    
		
	}
	
	/*@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	        .ignoring()
	        .antMatchers("/static/**", "/about","/");
	}*/

	@Bean
	public PasswordEncoder passwordEncoder() {
		
	    return  NoOpPasswordEncoder.getInstance();
	}
	
	
}

