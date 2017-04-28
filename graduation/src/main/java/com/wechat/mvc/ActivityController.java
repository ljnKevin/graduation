package com.wechat.mvc;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.TaskBean;
import com.wechat.domain.model.ActivityModel;
import com.wechat.service.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {
  
	@Inject
	private ActivityService activityService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addActivity(@RequestParam("openid") String openid,@RequestParam("title") String title,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,@RequestParam("minPeople") BigDecimal minPeople,@RequestParam("address") String address,@RequestParam("latitude") String latitude,@RequestParam("longitude") String longitude,@RequestParam("cost") BigDecimal cost,@RequestParam("telphone") String telphone,@RequestParam("description") String description) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		
		ActivityBean activity  = new ActivityBean();
		activity.setTitle(title);
		activity.setCreateTime(date);
		date = sdf.parse(startTime);
		activity.setStartTime(date);
		date = sdf.parse(endTime);
		activity.setEndTime(date);
		activity.setMinPeople(minPeople);
		activity.setAddress(address);
		activity.setLatitude(latitude);
		activity.setLongitude(longitude);
		activity.setTelphone(telphone);
		activity.setCost(cost);
		activity.setDescription(description);
		
		activity.setNowPeople(BigDecimal.ONE);
		activityService.addActivity(activity,openid);
		return true;
	  }
	
	@RequestMapping(value="/findAllCreateByOpenid",method=RequestMethod.POST)
	  List<ActivityBean> findAllCreateByOpenid(@RequestParam("openid") String openid) {
			
		  return activityService.findAllCreateByOpenid(openid);
	  }
	
	@RequestMapping(value="/findAllJoinByOpenid",method=RequestMethod.POST)
	  List<ActivityBean> findAllJoinByOpenid(@RequestParam("openid") String openid) {
		  return activityService.findAllJoinByOpenid(openid);
	  }
	
	@RequestMapping(value="/details",method=RequestMethod.POST)
	ActivityModel details(@RequestParam("openid") String openid,@RequestParam("activityId") Long activityId,@RequestParam("myLon") double myLon,@RequestParam("myLat") double myLat) {
		ActivityModel activityModel = activityService.getDetailsByActivityId(openid,activityId,myLon,myLat);
			
		  return activityModel;
	  }
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	void join(@RequestParam("openid") String openid,@RequestParam("activityId") Long activityId) {
		activityService.joinActivity(openid,activityId);
	  }
	
	@RequestMapping(value="/findAll",method=RequestMethod.POST)
	  List<ActivityBean> findAll() {
		
		  return activityService.findAll();
	  }
}
