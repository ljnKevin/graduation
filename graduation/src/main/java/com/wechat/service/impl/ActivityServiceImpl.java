package com.wechat.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.ActivityDao;
import com.wechat.domain.dao.ActivityUserDao;
import com.wechat.domain.dao.UserDao;
import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.ActivityUserBean;
import com.wechat.domain.entity.TaskBean;
import com.wechat.domain.entity.UserBean;
import com.wechat.domain.model.ActivityModel;
import com.wechat.domain.model.TaskModel;
import com.wechat.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{

	 @Autowired
	private ActivityDao activityDao;
	
	 @Autowired
	private ActivityUserDao activityUserDao;
	 
	 @Autowired
	private UserDao userDao;
	 
	@Override
	@Transactional
	public void addActivity(ActivityBean activity,String openid) {
		UserBean user = userDao.getByOpenid(openid);
		activity.setUser(user);
		activityDao.saveAndFlush(activity);
	}
	
	@Override
	@Transactional
	public List<ActivityBean> findAllCreateByOpenid(String openid) {
		return activityDao.findAllByOpenid(openid);
	}
	
	@Override
	@Transactional
	public List<ActivityBean> findAllJoinByOpenid(String openid) {
		List<ActivityUserBean> activityUserList = activityUserDao.findByUserOpenid(openid);
		List<ActivityBean> myActivityList = activityDao.findAllByOpenid(openid);
		List<ActivityBean>  activityList = new ArrayList<>();
		for(ActivityUserBean activityUser : activityUserList){
			boolean isMy = false;
			for(ActivityBean activity : myActivityList){
				if(activityUser.getActivity().getActivityId() == activity.getActivityId()){
					isMy = true;
				}
			}
			if(!isMy){
				activityList.add(activityUser.getActivity());
			}
			
		}
		
		return activityList;
	}
	
	@Override
	@Transactional
	public List<ActivityBean> findAll() {
		return activityDao.findAll();
	}

	@Override
	@Transactional
	public ActivityModel getDetailsByActivityId(final String openid,final Long activityId){
		ActivityBean activity = activityDao.getOne(activityId);
		UserBean user = userDao.getByOpenid(openid);
		List<ActivityUserBean> activityUserList = activityUserDao.findByActivityId(activityId);
		ActivityModel activityModel = new ActivityModel();
		
		activityModel.setActivityId(activity.getActivityId());
		activityModel.setTitle(activity.getTitle());
		activityModel.setAddress(activity.getAddress());
		activityModel.setStartTime(activity.getStartTime());
		activityModel.setEndTime(activity.getEndTime());
		activityModel.setLatitude(activity.getLatitude());
		activityModel.setLongitude(activity.getLongitude());
		activityModel.setCost(activity.getCost());
		activityModel.setCreateTime(activity.getCreateTime());
		activityModel.setDescription(activity.getDescription());
		activityModel.setMaxPeople(activity.getMaxPeople());
		activityModel.setMinPeople(activity.getMinPeople());
		activityModel.setNowPeople(activity.getNowPeople());
		activityModel.setTelphone(activity.getTelphone());
		activityModel.setType(activity.getType());
		activityModel.setCreater(activity.getUser());
		
		List<UserBean> userList = new ArrayList<>();
		for(ActivityUserBean activityUser : activityUserList){
			if(activityUser.getUser().getOpenid().equals(user.getOpenid())){
				activityModel.setState(true);
			}
			userList.add(activityUser.getUser());
		}
		activityModel.setUserList(userList);
		
		return activityModel;
	}
	
	@Override
	@Transactional
	public void joinActivity(final String openid,final Long activityId){
		ActivityBean activity = activityDao.getOne(activityId);
		UserBean user = userDao.getByOpenid(openid);
		ActivityUserBean activityUser = new ActivityUserBean();
		activityUser.setActivity(activity);
		activityUser.setUser(user);
		activityUserDao.saveAndFlush(activityUser);
		activity.setNowPeople(activity.getNowPeople().add(BigDecimal.ONE));
		activityDao.saveAndFlush(activity);
	}
}
