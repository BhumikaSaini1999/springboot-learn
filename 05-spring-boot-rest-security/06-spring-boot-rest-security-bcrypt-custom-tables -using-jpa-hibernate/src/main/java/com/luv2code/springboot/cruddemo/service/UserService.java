package com.luv2code.springboot.cruddemo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.luv2code.springboot.cruddemo.entity.User;

public interface UserService extends UserDetailsService{
	public User findByUserName(String userName);
}
