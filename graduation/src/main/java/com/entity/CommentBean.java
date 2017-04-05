package com.entity;

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
@Table(name="COMMENT")
public class CommentBean implements Serializable{
	
	private static final long serialVersionUID = -1080307825061654607L;

	@Id
	@Column(name="COMMENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Comment_seq")
	@SequenceGenerator(name="Comment_seq", sequenceName="Comment_seq")
	private Long commentId;
	
	@Column(name="LIKE_COUNT")
	private BigDecimal likeCount;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="CONTENT")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserBean user;

	@ManyToOne
	@JoinColumn(name="NOTEBOOK_ITEM_ID")
	private NoteBookItemBean noteBookItem;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public BigDecimal getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(BigDecimal likeCount) {
		this.likeCount = likeCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public NoteBookItemBean getNoteBookItem() {
		return noteBookItem;
	}

	public void setNoteBookItem(NoteBookItemBean noteBookItem) {
		this.noteBookItem = noteBookItem;
	}
	
	
	
}
