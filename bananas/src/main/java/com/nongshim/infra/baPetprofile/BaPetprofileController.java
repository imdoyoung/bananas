package com.nongshim.infra.baPetprofile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaPetprofileController {
	
	
	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrForm")
	public String baPetprofileUsrForm() {
		return "/usr/v1/infra/baPetprofile/baPetprofileUsrForm";
	}

	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrMform")
	public String baPetprofileUsrMform() {
		return "/usr/v1/infra/baPetprofile/baPetprofileUsrMform";
	}
}
