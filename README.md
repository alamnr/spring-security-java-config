# spring-security-java-config
example of spring-security-java-config 

jdbc authentication java config -a you must have a bean having interface type PasswordEncoder i.e:  

@Bean
	public PasswordEncoder getPasswordEncoder() {

		return NoOpPasswordEncoder.getInstance();
		//return new BCryptPasswordEncoder();
	}
