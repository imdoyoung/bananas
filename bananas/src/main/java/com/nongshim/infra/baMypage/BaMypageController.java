package com.nongshim.infra.baMypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaMypageController {
	
	// 사용자 마이페이지 (메인)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrMypage")
	public String baUsrMypage() {
		return "/usr/v1/infra/mypage/baUsrMypage";
	}
	
	// 사용자 마이페이지 (예약내역)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrBookingHistory")
	public String baUsrBookingHistory() {
		return "/usr/v1/infra/mypage/baUsrBookingHistory";
	}
	  
	// 사용자 마이페이지 (알림장)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrNotice")
	public String baUsrNotice() {
		return "/usr/v1/infra/mypage/baUsrNotice";
	}  
	 
	// 사용자 마이페이지(결제내역) 
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrPaymentHistory")
	public String baUsrPaymentHistory() {
		return "/usr/v1/infra/mypage/baUsrPaymentHistory";
	}
	
	
	// /////////////////
	
	// 시터 마이페이지 (메인)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMypage")
	public String baSitterMypage() {
		return "/usr/v1/infra/mypage/baSitterMypage";
	}
	
	// 시터 마이페이지 (나의 예약)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMyBooking")
	public String baSitterMyBooking() {
		return "/usr/v1/infra/mypage/baSitterMyBooking";
	}
	
	// 시터 마이페이지 (나의 리뷰)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMyReview")
	public String baSitterMyReview() {
		return "/usr/v1/infra/mypage/baSitterMyReview";
	}
	
	
	
	
}
