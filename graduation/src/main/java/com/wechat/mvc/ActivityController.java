package com.wechat.mvc;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.domain.entity.ActivityBean;
import com.wechat.service.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {
  
	@Inject
	private ActivityService activityService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addActivity(@RequestParam("submitObject") ActivityBean submitObject) throws ParseException {
	 // boolean addActivity(@RequestParam("openid") String openid,@RequestParam("title") String title,@RequestParam("remark") String remark,@RequestParam("createTime") String createTime,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,@RequestParam("minPeople") BigDecimal minPeople,@RequestParam("maxPeople") BigDecimal maxPeople,@RequestParam("nowPeople") BigDecimal nowPeople,@RequestParam("type") String type,@RequestParam("state") String state) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		
//		ActivityBean activity  = new ActivityBean();
//		activity.setTitle(title);
//		activity.setRemark(remark);
//		date = sdf.parse(startTime);
//		activity.setStartTime(date);
//		date = sdf.parse(endTime);
//		activity.setEndTime(date);
//		date = sdf.parse(createTime);
//		activity.setCreateTime(date);
//		activity.setMinPeople(minPeople);
//		activity.setMaxPeople(maxPeople);
//		activity.setNowPeople(nowPeople);
//		activity.setType(type);
//		activity.setState(state);
//		
//		activityService.addActivity(activity,openid);
		return true;
	  }
}
