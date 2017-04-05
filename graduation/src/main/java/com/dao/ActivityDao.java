package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.ActivityBean;


public interface ActivityDao extends JpaRepository<ActivityBean, Long> {

	@Query("select * from ActivityBean where activityId=?1")
    public ActivityBean getById(Long id);
	

}
