package com.wechat.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.NoteBookItemDao;
import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.service.NoteBookService;

@Service
public class NoteBookServiceImpl implements NoteBookService{

	@Inject
	private NoteBookItemDao noteBookItemDao;
	
	@Override
	@Transactional
	public void addNoteBookItem(NoteBookItemBean noteBookItem) {
		noteBookItemDao.save(noteBookItem);
	}

}
