package com.wechat.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.PunchClockBean;
import com.wechat.domain.entity.TaskBean;
import com.wechat.domain.model.TaskModel;
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
	  boolean addTask(@RequestParam("openid") String openid,@RequestParam("title") String title,@RequestParam("address") String address,@RequestParam("latitude") String latitude,@RequestParam("longitude") String longitude,@RequestParam("startDay") String startDay,@RequestParam("endDay") String endDay,@RequestParam("cycle") String cycle,@RequestParam("cycleDate") String cycleDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date= new Date();
		
		TaskBean task = new TaskBean();
	    task.setTitle(title);
	    task.setAddress(address);
	    task.setLatitude(latitude);
	    task.setLongitude(longitude);
	    task.setCycle(cycle);
	    task.setCycleDate(cycleDate);
	    task.setCreateTime(date);
	    
	    date = sdf.parse(startDay);
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    date = calendar.getTime();
	    task.setStartTime(date);
	    
	    date = sdf.parse(endDay);
	    Calendar calendar1 = Calendar.getInstance();
	    calendar1.setTime(date);
	    calendar1.set(Calendar.HOUR_OF_DAY, 0);
	    calendar1.set(Calendar.MINUTE, 0);
	    calendar1.set(Calendar.SECOND, 0);
	    date = calendar1.getTime();
	    task.setEndTime(date);
	    
		taskService.addTask(task,openid);
		  return true;
	  }
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	  boolean updateTask(@RequestParam("taskId") Long taskId,@RequestParam("title") String title,@RequestParam("cycle") String cycle,@RequestParam("cycleDate") int cycleDate,@RequestParam("createTime") String createTime,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,@RequestParam("remark") String remark,@RequestParam("location") String location) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;  
		TaskBean task = new TaskBean();
		  task.setTaskId(taskId);
		  task.setTitle(title);
		    task.setCycle(cycle);
//		    task.setCycleDate(cycleDate);
		    date = sdf.parse(createTime);
		    task.setCreateTime(date);
		    date = sdf.parse(startTime);
		    task.setStartTime(date);
		    date = sdf.parse(endTime);
		    task.setEndTime(date);
		    task.setRemark(remark);
//		    task.setLocation(location);
			taskService.updateTask(task);
		  return true;
	  }
	
	@RequestMapping(value="/findAllByOpenid",method=RequestMethod.POST)
	  List<TaskBean> findAllByWechatName(@RequestParam("openid") String openid) {
		
		  return taskService.findAllByOpenid(openid);
	  }
	
	@RequestMapping(value="/findAllActiveTask",method=RequestMethod.POST)
	List<TaskBean> findAllActiveTaskByWechatName(@RequestParam("wechatName") String wechatName) {
		  return taskService.findAllActiveByWechatName(wechatName);
	  }
	
	@RequestMapping(value="/checkTask",method=RequestMethod.POST)
	int checkTask(@RequestParam("taskId") Long taskId) {
		  return taskService.checkTask(taskId);
	  }
	
	@RequestMapping(value="/details",method=RequestMethod.POST)
	TaskModel details(@RequestParam("taskId") Long taskId) {
			TaskModel taskModel = taskService.getDetailsByTaskId(taskId);
			
		  return taskModel;
	  }
	
	@RequestMapping(value="/punchClocks",method=RequestMethod.POST)
	List<PunchClockBean> punchClocks(@RequestParam("taskId") Long taskId) {
		  return taskService.getPunchClocksByTaskId(taskId);
	  }
	
	@RequestMapping(value="/clockIn",method=RequestMethod.POST)
	void clockIn(@RequestParam("openid") String openid,@RequestParam("taskId") Long taskId,@RequestParam("humor") String humor,@RequestParam("address") String address,@RequestParam("latitude") String latitude,@RequestParam("longitude") String longitude) {
		  taskService.clockIn(taskId,humor,address,latitude,longitude);
	  }
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	  boolean deleteTaskByTaskId(@RequestParam("taskId") Long taskId) {
		taskService.deleteTaskByTaskId(taskId);
		  return true;
	  }
}
