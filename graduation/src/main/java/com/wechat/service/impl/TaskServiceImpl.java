package com.wechat.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.TaskDao;
import com.wechat.domain.dao.UserDao;
import com.wechat.domain.entity.TaskBean;
import com.wechat.domain.entity.UserBean;
import com.wechat.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Inject
	private TaskDao taskDao;
	
	@Inject
	private UserDao userDao;
	
	@Override
	@Transactional
	public void addTask(TaskBean task,String wechatName) {
		UserBean  user = userDao.getByWechatName(wechatName);
		task.setUser(user);
		taskDao.saveAndFlush(task);
	}

}
