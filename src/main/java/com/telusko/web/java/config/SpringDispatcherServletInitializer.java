package com.telusko.web.java.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		//return null;
		return new Class[] { SpringApplicationConfig.class,SpringSecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringDispatcherServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[] {new DelegatingFilterProxy("springSecurityFilterChain")};
	}

	/*@Override
	protected Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
		filter = new DelegatingFilterProxy("springSecurityFilterChain");		
		Dynamic dynamic =  servletContext.addFilter("springSecurityFilterChain", filter);
		//dynamic.addMappingForUrlPatterns(null, false, "/*");
		return dynamic;
	}*/

	
	
	
	
	

}
