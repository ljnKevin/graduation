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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="WALLET")
public class WalletBean implements Serializable{
	
	private static final long serialVersionUID = 4967407063764093268L;

	@Id
	@Column(name="WALLET_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WALLET_SEQ")
	@SequenceGenerator(name="WALLET_SEQ", sequenceName="WALLET_SEQ")
	private Long walletId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="BILL_DATE")
	private Date billDate;
	
	@Column(name="BILL_CAT")
	private String billCat;
	
	@Column(name="BILL_TYPE")
	private String billType;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="BILL_WEEK")
	private String billWeek;
	
	@Column(name="MONEY")
	private BigDecimal money;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserBean user;

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getBillCat() {
		return billCat;
	}

	public void setBillCat(String billCat) {
		this.billCat = billCat;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getBillWeek() {
		return billWeek;
	}

	public void setBillWeek(String billWeek) {
		this.billWeek = billWeek;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
