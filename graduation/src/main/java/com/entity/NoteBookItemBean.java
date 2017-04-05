package com.entity;

import java.io.Serializable;
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
@Table(name="NOTE_BOOK_ITEM")
public class NoteBookItemBean implements Serializable{
	
	private static final long serialVersionUID = -6135087906044218045L;

	@Id
	@Column(name="NOTEBOOK_ITEM_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NoteBookItem_seq")
	@SequenceGenerator(name="NoteBookItem_seq", sequenceName="NoteBookItem_seq")
	private Long noteBookItemId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="UPDATE_TIME")
	private Date updateTime;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserBean user;

	public Long getNoteBookItemId() {
		return noteBookItemId;
	}

	public void setNoteBookItemId(Long noteBookItemId) {
		this.noteBookItemId = noteBookItemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	
}
