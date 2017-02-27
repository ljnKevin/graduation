package com.school.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noteBook")
public class NoteBookController {
  
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String getCashWalletHoldings(){
		return "hello AV8D";
	}
}
