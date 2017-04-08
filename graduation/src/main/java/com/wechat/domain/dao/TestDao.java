package com.wechat.domain.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.TestBean;
import com.wechat.domain.entity.UserBean;


public interface TestDao extends JpaRepository<TestBean, Long> {

	
}
