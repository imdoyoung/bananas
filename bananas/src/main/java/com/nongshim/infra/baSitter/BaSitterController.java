package com.nongshim.infra.baSitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaSitterController {
	
	@Autowired
	BaSitterService baSitterService;
	
	// 관리자 - 시터 페이지
	@RequestMapping(value="/xdm/v1/infra/baSitter/baSitterXdmList")
	public String baSitterXdmList() {
		return "xdm/v1/infra/baSitter/baSitterXdmList";
	}

}
