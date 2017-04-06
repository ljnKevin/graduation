package com.wechat.service.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.ActivityDao;
import com.wechat.domain.entity.ActivityBean;
import com.wechat.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{

	 @Autowired
	private ActivityDao activityDao;
	
	@Override
	@Transactional
	public void addActivity(ActivityBean activity) {
		activityDao.save(activity);
	}

}
