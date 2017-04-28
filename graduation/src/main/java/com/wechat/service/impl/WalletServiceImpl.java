package com.wechat.service.impl;

import java.util.ArrayList;
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
	
	@Override
	@Transactional
	public void updateWallet(WalletBean wallet) {
		walletDao.saveAndFlush(wallet);
	}

	@Override
	@Transactional
	public void deleteWallet(Long walletId) {
		walletDao.delete(walletId);
	}
	
	@Override
	@Transactional
	public List<WalletBean> findAllByOpenid(String openid) {
		return walletDao.findAllByOpenid(openid);
	}
	
	@Override
	@Transactional
	public List<WalletBean> findByKeyword(String keyword) {
		List<WalletBean> resultList = new ArrayList<>();
		resultList.addAll(walletDao.findBookByTitle(keyword));
		resultList.addAll(walletDao.findBookByRemark(keyword));
		return resultList;
	}
	
	@Override
	@Transactional
	public WalletBean getByWalletId(Long walletId) {
		return walletDao.getOne(walletId);
	}
}
