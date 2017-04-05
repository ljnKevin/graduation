package com.service;

import javax.jws.WebService;

import com.entity.UserBean;

@WebService
public interface UserService {
	
	public void updateUser(UserBean user);

}
