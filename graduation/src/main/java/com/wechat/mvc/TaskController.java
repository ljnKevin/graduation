package com.wechat.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.TaskBean;
import com.wechat.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
  
	@Inject
	private TaskService taskService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	  void testDatabase() {
		
		taskService.test();
	  }
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addTask(@RequestParam("openid") String openid,@RequestParam("title") String title,@RequestParam("cycle") String cycle,@RequestParam("cycleDate") int cycleDate,@RequestParam("createTime") String createTime,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,@RequestParam("remark") String remark,@RequestParam("location") String location) throws ParseException {
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
	    task.setLocation(location);
		taskService.addTask(task,openid);
		  return true;
	  }
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	  boolean updateNoteBookItem(@RequestParam("taskId") Long taskId,@RequestParam("title") String title,@RequestParam("cycle") String cycle,@RequestParam("cycleDate") int cycleDate,@RequestParam("createTime") String createTime,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,@RequestParam("remark") String remark,@RequestParam("location") String location) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;  
		TaskBean task = new TaskBean();
		  task.setTaskId(taskId);
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
		    task.setLocation(location);
			taskService.updateTask(task);
		  return true;
	  }
	
	@RequestMapping(value="/findAllByWechatName",method=RequestMethod.POST)
	  List<TaskBean> findAllByWechatName(@RequestParam("wechatName") String wechatName) {
		
		  return taskService.findAllByWechatName(wechatName);
	  }
	
	@RequestMapping(value="/findAllActiveTask",method=RequestMethod.POST)
	List<TaskBean> findAllActiveTaskByWechatName(@RequestParam("wechatName") String wechatName) {
		  return taskService.findAllActiveByWechatName(wechatName);
	  }
	
	@RequestMapping(value="/todayHaveClockIn",method=RequestMethod.POST)
	boolean checkTodayWhetherHaveClockIn(@RequestParam("taskId") Long taskId) {
		  return taskService.checkTodayWhetherHaveClockIn(taskId);
	  }
	
	@RequestMapping(value="/clockIn",method=RequestMethod.POST)
	void clockIn(@RequestParam("taskId") Long taskId,@RequestParam("remark") String remark,@RequestParam("location") String location) {
		  taskService.clockIn(taskId,remark,location);
	  }
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	  boolean deleteTaskByTaskId(@RequestParam("taskId") Long taskId) {
		taskService.deleteTaskByTaskId(taskId);
		  return true;
	  }
}
