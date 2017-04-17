package com.wechat.service.impl;

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
	public List<TaskBean> findAllByOpenid(String opendi) {
		return taskDao.findAllByOpenid(opendi);
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

	@Override
	@Transactional
	public boolean checkTodayWhetherHaveClockIn(final Long taskId){
		Date now = new Date();
		PunchClockBean punchClock = punchClockDao.findByTaskIdAndCreateTime(taskId,now);
		if(punchClock !=null){
			return true;
		}else{
			return false;
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public int checkTask(final Long taskId){
		TaskBean task = taskDao.getOne(taskId);
		Date now = new Date();
		
		if(TaskBean.TaskCycle.WEEKLY.toString().equals(task.getCycle())){
			if((now.getDay() == Integer.parseInt(task.getCycleDate()))  || (now.getDay() == 0 && Integer.parseInt(task.getCycleDate()) == 7)){
				if(task.getLastDate().getYear() == now.getYear() && task.getLastDate().getMonth() == now.getMonth() && task.getLastDate().getDate() == now.getDate()){
					return 1;
				}else{
					return 0;
				}
			}else{
				return 2;
			}
		}else if(TaskBean.TaskCycle.MONTHLY.toString().equals(task.getCycle())){
			if(now.getDate() == Integer.parseInt(task.getCycleDate())){
				if(task.getLastDate().getYear() == now.getYear() && task.getLastDate().getMonth() == now.getMonth() && task.getLastDate().getDate() == now.getDate()){
					return 1;
				}else{
					return 0;
				}
			}else{
				return 2;
			}
		}else{
			if(task.getLastDate().getYear() == now.getYear() && task.getLastDate().getMonth() == now.getMonth() && task.getLastDate().getDate() == now.getDate()){
				return 1;
			}else{
				return 0;
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
	public void clockIn(final Long taskId,final String humor,final String address,final String latitude,final String longitude){
		Date now = new Date();
		
		TaskBean task = taskDao.getOne(taskId);
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
