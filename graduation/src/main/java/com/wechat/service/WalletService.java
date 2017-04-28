package com.wechat.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.WalletBean;

@WebService
public interface WalletService {
	
	void addWallet(@WebParam(name = "wallet") final WalletBean wallet,@WebParam(name = "openid") final String openid);
	void updateWallet(@WebParam(name = "wallet") final WalletBean wallet);
	void deleteWallet(@WebParam(name = "walletId") final Long walletId);
	List<WalletBean> findAllByOpenid(@WebParam(name = "openid") final String openid);
	List<WalletBean> findByKeyword(@WebParam(name = "keyword") final String keyword);
	WalletBean getByWalletId(@WebParam(name = "walletId") final Long walletId);
}
