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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ACTIVITY_USER")
public class ActivityUserBean implements Serializable{
	
	private static final long serialVersionUID = 1790793245171255362L;

	@Id
	@Column(name="ACTIVITY_USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVITY_USER_SEQ")
	@SequenceGenerator(name="ACTIVITY_USER_SEQ", sequenceName="ACTIVITY_USER_SEQ")
	private Long activityUserid;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserBean user;

	@OneToOne
	@JoinColumn(name="ACTIVITY_ID")
	private ActivityBean activity;

	public Long getActivityUserid() {
		return activityUserid;
	}

	public void setActivityUserid(Long activityUserid) {
		this.activityUserid = activityUserid;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public ActivityBean getActivity() {
		return activity;
	}

	public void setActivity(ActivityBean activity) {
		this.activity = activity;
	}

}
