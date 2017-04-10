package com.wechat.domain.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.NoteBookItemBean;

public interface NoteBookItemDao extends JpaRepository<NoteBookItemBean, Long> {

	@Query("select a from NoteBookItemBean  a where a.noteBookItemId=?1")
    public NoteBookItemBean getById(Long id);
	
	@Query("select a from NoteBookItemBean  a where a.user.openid=?1")
    public List<NoteBookItemBean> findAllByOpenid(String openid);


}
