package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="NOTE_BOOK_ITEM")
public class NoteBookItem implements Serializable{
	
	private static final long serialVersionUID = 7374501915335081457L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	private String title;
	private String content;
	private Date createDate;
	private Date updateDate;
	private Long openId;
	
	public Long getOpenId() {
		return openId;
	}
	public void setOpenId(Long openId) {
		this.openId = openId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
