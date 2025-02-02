package com.nongshim.infra.baPlace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nongshim.infra.baSitterList.BaUsrSitterDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaPlaceController {
	
	@Autowired
	BaPlaceService baPlaceService;

	@RequestMapping(value="/usr/v1/infra/baPlace/baUsrPlaceList")
	public String baUsrPlaceList(@ModelAttribute("vo") BaPlaceVo baPlaceVo, Model model) {
		
		//paging
		baPlaceVo.setParamsPaging(baPlaceService.placeSelectOneCount(baPlaceVo));

		if (baPlaceVo.getTotalRows() > 0) {
			model.addAttribute("placeList", baPlaceService.placeSelectList(baPlaceVo));
		}
		return "usr/v1/infra/baPlace/baUsrPlaceList";
	}
	
	//	장소추천 세부리스트
	@RequestMapping(value="/usr/v1/infra/baPlace/baUsrPlaceDetailList")
	public String baUsrPlaceDetailList(BaPlaceDto baPlaceDto, Model model) {
		
		model.addAttribute("placeDeList", baPlaceService.placeDetailList(baPlaceDto));
		
		return "usr/v1/infra/baPlace/baUsrPlaceDetailList";
	}
	
	
	// 리뷰 insert
//	@ResponseBody
//	@RequestMapping(value="/usr/v1/infra/baPlace/baUsrPlaceReviewInst", method = RequestMethod.POST)
//	public Map<String, Object> (@RequestParam("baplSeq") String baplSeq, BaPlaceDto baPlaceDto, HttpSession httpSession) {
//		return response;
//	}
	
	// 추천장소 사진 업로드
	// 관리자 - 추천장소 페이지
	@RequestMapping(value="/xdm/v1/infra/baPlace/baPlaceXdmList")
	public String baSitterXdmList() {
		return "xdm/v1/infra/baPlace/baPlaceXdmList";
	}
	
	@RequestMapping(value="/xdm/v1/infra/baPlace/baPlaceXdmInst")
	public String insertUploaded(BaPlaceDto baPlaceDto) throws Exception {
		System.out.println("/// 장소추천 사진 파일첨부 실행 ///");
		baPlaceService.insertUploaded(baPlaceDto, 0);
		return "redirect:/xdm/v1/infra/baPlace/baPlaceXdmList";
	}
	
}
