package com.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.ActivityDao;
import com.wechat.domain.dao.UserDao;
import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.UserBean;
import com.wechat.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{

	 @Autowired
	private ActivityDao activityDao;
	
	 @Autowired
	private UserDao userDao;
	 
	@Override
	@Transactional
	public void addActivity(ActivityBean activity,String wechatName) {
		UserBean user = userDao.getByWechatName(wechatName);
		activity.setUser(user);
		activityDao.saveAndFlush(activity);
	}

}
