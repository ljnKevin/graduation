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
	
	@Id
	@Column(name="TASK_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Task_seq")
	@SequenceGenerator(name="Task_seq", sequenceName="Task_seq")
	private Long taskId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="START_TIME")
	private Date startTime;
	
	@Column(name="END_TIME")
	private Date endTime;
	
	@Column(name="SIGN_TIME")
	private Date signTime;
	
	@Column(name="LONGITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE")
	private int longitude;
	
	@Column(name="CYCLE")
	private String cycle;
	
	@Column(name="CYCLE_DATE")
	private int cycleDate;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="REMARK")
	private String remark;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserBean user;

	
	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCycleDate() {
		return cycleDate;
	}

	public void setCycleDate(int cycleDate) {
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

	
}
