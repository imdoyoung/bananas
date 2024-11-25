package com.nongshim.infra.baMypage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaMypageController {
	
	@Autowired
	BaMypageService baMypageService;
	
	// 사용자 마이페이지 (메인)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrMypage") 
	public String baUsrMypage(BaMypageVo baMypageVo, Model model) {
		 
		model.addAttribute("mypageSitterReviewList", baMypageService.BaMypageReviewSelectList(baMypageVo)); 
		model.addAttribute("mypageBookingList", baMypageService.BaMypageBookingSelectList());
		return "/usr/v1/infra/mypage/baUsrMypage"; 
	}
	
	// 사용자 마이페이지 (예약 내역)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrBookingHistory")
	public String baUsrBookingHistory(Model model) { 
		
		model.addAttribute("mypageBookingList", baMypageService.BaMypageBookingSelectList());
		return "/usr/v1/infra/mypage/baUsrBookingHistory";
	}
	  
	// 사용자 마이페이지 (알림장)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrNotice")
	public String baUsrNotice() {
		return "/usr/v1/infra/mypage/baUsrNotice";
	}  
	 
	// 사용자 마이페이지(결제 내역) 
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrPaymentHistory")
	public String baUsrPaymentHistory(BaMypageDto baMypageDto, Model model) {
		
		model.addAttribute("mypagePaymentItem", baMypageService.BaMypagePriceSelectOne(baMypageDto));
		return "/usr/v1/infra/mypage/baUsrPaymentHistory";
	}
	
	// 사용자 마이페이지(리뷰 내역)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrMyReview")
	public String baUsrMyReview(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model) {
		
		baMypageVo.setParamsPaging(baMypageService.selectSitterOneCount(baMypageVo));
		
		if(baMypageVo.getTotalRows() > 0) {                               
			model.addAttribute("mypageSitterReviewList", baMypageService.BaMypageReviewSelectList(baMypageVo)); // 시터 리뷰 리스트
		}
		
		
		model.addAttribute("mypagePlaceReviewList", baMypageService.BaMypagePlaceSelectList()); // 장소 리뷰 리스트
		return "/usr/v1/infra/mypage/baUsrMyReview";
	} 
	
	// 사용자 마이페이지(리뷰 내역 - 내용 보기)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrReviewContents")
	public String baUsrReviewContents(BaMypageDto baMypageDto, Model model) {
		
		model.addAttribute("mypageReviewItem", baMypageService.BaMypageSelectOne(baMypageDto)); 
		return "/usr/v1/infra/mypage/baUsrReviewContents";
	}
	  
	
	//--
	
	// 시터 마이페이지 (메인)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMypage")
	public String baSitterMypage(Model model) {
		
		model.addAttribute("sitterPageBookingLsit", baMypageService.sitterPageBookingSelectList());
		return "/usr/v1/infra/mypage/baSitterMypage";
	}
	
	// 시터 마이페이지 (나의 예약)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMyBooking")
	public String baSitterMyBooking(Model model) {
		
		model.addAttribute("sitterPageBookingLsit", baMypageService.sitterPageBookingSelectList());
		return "/usr/v1/infra/mypage/baSitterMyBooking";
	}
	
	// 시터 마이페이지 (나의 리뷰)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMyReview")
	public String baSitterMyReview() {
		return "/usr/v1/infra/mypage/baSitterMyReview";
	}
	
	//--
	

	
	
	
}
