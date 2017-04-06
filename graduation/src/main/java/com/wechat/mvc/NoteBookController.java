package com.wechat.mvc;

import java.util.Date;

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
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addNoteBookItem(@RequestParam("wechatName") String wechatName,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("createTime") String createTime,@RequestParam("updateTime") String updateTime) {
	      NoteBookItemBean item = new NoteBookItemBean();
	      Date createDate = new Date(createTime);
	      Date updateDate = new Date(updateTime);
	      item.setCreateTime(createDate);
	      item.setUpdateTime(updateDate);
	      item.setContent(content);
	      item.setTitle(title);
	      
	      noteBookService.addNoteBookItem(item,wechatName);
		  return true;
	  }
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	  boolean updateNoteBookItem(@RequestParam("noteBookItemId") Long noteBookItemId,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("createTime") String createTime,@RequestParam("updateTime") String updateTime) {
	      NoteBookItemBean item = new NoteBookItemBean();
	      item.setNoteBookItemId(noteBookItemId);
	      Date createDate = new Date(createTime);
	      Date updateDate = new Date(updateTime);
	      item.setCreateTime(createDate);
	      item.setUpdateTime(updateDate);
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
	
	@RequestMapping(value="/findAllByWechatName",method=RequestMethod.POST)
	  boolean findAllByWechatName(@RequestParam("wechatName") String wechatName) {
	      noteBookService.findAllByWechatName(wechatName);
		  return true;
	  }
}
