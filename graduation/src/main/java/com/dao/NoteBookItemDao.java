package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.NoteBookItemBean;

public interface NoteBookItemDao extends JpaRepository<NoteBookItemBean, Long> {

	@Query("select a from NoteBookItemBean  a where a.noteBookItemId=?1")
    public NoteBookItemBean getById(Long id);
	

}
