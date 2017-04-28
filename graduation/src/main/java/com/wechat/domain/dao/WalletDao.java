package com.wechat.domain.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.WalletBean;

public interface WalletDao extends JpaRepository<WalletBean, Long> {

	@Query("select w from WalletBean  w where w.user.openid=?1")
    public List<WalletBean> findAllByOpenid(String openid);

	@Query("select w from WalletBean w where b.title like %?1%")
	public List<WalletBean> findBookByTitle(String title);
	
	@Query("select w from WalletBean w where b.remark like %?1%")
	public List<WalletBean> findBookByRemark(String remark);
}
