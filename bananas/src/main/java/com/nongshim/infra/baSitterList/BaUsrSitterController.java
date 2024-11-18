package com.nongshim.infra.baSitterList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BaUsrSitterController {
	@Autowired
	BaUsrSitterService baUsrSitterService;
	
	
	//시터 입력창
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterForm")
	public String baUsrSitterForm() {
		return "/usr/v1/infra/baSitter/baUsrSitterForm";
	}
	//시터 리스트
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterList")
	public String baUsrSitterList(Model model) {
		model.addAttribute("list", baUsrSitterService.selectList());

		return "/usr/v1/infra/baSitter/baUsrSitterList";
	}
	//시터 insert
		@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterInst")
		public String baUsrSitterInst(BaUsrSitterDto baUsrSitterDto) {
			 baUsrSitterService.sitterInsert(baUsrSitterDto);

			return "/usr/v1/infra/baSitter/baUsrSitterList";
		}
	
	//시터 상세보기
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterDetail")
	public String baUsrSitterDetail(BaUsrSitterDto baUsrSitterDto, Model model) {
		model.addAttribute("item", baUsrSitterService.selectOne(baUsrSitterDto));
		return "/usr/v1/infra/baSitter/baUsrSitterDetail";
	}
	
	//시터 예약하기
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterReservate")
	public String baUsrSitterReservate() {
		return "/usr/v1/infra/baSitter/baUsrSitterReservate";
	}
    
}
