package com.telusko.web.java.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
	public SpringSecurityWebInitializer() {
        super(SpringSecurityConfig.class);
    }
}
