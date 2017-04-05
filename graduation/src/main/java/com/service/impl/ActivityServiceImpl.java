package com.service.impl;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ActivityDao;
import com.entity.ActivityBean;
import com.service.ActivityService;

public class ActivityServiceImpl implements ActivityService{

	@Inject
	private ActivityDao activityDao;
	
	@Override
	@Transactional
	public void addActivity(ActivityBean activity) {
		activityDao.save(activity);
	}

}
