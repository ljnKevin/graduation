package com.wechat.mvc;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.service.NoteBookService;

@RestController
@RequestMapping("/noteBook")
public class NoteBookController {
  
	@Inject
	private NoteBookService noteBookService;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	  String hello() {
		  return "hello";
	  }
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addNoteBookItem(@RequestParam("openid") String openid,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("createTime") Long createTime,@RequestParam("updateTime") Long updateTime) {
	      NoteBookItemBean item = new NoteBookItemBean();
	      Date date = new Date();
	      date.setTime(createTime);
	      item.setCreateTime(date);
	      date.setTime(updateTime);
	      item.setUpdateTime(date);
	      item.setContent(content);
	      item.setTitle(title);
	      
	      noteBookService.addNoteBookItem(item,openid);
		  return true;
	  }
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	  boolean updateNoteBookItem(@RequestParam("noteBookItemId") Long noteBookItemId,@RequestParam("title") String title,@RequestParam("content") String content) {
	      NoteBookItemBean item = noteBookService.getByNoteBookItemId(noteBookItemId);
	      Date now = new Date();
	      item.setUpdateTime(now);
	      
	      item.setContent(content);
	      item.setTitle(title);
	      
	      noteBookService.updateNoteBookItem(item);
		  return true;
	  }
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	  boolean deleteNoteBookItem(@RequestParam("noteBookItemId") Long noteBookItemId) {
	      noteBookService.deleteNoteBookItem(noteBookItemId);
		  return true;
	  }
	
	@RequestMapping(value="/findAllByOpenid",method=RequestMethod.POST)
	  List<NoteBookItemBean> findAllByWechatName(@RequestParam("openid") String openid) {
	      
		  return noteBookService.findAllByOpenid(openid);
	  }
	
	@RequestMapping(value="/getByNoteBookItemId",method=RequestMethod.POST)
	  NoteBookItemBean getByNoteBookItemId(@RequestParam("noteBookItemId") Long noteBookItemId) {
	      
		  return noteBookService.getByNoteBookItemId(noteBookItemId);
	  }
}
