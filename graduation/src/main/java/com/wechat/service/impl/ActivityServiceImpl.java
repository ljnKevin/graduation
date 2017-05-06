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

	 private static final  double EARTH_RADIUS = 6378137;//赤道半径(单位m)
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

	public ActivityModel activityBeanToActivityModel(ActivityBean activity,double myLon, double myLat) {
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
		
		double dist = this.LantitudeLongitudeDist(myLon,myLat,Double.valueOf(activity.getLongitude()),Double.valueOf(activity.getLatitude()));
		BigDecimal b = new BigDecimal(dist);  
		dist = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 
		
		activityModel.setDistance(dist);
		
		return activityModel;
	}
	
	@Override
	@Transactional
	public ActivityModel getDetailsByActivityId(final String openid,final Long activityId,String myLon, String myLat){
		ActivityBean activity = activityDao.getOne(activityId);
		UserBean user = userDao.getByOpenid(openid);
		List<ActivityUserBean> activityUserList = activityUserDao.findByActivityId(activityId);
		
		ActivityModel activityModel = activityBeanToActivityModel(activity,Double.parseDouble(myLon),Double.parseDouble(myLat));
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
	
	 /** 
     * 转化为弧度(rad) 
     * */  
    private static double rad(double d)  
    {  
       return d * Math.PI / 180.0;  
    }  
      
    /** 
     * 基于余弦定理求两经纬度距离 
     * @param lon1 第一点的精度 
     * @param lat1 第一点的纬度 
     * @param lon2 第二点的精度 
     * @param lat3 第二点的纬度 
     * @return 返回的距离，单位km 
     * */
	public double LantitudeLongitudeDist(double lon1, double lat1,double lon2, double lat2) {  
        double radLat1 = rad(lat1);  
        double radLat2 = rad(lat2);  
  
        double radLon1 = rad(lon1);  
        double radLon2 = rad(lon2);  
  
        if (radLat1 < 0)  
            radLat1 = Math.PI / 2 + Math.abs(radLat1);// south  
        if (radLat1 > 0)  
            radLat1 = Math.PI / 2 - Math.abs(radLat1);// north  
        if (radLon1 < 0)  
            radLon1 = Math.PI * 2 - Math.abs(radLon1);// west  
        if (radLat2 < 0)  
            radLat2 = Math.PI / 2 + Math.abs(radLat2);// south  
        if (radLat2 > 0)  
            radLat2 = Math.PI / 2 - Math.abs(radLat2);// north  
        if (radLon2 < 0)  
            radLon2 = Math.PI * 2 - Math.abs(radLon2);// west  
        double x1 = EARTH_RADIUS * Math.cos(radLon1) * Math.sin(radLat1);  
        double y1 = EARTH_RADIUS * Math.sin(radLon1) * Math.sin(radLat1);  
        double z1 = EARTH_RADIUS * Math.cos(radLat1);  
  
        double x2 = EARTH_RADIUS * Math.cos(radLon2) * Math.sin(radLat2);  
        double y2 = EARTH_RADIUS * Math.sin(radLon2) * Math.sin(radLat2);  
        double z2 = EARTH_RADIUS * Math.cos(radLat2);  
  
        double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)+ (z1 - z2) * (z1 - z2));  
        //余弦定理求夹角  
        double theta = Math.acos((EARTH_RADIUS * EARTH_RADIUS + EARTH_RADIUS * EARTH_RADIUS - d * d) / (2 * EARTH_RADIUS * EARTH_RADIUS));  
        double dist = theta * EARTH_RADIUS;  
        return dist;  
    }
}
