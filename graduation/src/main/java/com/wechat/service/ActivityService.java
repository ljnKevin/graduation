package com.wechat.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.wechat.domain.entity.ActivityBean;

@WebService
public interface ActivityService {
	
	void addActivity(@WebParam(name = "activity") final ActivityBean activity,String wechatName);

}
