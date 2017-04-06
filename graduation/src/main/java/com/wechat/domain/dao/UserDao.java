package com.wechat.domain.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.UserBean;


public interface UserDao extends JpaRepository<UserBean, Long> {

	@Query("select u from UserBean u where u.wechatName=?1")
    public UserBean getByWechatName(String wechatName);
}
