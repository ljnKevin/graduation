package com.wechat.mvc;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.UserBean;
import com.wechat.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  
	@Inject
	private UserService userService;
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addNoteBookItem(@RequestParam("name") String name,@RequestParam("wechatName") String wechatName,@RequestParam("sex") String sex,@RequestParam("university") String university,@RequestParam("department") String department,@RequestParam("openid") String openid) {
	      UserBean user = new UserBean();
	      user.setName(name);
	      user.setWechatName(wechatName);
	      user.setSex(sex);
	      user.setUniversity(university);
	      user.setDepartment(department);
	      user.setOpenid(openid);
	      userService.addUser(user);
		  return true;
	  }
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	  boolean addNoteBookItem(@RequestParam("name") String name,@RequestParam("university") String university,@RequestParam("department") String department,@RequestParam("userId") Long userId) {
	      UserBean user = userService.getByUserId(userId);
	      user.setName(name);
	      user.setUniversity(university);
	      user.setDepartment(department);
	      userService.updateUser(user);
		  return true;
	  }
	
	@RequestMapping(value="/validate-user",method=RequestMethod.POST)
	  void validateUser(@RequestParam("openid") String openid) {
	      
	      UserBean user = userService.getUserByOpenid(openid);
	      if(user == null){
	    	  user = new UserBean();
		      
		      user.setOpenid(openid);
		      userService.addUser(user);
	      }
	  }
	
	@RequestMapping(value="/get-by-openid",method=RequestMethod.POST)
	UserBean getByOpenid(@RequestParam("openid") String openid) {
	      
	      return userService.getUserByOpenid(openid);
	      
	  }
}
