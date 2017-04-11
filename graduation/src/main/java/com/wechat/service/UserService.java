package com.wechat.service;

import javax.jws.WebService;

import com.wechat.domain.entity.UserBean;

@WebService
public interface UserService {
	
	public void addUser(UserBean user);
	public void updateUser(UserBean user);
	public UserBean getUserByOpenid(String openid);

}
