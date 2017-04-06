package com.wechat.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.wechat.domain.entity.NoteBookItemBean;

@WebService
public interface NoteBookService {
	
	void addNoteBookItem(@WebParam(name = "noteBookItem") final NoteBookItemBean noteBookItem,@WebParam(name = "wechatName") final String wechatName);
	void updateNoteBookItem(@WebParam(name = "noteBookItem") final NoteBookItemBean noteBookItem);
	void deleteNoteBookItem(@WebParam(name = "noteBookItemId") final Long noteBookItemId);
	List<NoteBookItemBean> findAllByWechatName(@WebParam(name = "wechatName") final String wechatName);
}
