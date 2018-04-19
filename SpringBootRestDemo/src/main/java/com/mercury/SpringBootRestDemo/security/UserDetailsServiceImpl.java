package com.mercury.SpringBootRestDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.bean.User;
import com.mercury.SpringBootRestDemo.dao.UserDao;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return user;//返回用户信息！
	}

}
