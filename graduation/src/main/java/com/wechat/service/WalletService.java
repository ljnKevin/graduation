package com.wechat.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.WalletBean;

@WebService
public interface WalletService {
	
	void addWallet(@WebParam(name = "wallet") final WalletBean wallet,@WebParam(name = "openid") final String openid);
//	void updateNoteBookItem(@WebParam(name = "noteBookItem") final NoteBookItemBean noteBookItem);
//	void deleteNoteBookItem(@WebParam(name = "noteBookItemId") final Long noteBookItemId);
//	List<NoteBookItemBean> findAllByOpenid(@WebParam(name = "openid") final String openid);
//	NoteBookItemBean getByNoteBookItemId(@WebParam(name = "noteBookItemId") final Long noteBookItemId);
}
