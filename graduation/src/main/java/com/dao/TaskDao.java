package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.TaskBean;


public interface TaskDao extends JpaRepository<TaskBean, Long> {

	@Query("select a from TaskBean  a where a.taskId=?1")
    public TaskBean getById(Long id);
	

}
