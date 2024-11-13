package com.nongshim.infra.baMypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaMypageController {
	
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrMypage")
	public String baUsrMypage() {
		return "/usr/v1/infra/mypage/baUsrMypage";
	}
}
