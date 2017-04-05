package com.service.impl;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entity.UserBean;
import com.service.UserService;

public class UserServiceImpl implements UserService{
	@Inject
	private UserDao userDao;
	
	@Override
	@Transactional
	public void updateUser(UserBean user) {
		//test update
//		userDao.
//		userDao.save(user);
	}
}
