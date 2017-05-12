package com.wechat.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="PUNCH_CLOCK")
public class PunchClockBean implements Serializable{
	
	private static final long serialVersionUID = -1080307825061654607L;

	@Id
	@Column(name="PUNCH_CLOCK_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PUNCH_CLOCK_SEQ")
	@SequenceGenerator(name="PUNCH_CLOCK_SEQ", sequenceName="PUNCH_CLOCK_SEQ")
	private Long punchClockId;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="HUMOR")
	private String humor;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE")
	private String longitude;
	
	@ManyToOne()
	@JoinColumn(name="TASK_ID")
	private TaskBean task;

	public Long getPunchClockId() {
		return punchClockId;
	}

	public void setPunchClockId(Long punchClockId) {
		this.punchClockId = punchClockId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getHumor() {
		return humor;
	}

	public void setHumor(String humor) {
		this.humor = humor;
	}

	public TaskBean getTask() {
		return task;
	}

	public void setTask(TaskBean task) {
		this.task = task;
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
	

	
}
