package com.wechat.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.web.bind.annotation.RequestParam;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.PunchClockBean;
import com.wechat.domain.entity.TaskBean;
import com.wechat.domain.model.TaskModel;

@WebService
public interface TaskService {
	
	void addTask(@WebParam(name = "task") final TaskBean task,@WebParam(name = "openid") final String openid);
	void updateTask(@WebParam(name = "task") final TaskBean task);
	List<TaskBean> findAllByOpenid(@WebParam(name = "openid") final String openid);
	List<TaskBean> findAllActiveByWechatName(@WebParam(name = "wechatName") final String wechatName);
	void deleteTaskByTaskId(@WebParam(name = "taskId") final Long taskId);
	int checkTask(@WebParam(name = "taskId") final Long taskId);
	TaskModel getDetailsByTaskId(@WebParam(name = "taskId") final Long taskId);
	List<PunchClockBean> getPunchClocksByTaskId(@WebParam(name = "taskId") final Long taskId);
	void clockIn(@WebParam(name = "taskId") final Long taskId,@WebParam(name = "remark") final String remark,@WebParam(name="address")final String address,@WebParam(name="latitude")final String latitude,@WebParam(name="longitude")final String longitude);
	void test();
}
