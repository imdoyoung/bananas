package com.nongshim.infra.baPetprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaPetprofileController {
	
	@Autowired
	BaPetprofileService baPetprofileService;
	
	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrForm")
	public String baPetprofileUsrForm() {
		return "usr/v1/infra/baPetprofile/baPetprofileUsrForm";
	}

	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrMform")
	public String baPetprofileUsrMform(BaPetprofileDto baPetprofileDto, Model model) {
		model.addAttribute("PetItem", baPetprofileService.PetSelectOne(baPetprofileDto));
		return "usr/v1/infra/baPetprofile/baPetprofileUsrMform";
	}
	
	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrInst")
	public String baPetprofileUsrInst(BaPetprofileDto baPetprofileDto) {
		baPetprofileService.PetInsert(baPetprofileDto);
		return "redirect:/usr/v1/infra/mypage/baUsrMypage";
	}
	
	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrUpdt")
	public String baPetprofileUsrUpdt(BaPetprofileDto baPetprofileDto) {
		baPetprofileService.PetUpdate(baPetprofileDto);
		return "redirect:/usr/v1/infra/mypage/baUsrMypage";
	}
}
