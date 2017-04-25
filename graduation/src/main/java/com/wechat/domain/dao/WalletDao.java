package com.wechat.domain.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.WalletBean;

public interface WalletDao extends JpaRepository<WalletBean, Long> {

	@Query("select a from NoteBookItemBean  a where a.user.openid=?1")
    public List<NoteBookItemBean> findAllByOpenid(String openid);


}
