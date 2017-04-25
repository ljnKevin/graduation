package com.wechat.domain.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.ActivityUserBean;
import com.wechat.domain.entity.TaskBean;


public interface ActivityUserDao extends JpaRepository<ActivityUserBean, Long> {

	@Query("select a from ActivityUserBean a where a.user.openid=?1")
	public List<ActivityUserBean> findByUserOpenid(String openid);

	@Query("select a from ActivityUserBean a where a.activity.activityId=?1")
	public List<ActivityUserBean> findByActivityId(Long activityId);
}
