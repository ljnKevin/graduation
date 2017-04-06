package com.wechat.service;

import javax.jws.WebService;

import com.wechat.domain.entity.UserBean;

@WebService
public interface UserService {
	
	public void updateUser(UserBean user);

}
