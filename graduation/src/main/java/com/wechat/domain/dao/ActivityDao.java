package com.wechat.domain.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.ActivityBean;


public interface ActivityDao extends JpaRepository<ActivityBean, Long> {

	@Query("select a from ActivityBean a where a.activityId=?1")
    public ActivityBean getById(Long id);
	

}
