package com.nongshim.infra.baMeetPoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaMeetPointController {
	
	// 중간지점찾기 페이지
	@RequestMapping(value="/usr/v1/infra/baMeetPoint/baMeetPoint")
	public String baMeetPoint() {
		return "/usr/v1/infra/baMeetPoint/baMeetPoint";
	}

}
 