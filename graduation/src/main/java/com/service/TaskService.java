package com.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.entity.NoteBookItemBean;
import com.entity.TaskBean;

@WebService
public interface TaskService {
	
	void addTask(@WebParam(name = "task") final TaskBean task);

}
