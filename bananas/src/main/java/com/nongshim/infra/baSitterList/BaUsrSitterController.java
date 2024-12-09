package com.nongshim.infra.baSitterList;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BaUsrSitterController {
	@Autowired
	BaUsrSitterService baUsrSitterService;
	
	//시터 입력창
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterForm")
	public String baUsrSitterForm() {
		return "usr/v1/infra/baSitter/baUsrSitterForm";
	}
	//시터 리스트
//	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterList")
//	public String baUsrSitterList(Model model) {
//			model.addAttribute("list", baUsrSitterService.selectList());
//			
//		return "usr/v1/infra/baSitter/baUsrSitterList";
//	}
	//시터 insert
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterInst")
	public String baUsrSitterInst(BaUsrSitterDto baUsrSitterDto) {
		 baUsrSitterService.sitterInsert(baUsrSitterDto);
		return "redirect:/usr/v1/infra/baSitter/baUsrSitterList";
	}
	
	//시터 상세보기
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterDetails")
	public String baUsrSitterDetail(BaUsrSitterDto baUsrSitterDto, Model model) {
		model.addAttribute("item", baUsrSitterService.selectOne(baUsrSitterDto));
		model.addAttribute("relist", baUsrSitterService.reSelectList());
		model.addAttribute("oplist", baUsrSitterService.opSelectList());
		
		
		return "usr/v1/infra/baSitter/baUsrSitterDetails";
	}
	
	//review insert
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrReInst")
	public String baUsrReInst(BaUsrSitterDto baUsrSitterDto) {
		System.out.println("별점 : " + baUsrSitterDto.getBareStar());
		 baUsrSitterService.reInsert(baUsrSitterDto);
		return "/usr/v1/infra/baSitter/baUsrSitterDetails";
	}
	
	//시터예약 insert
//		@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterResInst")
//		public String baUsrSitterResInst(BaUsrSitterDto baUsrSitterDto) {
//			 baUsrSitterService.sitterReInsert(baUsrSitterDto);
//			return "redirect:/usr/v1/infra/baSitter/baUsrSitterReservate";
//		}
	//시터 예약하기
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterReservate")
	public String baUsrSitterReservate() {
		return "usr/v1/infra/baSitter/baUsrSitterReservate";
	}
	
	//List
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterList")
	public String baUsrSitterList(@ModelAttribute("vo") BaUsrSitterVo baUsrSitterVo, Model model) throws IOException {

		// paging
		baUsrSitterVo.setParamsPaging(baUsrSitterService.selectOneCount(baUsrSitterVo));
		System.out.println("StartRnumForMySql: " + baUsrSitterVo.getStartRnumForMySql());
		
		if (baUsrSitterVo.getTotalRows() > 0) {
			model.addAttribute("list", baUsrSitterService.selectList(baUsrSitterVo));
		}
		
		return "usr/v1/infra/baSitter/baUsrSitterList";
	}
	
	
	
}
