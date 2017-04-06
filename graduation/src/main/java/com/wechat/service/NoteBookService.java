package com.wechat.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.wechat.domain.entity.NoteBookItemBean;

@WebService
public interface NoteBookService {
	
	void addNoteBookItem(@WebParam(name = "noteBookItem") final NoteBookItemBean noteBookItem);

}
