package com.school;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.NoteBookItem;

@RestController
@EnableAutoConfiguration
public class AppleApplication {
  @RequestMapping("/")
     String home() {
         return "Hello World!";
     }
  
  @RequestMapping(value="/save",method=RequestMethod.POST)
  boolean saveNoteBookItem(@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("createTime") Long createTime,@RequestParam("updateTime") Long updateTime) {
      NoteBookItem item = new NoteBookItem();
      Date createDate = new Date(createTime);
      Date updateDate = new Date(updateTime);
      item.setCreateDate(createDate);
      item.setUpdateDate(updateDate);
      item.setContent(content);
      item.setTitle(title);
	  return true;
  }
  
     public static void main(String[] args) {
         SpringApplication.run(AppleApplication.class, args);
     }
}
