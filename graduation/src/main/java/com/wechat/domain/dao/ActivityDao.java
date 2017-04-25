package com.wechat.domain.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.TaskBean;


public interface ActivityDao extends JpaRepository<ActivityBean, Long> {

	@Query("select a from ActivityBean a where a.activityId=?1")
    public ActivityBean getById(Long id);
	

	@Query("select a from ActivityBean a where a.user.openid=?1")
    public List<ActivityBean> findAllByOpenid(String openid);
}
