package com.service.impl;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.dao.TaskDao;
import com.entity.TaskBean;
import com.service.TaskService;

public class TaskServiceImpl implements TaskService{

	@Inject
	private TaskDao taskDao;
	
	@Override
	@Transactional
	public void addTask(TaskBean task) {
		taskDao.save(task);
	}

}
