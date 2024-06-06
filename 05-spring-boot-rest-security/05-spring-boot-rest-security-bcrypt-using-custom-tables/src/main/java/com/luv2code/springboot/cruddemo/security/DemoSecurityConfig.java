package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// Spring Boot won't use users from application.properties file now
@Configuration
public class DemoSecurityConfig {
	
	// add support for JDBC ... no more hardcoded users :-)
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		// telling spring security to use JDBC authentication with our data source
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		// define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?"
				);
		
		// define query to retrieve the authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?"
				);
		return jdbcUserDetailsManager;
	}
	
	/*@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
		UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
				.build();
		UserDetails susan = User.builder().username("susan").password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(john, mary, susan);
	}*/
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->{
			configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
			          .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
			          .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
			          .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
			          .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
		});
		
		// use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		// disable csrf (Cross site Request Forgery) 
		//in general not required for stateless REST API's - GET,PUT,POST,DELETE,PATCH
		http.csrf(csrf->csrf.disable());
		return http.build();
	}
}
