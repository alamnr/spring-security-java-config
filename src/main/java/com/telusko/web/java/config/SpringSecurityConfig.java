package com.telusko.web.java.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.telusko.spring.security.CustomAuthenticationFilter;
import com.telusko.spring.security.CustomAuthenticationProvider;
import com.telusko.spring.security.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		/*.withDefaultSchema()
		.withUser(User.withUsername("user").password(passwordEncoder.encode("pass")).roles("USER"))
		.withUser(User.withUsername("admin").password(passwordEncoder.encode("pass")).roles("ADMIN"));*/
		/* custom schema */
		.usersByUsernameQuery("select email,password,enabled "
		        + "from users "
		        + "where email = ?")
		.authoritiesByUsernameQuery("select email,authority "
		        + "from authorities "
		        + "where email = ?");
		
    }
	
	protected void configure(HttpSecurity http) throws Exception { 
		
	    http.authorizeRequests()
	    	.antMatchers("/static/**", "/about","/","/register","/users").permitAll()
	    	.antMatchers("/ghap").hasAnyRole("USER")
	    	.antMatchers("/secure","/add").hasRole("ADMIN")
	    	.anyRequest().authenticated()
	    	.and().exceptionHandling().accessDeniedPage("/WEB-INF/jsp/accessDenied.jsp")
	    	
	    	//.and().httpBasic();
	    	
	    	//.and().formLogin().permitAll()
	    	
	    	//.and().logout().logoutUrl("/logout").permitAll();
	    	
	    	.and().formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("custom_username")
			.passwordParameter("custom_password").defaultSuccessUrl("/", true).failureUrl("/login?error=true").permitAll()	
	    	
	    	.and().logout().deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutUrl("/logout")	    	
	    	.logoutSuccessUrl("/login?logout=true").permitAll();
	    
	        //.and().csrf().disable();
	    
		
	}

	
}

