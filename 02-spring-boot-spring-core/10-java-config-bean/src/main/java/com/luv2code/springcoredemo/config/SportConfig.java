package com.luv2code.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
	//The bean id defaults to the method name
	//our custom bean id "aquatic"
	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
