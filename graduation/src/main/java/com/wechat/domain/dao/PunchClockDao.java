package com.wechat.domain.dao;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.ActivityBean;
import com.wechat.domain.entity.PunchClockBean;
import com.wechat.domain.entity.TaskBean;


public interface PunchClockDao extends JpaRepository<PunchClockBean, Long> {

	@Query("select p from PunchClockBean  p where p.task.taskId = ?1 and p.createTime=?2")
    public PunchClockBean findByTaskIdAndCreateTime(Long taskId,Date now);

	@Query("select p from PunchClockBean  p where p.task.taskId = ?1")
    public List<PunchClockBean> findByTaskId(Long taskId);
}
