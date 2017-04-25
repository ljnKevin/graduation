package com.wechat.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.UserDao;
import com.wechat.domain.dao.WalletDao;
import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.UserBean;
import com.wechat.domain.entity.WalletBean;
import com.wechat.service.NoteBookService;
import com.wechat.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService{

	@Inject
	private WalletDao walletDao;
	
	@Inject
	private UserDao userDao;
	
	@Override
	@Transactional
	public void addWallet(WalletBean wallet,String openid) {
		UserBean user = userDao.getByOpenid(openid);
		wallet.setUser(user);
		walletDao.saveAndFlush(wallet);
	}
	
//	@Override
//	@Transactional
//	public void updateNoteBookItem(NoteBookItemBean noteBookItem) {
//		noteBookItemDao.saveAndFlush(noteBookItem);
//	}
//
//	@Override
//	@Transactional
//	public void deleteNoteBookItem(Long noteBookItemId) {
//		noteBookItemDao.delete(noteBookItemId);
//	}
//	
//	@Override
//	@Transactional
//	public List<NoteBookItemBean> findAllByOpenid(String openid) {
//		return noteBookItemDao.findAllByOpenid(openid);
//	}
//	
//	@Override
//	@Transactional
//	public NoteBookItemBean getByNoteBookItemId(Long noteBookItemId) {
//		return noteBookItemDao.getById(noteBookItemId);
//	}
}
