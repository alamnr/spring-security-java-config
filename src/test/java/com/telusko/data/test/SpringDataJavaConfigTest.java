package com.telusko.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.telusko.domain.AppUser;
import com.telusko.domain.AuthoritiesRepo;
import com.telusko.domain.JdbcUserRepo;
import com.telusko.domain.UserRepo;
import com.telusko.web.java.config.SpringApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =SpringApplicationTestConfig.class )
public class SpringDataJavaConfigTest {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	JdbcUserRepo jdbcUserRepo;
	
	@Autowired
	AuthoritiesRepo authoritiesRepo;
	
	@Test
	public void testAppUserSave() {
		AppUser user = new AppUser(null, "hakula@fakula.com", "Hakula", "Fakula", "hakula","pass", "USER",null,null,null,null);
		
		AppUser dbUser = userRepo.save(user);
		assertNotNull(dbUser.getId());
		
		assertEquals("hakula", userRepo.findByUsername("hakula").getUsername());
				
	}
	
	@Test
	public void jdbcUserSchema() {
		System.out.println(jdbcUserRepo.findAll());
		System.out.println(authoritiesRepo.findAll());
		System.out.println(new BCryptPasswordEncoder().encode("pass"));
	}

}
