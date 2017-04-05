package com.school.mvc;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {
  
	@Inject
	private ActivityService activityService;
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String test(){
		return "hello AV8D";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addNoteBookItem() {
//	      NoteBookItemBean item = new NoteBookItemBean();
//	      Date createDate = new Date(createTime);
//	      Date updateDate = new Date(updateTime);
//	      item.setCreateTime(createDate);
//	      item.setUpdateTime(updateDate);
//	      item.setContent(content);
//	      item.setTitle(title);
//	      
//	      noteBookService.addNoteBookItem(item);
		  return true;
	  }
}
