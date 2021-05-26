package com.telusko.web.java.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.telusko.aop.CustomAuditorAware;
import com.telusko.spring.security.CustomAuthenticationProvider;
import com.telusko.spring.security.CustomUserDetailService;

@Configuration
@EnableJpaRepositories("com.telusko.domain")
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {CustomAuditorAware.class,CustomUserDetailService.class,CustomAuthenticationProvider.class})
@EnableJpaAuditing( auditorAwareRef = "customAuditorAware")

public class SpringApplicationConfig {
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:init.sql").build();
		
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		
		Properties jpapProperties = new Properties();
		jpapProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		jpapProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(adapter);
		localContainerEntityManagerFactoryBean.setJpaProperties(jpapProperties);
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.telusko.domain");
		localContainerEntityManagerFactoryBean.afterPropertiesSet();
		return localContainerEntityManagerFactoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
	}


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
	    return  new BCryptPasswordEncoder();
	}
	
	

}
