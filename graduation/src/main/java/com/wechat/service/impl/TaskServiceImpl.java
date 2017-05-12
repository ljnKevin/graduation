package com.wechat.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.PunchClockDao;
import com.wechat.domain.dao.TaskDao;
import com.wechat.domain.dao.TestDao;
import com.wechat.domain.dao.UserDao;
import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.PunchClockBean;
import com.wechat.domain.entity.TaskBean;
import com.wechat.domain.entity.TestBean;
import com.wechat.domain.entity.UserBean;
import com.wechat.domain.model.TaskModel;
import com.wechat.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Inject
	private TaskDao taskDao;
	
	@Inject
	private PunchClockDao punchClockDao;
	
	@Inject
	private UserDao userDao;
	
	@Inject
	private TestDao testDao;
	
	@Override
	@Transactional
	public void addTask(TaskBean task,String openid) {
		UserBean  user = userDao.getByOpenid(openid);
		task.setUser(user);
		taskDao.saveAndFlush(task);
	}
	
	@Override
	@Transactional
	public void test() {
		TestBean test = new TestBean();
		test.setName("小叶");
		testDao.saveAndFlush(test);
	}
	
	@Override
	@Transactional
	public void updateTask(TaskBean task) {
		TaskBean old = taskDao.getById(task.getTaskId());
		task.setUser(old.getUser());
		taskDao.saveAndFlush(task);
	}
	
	@Override
	@Transactional
	public List<TaskBean> findAllByOpenid(String openid) {
		Date now = new Date();
		return taskDao.findAllByOpenid(openid,now);
	}
	
	@Override
	@Transactional
	public List<TaskBean> findAllActiveByWechatName(String wechatName) {
		Date now = new Date();
		return taskDao.findAllActiveByWechatName(wechatName,now);
	}
	
	@Override
	@Transactional
	public void deleteTaskByTaskId(Long taskId) {
		taskDao.delete(taskId);
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public int checkTask(final Long taskId){
		TaskBean task = taskDao.getById(taskId);
		Date now = new Date();
		Calendar cal=Calendar.getInstance();  
	    cal.setTime(now); 
	    
		if(TaskBean.TaskCycle.WEEKLY.toString().equals(task.getCycle())){
			if((cal.get(Calendar.DAY_OF_WEEK) == Integer.parseInt(task.getCycleDate()))  || (cal.get(Calendar.DAY_OF_WEEK) == 0 && Integer.parseInt(task.getCycleDate()) == 7)){
				
				if(task.getLastDate()!=null){
					Calendar calLast=Calendar.getInstance();  
					calLast.setTime(task.getLastDate());
					if(calLast.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)){
						return 1;
					}else{
						return 0;
					}
				}else{
					return 0;
				}
				
			}else{
				return 2;
			}
		}else if(TaskBean.TaskCycle.MONTHLY.toString().equals(task.getCycle())){
			if(cal.get(Calendar.DAY_OF_MONTH) == Integer.parseInt(task.getCycleDate())){
				if(task.getLastDate()!=null){
					Calendar calLast=Calendar.getInstance();  
					calLast.setTime(task.getLastDate());
					if(calLast.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)){
						return 1;
					}else{
						return 0;
					}
				}else{
					return 0;
				}
				
			}else{
				return 2;
			}
		}else{
			if(task.getLastDate()==null){
				return 0;
			}else{
				Calendar calLast=Calendar.getInstance();  
				calLast.setTime(task.getLastDate());
				if(calLast.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)){
					return 1;
				}else{
					return 0;
				}
			}
		}
		
	}
	
	@Override
	@Transactional
	public TaskModel getDetailsByTaskId(final Long taskId){
		TaskBean task = taskDao.getOne(taskId);
		TaskModel taskModel = new TaskModel();
		taskModel.setTitle(task.getTitle());
		taskModel.setAddress(task.getAddress());
		taskModel.setStartTime(task.getStartTime());
		taskModel.setEndTime(task.getEndTime());
		if(TaskBean.TaskCycle.WEEKLY.toString().equals(task.getCycle())){
			taskModel.setCycle("每周");
		}else if(TaskBean.TaskCycle.MONTHLY.toString().equals(task.getCycle())){
			taskModel.setCycle("每月");
			
		}else{
			taskModel.setCycle("每天");
		}
		taskModel.setCycleDate(task.getCycleDate());
		return taskModel;
	}
	@Override
	@Transactional
	public List<PunchClockBean> getPunchClocksByTaskId(final Long taskId){
		return punchClockDao.findByTaskId(taskId);
	}
	
	@Override
	@Transactional
	public void clockIn(final Long taskId,final String humor,final String address,final String latitude,final String longitude){
		Date now = new Date();
		
		TaskBean task = taskDao.getById(taskId);
		task.setLastAddress(address);
		task.setLastDate(now);
		taskDao.saveAndFlush(task);
		
		PunchClockBean punchClock = new PunchClockBean();
		
		punchClock.setCreateTime(now);
		punchClock.setTask(task);
		punchClock.setHumor(humor);
		punchClock.setAddress(address);
		punchClock.setLatitude(latitude);
		punchClock.setLongitude(longitude);
		punchClockDao.saveAndFlush(punchClock);
		
	}
	
}
