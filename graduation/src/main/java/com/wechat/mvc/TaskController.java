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
@RequestMapping("/task")
public class TaskController {
  
	@Inject
	private NoteBookService noteBookService;
	
//	@RequestMapping(value="/add",method=RequestMethod.POST)
//	  boolean addNoteBookItem(@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("createTime") Long createTime,@RequestParam("updateTime") Long updateTime) {
//	      NoteBookItemBean item = new NoteBookItemBean();
//	      Date createDate = new Date(createTime);
//	      Date updateDate = new Date(updateTime);
//	      item.setCreateTime(createDate);
//	      item.setUpdateTime(updateDate);
//	      item.setContent(content);
//	      item.setTitle(title);
//	      
//	      noteBookService.addNoteBookItem(item);
//		  return true;
//	  }
}
