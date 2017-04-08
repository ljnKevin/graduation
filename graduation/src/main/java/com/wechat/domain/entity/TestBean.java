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
@Table(name="Test")
public class TestBean implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2306300817554580695L;

	@Id
	@Column(name="Test_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Test_seq")
	@SequenceGenerator(name="Test_seq", sequenceName="Test_seq")
	private Long testId;
	
	@Column(name="NAME")
	private String name;

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
