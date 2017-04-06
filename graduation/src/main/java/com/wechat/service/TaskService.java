package com.wechat.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.TaskBean;

@WebService
public interface TaskService {
	
	void addTask(@WebParam(name = "task") final TaskBean task,@WebParam(name = "wechatName") final String wechatName);

}
