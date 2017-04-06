package com.wechat.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ACTIVITY")
public class ActivityBean implements Serializable{
	
	private static final long serialVersionUID = -1080307825061654607L;

	@Id
	@Column(name="ACITVITY_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Acitvity_seq")
	@SequenceGenerator(name="Acitvity_seq", sequenceName="Acitvity_seq")
	private Long activityId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="START_TIME")
	private Date startTime;
	
	@Column(name="END_TIME")
	private Date endTime;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="MIN_PEOPLE")
	private BigDecimal minPeople;
	
	@Column(name="MAX_PEOPLE")
	private BigDecimal maxPeople;
	
	@Column(name="NOW_PEOPLE")
	private BigDecimal nowPeople;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="STATE")
	private String state;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserBean user;

	

	

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	
	
}
