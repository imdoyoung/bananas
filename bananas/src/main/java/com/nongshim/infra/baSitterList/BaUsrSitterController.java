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
	
	//시터 리스트 + 페이징
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
	
	//시터 상세페이지
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterDetails")
	public String baUsrSitterDetail(BaUsrSitterDto baUsrSitterDto, Model model) {
		// 시터 정보 출력
		model.addAttribute("item", baUsrSitterService.selectOne(baUsrSitterDto));
		// 리뷰 등록
		model.addAttribute("relist", baUsrSitterService.reSelectList());
		// 예약 옵션 리스트 출력
		model.addAttribute("oplist", baUsrSitterService.opSelectList());
		
		return "usr/v1/infra/baSitter/baUsrSitterDetails";
	}
	
	// 시터 상세페이지 - 리뷰 등록
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrReInst")
	public String baUsrReInst(BaUsrSitterDto baUsrSitterDto) {
		System.out.println("별점 : " + baUsrSitterDto.getBareStar());
		 baUsrSitterService.reInsert(baUsrSitterDto);
		return "/usr/v1/infra/baSitter/baUsrSitterDetails";
	}
	
	//시터 예약하기
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterReservate")
	public String baUsrSitterReservate() {
		return "usr/v1/infra/baSitter/baUsrSitterReservate";
	}
	
	
	
	
}
