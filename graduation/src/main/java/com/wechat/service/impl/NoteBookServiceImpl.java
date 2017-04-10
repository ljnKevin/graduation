package com.wechat.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.domain.dao.NoteBookItemDao;
import com.wechat.domain.dao.UserDao;
import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.service.NoteBookService;

@Service
public class NoteBookServiceImpl implements NoteBookService{

	@Inject
	private NoteBookItemDao noteBookItemDao;
	
	@Inject
	private UserDao userDao;
	
	@Override
	@Transactional
	public void addNoteBookItem(NoteBookItemBean noteBookItem,String openid) {
		userDao.getByOpenid(openid);
		noteBookItemDao.saveAndFlush(noteBookItem);
	}
	
	@Override
	@Transactional
	public void updateNoteBookItem(NoteBookItemBean noteBookItem) {
		NoteBookItemBean old = noteBookItemDao.getById(noteBookItem.getNoteBookItemId());
		noteBookItem.setUser(old.getUser());
		noteBookItemDao.saveAndFlush(noteBookItem);
	}

	@Override
	@Transactional
	public void deleteNoteBookItem(Long noteBookItemId) {
		noteBookItemDao.delete(noteBookItemId);
	}
	
	@Override
	@Transactional
	public List<NoteBookItemBean> findAllByOpenid(String openid) {
		return noteBookItemDao.findAllByOpenid(openid);
	}
}
