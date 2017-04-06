package com.wechat.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.domain.entity.TaskBean;
import com.wechat.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
  
	@Inject
	private TaskService taskService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addTask(@RequestParam("wechatName") String wechatName,@RequestParam("title") String title,@RequestParam("cycle") String cycle,@RequestParam("cycleDate") int cycleDate,@RequestParam("createTime") String createTime,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,@RequestParam("remark") String remark) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		
		TaskBean task = new TaskBean();
	    task.setTitle(title);
	    task.setCycle(cycle);
	    task.setCycleDate(cycleDate);
	    date = sdf.parse(createTime);
	    task.setCreateTime(date);
	    date = sdf.parse(startTime);
	    task.setStartTime(date);
	    date = sdf.parse(endTime);
	    task.setEndTime(date);
	    task.setRemark(remark);
		taskService.addTask(task,wechatName);
		  return true;
	  }
}
