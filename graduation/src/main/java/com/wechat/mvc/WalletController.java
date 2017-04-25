package com.wechat.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.domain.entity.NoteBookItemBean;
import com.wechat.domain.entity.WalletBean;
import com.wechat.service.NoteBookService;
import com.wechat.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
  
	@Inject
	private WalletService walletService;
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addNoteBookItem(@RequestParam("openid") String openid,@RequestParam("title") String title,@RequestParam("remark") String remark,@RequestParam("billDate") String billDate,@RequestParam("category") String category,@RequestParam("billType") String billType,@RequestParam("money") String money) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();  
		WalletBean item = new WalletBean();
		date = sdf.parse(billDate);
	      item.setBillDate(date);
	      switch : 
	      item.setBillWeek(billWeek);
	      item.setRemark(remark);
	      item.setTitle(title);
	      
	      walletService.addWallet(item,openid);
		  return true;
	  }
	
//	@RequestMapping(value="/update",method=RequestMethod.POST)
//	  boolean updateNoteBookItem(@RequestParam("noteBookItemId") Long noteBookItemId,@RequestParam("title") String title,@RequestParam("content") String content) {
//	      NoteBookItemBean item = noteBookService.getByNoteBookItemId(noteBookItemId);
//	      Date now = new Date();
//	      item.setUpdateTime(now);
//	      
//	      item.setContent(content);
//	      item.setTitle(title);
//	      
//	      noteBookService.updateNoteBookItem(item);
//		  return true;
//	  }
//	
//	@RequestMapping(value="/delete",method=RequestMethod.POST)
//	  boolean deleteNoteBookItem(@RequestParam("noteBookItemId") Long noteBookItemId) {
//	      noteBookService.deleteNoteBookItem(noteBookItemId);
//		  return true;
//	  }
//	
//	@RequestMapping(value="/findAllByOpenid",method=RequestMethod.POST)
//	  List<NoteBookItemBean> findAllByWechatName(@RequestParam("openid") String openid) {
//	      
//		  return noteBookService.findAllByOpenid(openid);
//	  }
//	
//	@RequestMapping(value="/getByNoteBookItemId",method=RequestMethod.POST)
//	  NoteBookItemBean getByNoteBookItemId(@RequestParam("noteBookItemId") Long noteBookItemId) {
//	      
//		  return noteBookService.getByNoteBookItemId(noteBookItemId);
//	  }
}
