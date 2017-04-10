package com.wechat.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="USER_INFO")
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = -1080307825061654607L;

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="User_seq")
	@SequenceGenerator(name="User_seq", sequenceName="User_seq")
	private Long userId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="WECHATNAME")
	private String wechatName;
	
	@Column(name="SEX")
	private String sex;
	
	@Column(name="UNIVRSITY")
	private String univrsity;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="OPENID")
	private String openid;
	
	@OneToMany
	@JoinColumn(name="NOTEBOOK_ITEM_ID")
	private Set<NoteBookItemBean> noteBookItems;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUnivrsity() {
		return univrsity;
	}

	public void setUnivrsity(String univrsity) {
		this.univrsity = univrsity;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<NoteBookItemBean> getNoteBookItems() {
		return noteBookItems;
	}

	public void setNoteBookItems(Set<NoteBookItemBean> noteBookItems) {
		this.noteBookItems = noteBookItems;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
