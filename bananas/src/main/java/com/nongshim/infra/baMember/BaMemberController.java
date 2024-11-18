package com.nongshim.infra.baMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaMemberController {
	
	@Autowired
	BaMemberService baMemberService;
	
	@RequestMapping(value="/usr/v1/infra/baMember/baMemberUsrMform")
	public String baMemberUsrMform() {
		return "/usr/v1/infra/baMember/baMemberUsrMform";
	}

}
