package com.wechat.domain.entity;

import java.io.Serializable;
import java.util.Date;
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

	@Id
	@Column(name="TASK_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Task_seq")
	@SequenceGenerator(name="Task_seq", sequenceName="Task_seq")
	private Long taskId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CYCLE")
	private String cycle;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="START_TIME")
	private Date startTime;
	
	@Column(name="END_TIME")
	private Date endTime;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserBean user;

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
