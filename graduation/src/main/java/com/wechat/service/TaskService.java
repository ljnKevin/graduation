package com.wechat.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.web.bind.annotation.RequestParam;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.TaskBean;

@WebService
public interface TaskService {
	
	void addTask(@WebParam(name = "task") final TaskBean task,@WebParam(name = "openid") final String openid);
	void updateTask(@WebParam(name = "task") final TaskBean task);
	List<TaskBean> findAllByWechatName(@WebParam(name = "wechatName") final String wechatName);
	List<TaskBean> findAllActiveByWechatName(@WebParam(name = "wechatName") final String wechatName);
	void deleteTaskByTaskId(@WebParam(name = "taskId") final Long taskId);
	boolean checkTodayWhetherHaveClockIn(@WebParam(name = "taskId") final Long taskId);
	void clockIn(@WebParam(name = "taskId") final Long taskId,@WebParam(name = "remark") final String remark,@RequestParam("location") String location);
	void test();
}
