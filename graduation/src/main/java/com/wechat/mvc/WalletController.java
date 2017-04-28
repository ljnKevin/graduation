package com.wechat.mvc;

import java.math.BigDecimal;
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
import com.wechat.domain.model.WalletModel;
import com.wechat.service.NoteBookService;
import com.wechat.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
  
	@Inject
	private WalletService walletService;
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	  boolean addNoteBookItem(@RequestParam("openid") String openid,@RequestParam("title") String title,@RequestParam("remark") String remark,@RequestParam("billDate") String billDate,@RequestParam("category") String category,@RequestParam("billType") String billType,@RequestParam("money") BigDecimal money) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();  
		WalletBean item = new WalletBean();
		date = sdf.parse(billDate);
	      item.setBillDate(date);
	      switch (item.getBillDate().getDay()){
	      	case 0: item.setBillWeek("星期天");break;
	      	case 1: item.setBillWeek("星期一");break;
	      	case 2: item.setBillWeek("星期二");break;
	      	case 3: item.setBillWeek("星期三");break;
	      	case 4: item.setBillWeek("星期四");break;
	      	case 5: item.setBillWeek("星期五");break;
	      	case 6: item.setBillWeek("星期六");break;
	      }
	      item.setRemark(remark);
	      item.setTitle(title);
	      item.setCategory(category);
	      item.setBillType(billType);
	      item.setMoney(money);
	      walletService.addWallet(item,openid);
		  return true;
	  }
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	  boolean updateNoteBookItem(@RequestParam("walletId") Long walletId,@RequestParam("title") String title,@RequestParam("remark") String remark,@RequestParam("billDate") String billDate,@RequestParam("category") String category,@RequestParam("billType") String billType,@RequestParam("money") BigDecimal money) throws ParseException {
		  WalletBean item = walletService.getByWalletId(walletId);
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();  
	      date = sdf.parse(billDate);
	      item.setBillDate(date);
	      switch (item.getBillDate().getDay()){
	      	case 0: item.setBillWeek("星期天");break;
	      	case 1: item.setBillWeek("星期一");break;
	      	case 2: item.setBillWeek("星期二");break;
	      	case 3: item.setBillWeek("星期三");break;
	      	case 4: item.setBillWeek("星期四");break;
	      	case 5: item.setBillWeek("星期五");break;
	      	case 6: item.setBillWeek("星期六");break;
	      }
	      item.setRemark(remark);
	      item.setTitle(title);
	      item.setCategory(category);
	      item.setBillType(billType);
	      item.setMoney(money);
	      
	      walletService.updateWallet(item);
		  return true;
	  }
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	  boolean deleteWallet(@RequestParam("walletId") Long walletId) {
		walletService.deleteWallet(walletId);
		  return true;
	  }
	
	@RequestMapping(value="/findAllByOpenid",method=RequestMethod.POST)
	  List<WalletBean> findAllByOpenid(@RequestParam("openid") String openid) {
	      
		  return walletService.findAllByOpenid(openid);
	  }
	
	@RequestMapping(value="/getByWalletId",method=RequestMethod.POST)
	WalletModel getByWalletId(@RequestParam("walletId") Long walletId) {
		  WalletBean wallet = walletService.getByWalletId(walletId);
		  WalletModel walletModel = new WalletModel();
		  walletModel.setTitle(wallet.getTitle());
		  walletModel.setMoney(wallet.getMoney());
		  walletModel.setRemark(wallet.getRemark());
		  return walletModel;
	  }
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	  List<WalletBean> search(@RequestParam("keyword") String keyword) {
	      
		  return walletService.findByKeyword(openid);
	  }
}
