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
	
	@Override
	@Transactional
	public void clockIn(final Long taskId,final String remark,final String location){
		TaskBean task = taskDao.getOne(taskId);
		PunchClockBean punchClock = new PunchClockBean();
		Date now = new Date();
		punchClock.setCreateTime(now);
		punchClock.setTask(task);
		punchClock.setRemark(remark);
		punchClock.setLocation(location);
		punchClockDao.saveAndFlush(punchClock);
		
	}
	
}
