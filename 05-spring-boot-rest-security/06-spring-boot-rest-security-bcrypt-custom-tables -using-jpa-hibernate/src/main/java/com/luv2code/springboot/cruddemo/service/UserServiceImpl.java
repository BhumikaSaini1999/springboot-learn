package com.luv2code.springboot.cruddemo.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.RoleDao;
import com.luv2code.springboot.cruddemo.dao.UserDao;
import com.luv2code.springboot.cruddemo.entity.Role;
import com.luv2code.springboot.cruddemo.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	private RoleDao roleDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		this.userDao=userDao;
		this.roleDao=roleDao;
	}
	
	@Override
	public User findByUserName(String userName) {
		//check database if user already exists
		return userDao.findByUserName(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		
		if(user==null)
			throw new UsernameNotFoundException("Invalid username or password");
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
						mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		// TODO Auto-generated method stub
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
