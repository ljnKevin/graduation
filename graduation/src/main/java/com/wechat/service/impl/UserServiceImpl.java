package com.wechat.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.UserDao;
import com.wechat.domain.entity.UserBean;
import com.wechat.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Inject
	private UserDao userDao;
	
	@Override
	@Transactional
	public void addUser(UserBean user) {
		userDao.saveAndFlush(user);
	}
	
	@Override
	@Transactional
	public void updateUser(UserBean user) {
		userDao.saveAndFlush(user);
	}
	
	@Override
	@Transactional
	public UserBean getUserByOpenid(String openid) {
		return userDao.getByOpenid(openid);
	}
}
