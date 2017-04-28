package com.wechat.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.wechat.domain.entity.UserBean;


public class ActivityModel implements Serializable{
	
	private static final long serialVersionUID = -3296665202817288877L;

	private Long activityId;
	
	private String title;
	
	private String address;
	
	private String latitude;
	
	private String longitude;
	
	private Date startTime;
	
	private Date endTime;
	
	private Date createTime;
	
	private BigDecimal minPeople;
	
	private BigDecimal maxPeople;
	
	private BigDecimal nowPeople;
	
	private String type;
	
	private BigDecimal cost;
	
	private String telphone;
	
	private String description;
	
	private boolean state;

	private UserBean creater;
	
	private List<UserBean> userList;
	
	private double distance;
	
	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getMinPeople() {
		return minPeople;
	}

	public void setMinPeople(BigDecimal minPeople) {
		this.minPeople = minPeople;
	}

	public BigDecimal getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(BigDecimal maxPeople) {
		this.maxPeople = maxPeople;
	}

	public BigDecimal getNowPeople() {
		return nowPeople;
	}

	public void setNowPeople(BigDecimal nowPeople) {
		this.nowPeople = nowPeople;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public List<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}

	public UserBean getCreater() {
		return creater;
	}

	public void setCreater(UserBean creater) {
		this.creater = creater;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	
}
