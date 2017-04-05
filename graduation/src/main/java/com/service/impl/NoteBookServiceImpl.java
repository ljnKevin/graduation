package com.service.impl;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.dao.NoteBookItemDao;
import com.entity.NoteBookItemBean;
import com.service.NoteBookService;

public class NoteBookServiceImpl implements NoteBookService{

	@Inject
	private NoteBookItemDao noteBookItemDao;
	
	@Override
	@Transactional
	public void addNoteBookItem(NoteBookItemBean noteBookItem) {
		noteBookItemDao.save(noteBookItem);
	}

}
