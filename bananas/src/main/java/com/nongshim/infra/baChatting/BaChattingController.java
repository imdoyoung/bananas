package com.nongshim.infra.baChatting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaChattingController {
	
	// 채팅
	@RequestMapping(value="/usr/v1/infra/chatting/baChatting")
	public String baChatting() {
		return "/usr/v1/infra/chatting/baChatting";
	}

}
