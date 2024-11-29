package com.nongshim.infra.baMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaMemberController {
	
	@Autowired
	BaMemberService baMemberService;
	
	@RequestMapping(value="/usr/v1/infra/baMember/baMemberUsrMform")
	public String baMemberUsrMform(BaMemberDto baMemberDto, Model model) {
		model.addAttribute("memberItem", baMemberService.memberSelectOne(baMemberDto));
		return "usr/v1/infra/baMember/baMemberUsrMform";
	}
	
	@RequestMapping(value="/usr/v1/infra/baMember/baMemberUsrInst")
	public String baMemberUsrInst(BaMemberDto baMemberDto) {
		baMemberService.memberInsert(baMemberDto);
		return "redirect:/usr/v1/infra/common/baUsrSignIn";
	}
	
	@RequestMapping(value="/usr/v1/infra/baMember/baMemberUsrUpdt")
	public String baMemberUsrUpdt(BaMemberDto baMemberDto) {
		baMemberService.memberUpdate(baMemberDto);
		return "redirect:/usr/v1/infra/mypage/baUsrMypage";
	}
	
}
