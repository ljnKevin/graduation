package com.wechat.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.TaskBean;
import com.wechat.domain.model.ActivityModel;
import com.wechat.domain.model.TaskModel;

@WebService
public interface ActivityService {
	
	void addActivity(@WebParam(name = "activity") final ActivityBean activity,String openid);
	List<ActivityBean> findAllCreateByOpenid(@WebParam(name = "openid") final String openid);
	List<ActivityBean> findAllJoinByOpenid(@WebParam(name = "openid") final String openid);
	List<ActivityBean> findAll();
	ActivityModel getDetailsByActivityId(@WebParam(name = "openid") final String openid,@WebParam(name = "activityId") final Long activityId);
	void joinActivity(@WebParam(name = "openid") final String openid,@WebParam(name = "activityId") final Long activityId);
}
