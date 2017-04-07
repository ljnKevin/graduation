package com.wechat.domain.dao;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.TaskBean;


public interface TaskDao extends JpaRepository<TaskBean, Long> {

	@Query("select a from TaskBean  a where a.taskId=?1")
    public TaskBean getById(Long id);
	
	@Query("select t from TaskBean  t where t.user.wechatName=?1")
    public List<TaskBean> findAllByWechatName(String wechatName);
	
	@Query("select t from TaskBean  t where t.user.wechatName=?1 and t.startTime <= ?2 and t.endTime >= ?3")
    public List<TaskBean> findAllActiveByWechatName(String wechatName,Date now);

}
