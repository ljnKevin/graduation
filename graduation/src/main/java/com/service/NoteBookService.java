package com.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.entity.NoteBookItemBean;

@WebService
public interface NoteBookService {
	
	void addNoteBookItem(@WebParam(name = "noteBookItem") final NoteBookItemBean noteBookItem);

}
