package com.wechat.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.TaskDao;
import com.wechat.domain.entity.TaskBean;
import com.wechat.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Inject
	private TaskDao taskDao;
	
	@Override
	@Transactional
	public void addTask(TaskBean task) {
		taskDao.save(task);
	}

}
