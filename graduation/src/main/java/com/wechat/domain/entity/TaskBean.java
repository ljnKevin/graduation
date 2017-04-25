package com.wechat.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TASK")
public class TaskBean implements Serializable{
	
	private static final long serialVersionUID = -1080307825061654607L;

	public enum TaskStatus 
	{
		COMPLETED("completed"), 
		VOID("void"), 
		ACTIVE("active"),
		CANCELED("canceled");
		private final String value;

		private TaskStatus(final String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}

		public static TaskStatus resolve(final String value) 
		{
			for (final TaskStatus s : EnumSet.allOf(TaskStatus.class)) {
				if (s.toString().equals(value)) {
					return s;
				}
			}
			return VOID;
		}
	}
	
	public enum TaskCycle 
	{
		DAILY("daily"), 
		WEEKLY("weekly"), 
		MONTHLY("monthly");
		
		private final String value;

		private TaskCycle(final String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}

		public static TaskCycle resolve(final String value) 
		{
			for (final TaskCycle s : EnumSet.allOf(TaskCycle.class)) {
				if (s.toString().equals(value)) {
					return s;
				}
			}
			return DAILY;
		}
	}
	
	@Id
	@Column(name="TASK_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASK_SEQ")
	@SequenceGenerator(name="TASK_SEQ", sequenceName="TASK_SEQ")
	private Long taskId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE")
	private String longitude;
	
	@Column(name="START_TIME")
	private Date startTime;
	
	@Column(name="END_TIME")
	private Date endTime;
	
	@Column(name="CYCLE")
	private String cycle;
	
	@Column(name="CYCLE_DATE")
	private String cycleDate;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="LAST_ADDRESS")
	private String lastAddress;
	
	@Column(name="LAST_LATITUDE")
	private String lastLatitude;
	
	@Column(name="LAST_LONGITUDE")
	private String lastLongitude;
	
	@Column(name="LAST_DATE")
	private Date lastDate;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserBean user;

	
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

	public String getCycleDate() {
		return cycleDate;
	}

	public void setCycleDate(String cycleDate) {
		this.cycleDate = cycleDate;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLastAddress() {
		return lastAddress;
	}

	public void setLastAddress(String lastAddress) {
		this.lastAddress = lastAddress;
	}

	public String getLastLatitude() {
		return lastLatitude;
	}

	public void setLastLatitude(String lastLatitude) {
		this.lastLatitude = lastLatitude;
	}

	public String getLastLongitude() {
		return lastLongitude;
	}

	public void setLastLongitude(String lastLongitude) {
		this.lastLongitude = lastLongitude;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	
	
}
