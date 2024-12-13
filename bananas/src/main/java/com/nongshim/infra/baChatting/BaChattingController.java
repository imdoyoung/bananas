package com.nongshim.infra.baChatting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaChattingController {
	
	// 채팅
	@RequestMapping(value="/usr/v1/infra/chatting/baChatting")
	public String baChatting() {
		return "usr/v1/infra/chatting/baChatting";
	}
	
	// 채팅 테스트
	@RequestMapping(value="/chatting/testchat")
	public String testchat() {
		return "usr/v1/infra/chatting/testchat";
	}

}
//sssss 나는 왜 커밋이 안돼는건데!!!!!