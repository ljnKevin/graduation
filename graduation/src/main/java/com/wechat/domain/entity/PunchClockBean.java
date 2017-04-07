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
public class PunchClockBean implements Serializable{
	
	private static final long serialVersionUID = -1080307825061654607L;

	@Id
	@Column(name="PUNCH_CLOCK_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PUNCH_CLOCK_seq")
	@SequenceGenerator(name="PUNCH_CLOCK_seq", sequenceName="PUNCH_CLOCK_seq")
	private Long punchClockId;
	
	@Column(name="TITLE")
	private String type;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="LOCATION")
	private String location;
	
	@ManyToOne
	@JoinColumn(name="TASK_ID")
	private TaskBean task;

	public Long getPunchClockId() {
		return punchClockId;
	}

	public void setPunchClockId(Long punchClockId) {
		this.punchClockId = punchClockId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public TaskBean getTask() {
		return task;
	}

	public void setTask(TaskBean task) {
		this.task = task;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
