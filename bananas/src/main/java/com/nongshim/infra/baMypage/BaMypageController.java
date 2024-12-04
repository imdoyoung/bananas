package com.nongshim.infra.baMypage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nongshim.infra.baMember.BaMemberService;

@Controller
public class BaMypageController {     
	
	@Autowired
	BaMypageService baMypageService;
	
	@Autowired
	BaMemberService baMemberService;
	
	// 사용자 마이페이지 (메인)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrMypage") 
	public String baUsrMypage(BaMypageVo baMypageVo, Model model) {
		 
		model.addAttribute("mypageSitterReviewList", baMypageService.BaMypageReviewSelectList(baMypageVo)); 
		model.addAttribute("mypageBookingList", baMypageService.BaMypageBookingSelectList(baMypageVo));
		
		//model.addAttribute("mypageMember", baMemberService.memberSelectList());
		return "usr/v1/infra/mypage/baUsrMypage"; 
	} 
	
	  
	// 사용자 마이페이지 (예약 내역)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrBookingHistory")
	public String baUsrBookingHistory(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model) { 
		
		baMypageVo.setParamsPaging(baMypageService.selectMypageBookingCount(baMypageVo));
		 
		if(baMypageVo.getTotalRows() > 0) {                               
			model.addAttribute("mypageBookingList", baMypageService.BaMypageBookingSelectList(baMypageVo));
		}
		
		return "usr/v1/infra/mypage/baUsrBookingHistory";
	}
	  
	// 사용자 마이페이지 (알림장)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrNotice")
	public String baUsrNotice() {
		return "usr/v1/infra/mypage/baUsrNotice";
	}  
	 
	// 사용자 마이페이지(결제 내역) 
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrPaymentHistory")
	public String baUsrPaymentHistory(BaMypageDto baMypageDto, Model model) {
		
		model.addAttribute("mypagePaymentItem", baMypageService.BaMypagePriceSelectOne(baMypageDto));
		return "usr/v1/infra/mypage/baUsrPaymentHistory";
	}
	
	// 사용자 마이페이지(리뷰 내역)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrMyReview")
	public String baUsrMyReview(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model) {
		
		baMypageVo.setParamsPaging(baMypageService.selectSitterOneCount(baMypageVo));
		
		if(baMypageVo.getTotalRows() > 0) {                               
			model.addAttribute("mypageSitterReviewList", baMypageService.BaMypageReviewSelectList(baMypageVo)); // 시터 리뷰 리스트
		}
		
		model.addAttribute("mypagePlaceReviewList", baMypageService.BaMypagePlaceSelectList()); // 장소 리뷰 리스트
		return "usr/v1/infra/mypage/baUsrMyReview";
	} 
	
	// 사용자 마이페이지(리뷰 내역 - 내용 보기)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrReviewContents")
	public String baUsrReviewContents(BaMypageDto baMypageDto, Model model) {
		
		model.addAttribute("mypageReviewItem", baMypageService.BaMypageSelectOne(baMypageDto)); 
		return "usr/v1/infra/mypage/baUsrReviewContents";
	}
	  
	
	
	//--
	
	
	
	// 시터 마이페이지 (메인)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMypage")
	public String baSitterMypage(BaMypageVo baMypageVo, Model model) {
		
		model.addAttribute("sitterPageBookingLsit", baMypageService.sitterPageBookingSelectList(baMypageVo));
		return "usr/v1/infra/mypage/baSitterMypage";
	}
	
	// 시터 마이페이지 (나의 예약)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMyBooking")
	public String baSitterMyBooking(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model) {
		
		baMypageVo.setParamsPaging(baMypageService.selectMypageBookingCount(baMypageVo));
		
		if(baMypageVo.getTotalRows() > 0) {                               
			model.addAttribute("sitterPageBookingLsit", baMypageService.sitterPageBookingSelectList(baMypageVo));
		}
		
		return "usr/v1/infra/mypage/baSitterMyBooking";
	}
	
	
//    @RequestMapping(value="/usr/v1/infra/mypage/baSitterBookingEvents")
//    @ResponseBody // JSON 반환
//    public List<Map<String, Object>> getSitterBookingEvents(@ModelAttribute BaMypageVo baMypageVo) {
//    	
//        // 예약 리스트 가져오기
//        List<BaMypageDto> bookingList = baMypageService.sitterPageBookingSelectList(baMypageVo);
//
//        // FullCalendar에 맞게 데이터를 변환
//        List<Map<String, Object>> events = new ArrayList<>();
//        for (BaMypageDto booking : bookingList) {
//            Map<String, Object> event = new HashMap<>();
////            event.put("title", booking.getBaopName() + " " + booking.getBaboTime()); // 일정 제목
//            event.put("title", booking.getBaopName()); 
//            event.put("start", booking.getBaboDate()); // 시작 날짜
//            event.put("allDay", true); // 하루 종일 일정
//            events.add(event);
//        }
//        return events;
//    }
	
	
	// 페이징 없는 나의 예약 리스트 
    @RequestMapping(value="/usr/v1/infra/mypage/baSitterBookingEvents")
    @ResponseBody // JSON 반환
    public List<Map<String, Object>> getSitterBookingEvents(@ModelAttribute BaMypageVo baMypageVo) {
    	
    	 // 전체 예약 리스트 가져오기
        List<BaMypageDto> bookingList = baMypageService.BaMypageBookingSelectListAll();

        // FullCalendar에 맞게 데이터를 변환
        List<Map<String, Object>> events = new ArrayList<>();
        for (BaMypageDto booking : bookingList) {
            Map<String, Object> event = new HashMap<>();
//            event.put("title", booking.getBaopName() + " " + booking.getBaboTime()); // 일정 제목
//            event.put("title", booking.getBapeName() + " " + booking.getBaopName()); 
//            event.put("title", booking.getBaopName()); 
            event.put("title", booking.getBapeName() + " " + booking.getBaopName()); 
            event.put("start", booking.getBaboDate()); // 시작 날짜
            event.put("allDay", true); // 하루 종일 일정
            events.add(event);
        }
        return events;
    }
	
	
	// 시터 마이페이지 (나의 리뷰)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMyReview")
	public String baSitterMyReview(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model) {
		
		baMypageVo.setParamsPaging(baMypageService.selectSitterOneCount(baMypageVo));
		
		if(baMypageVo.getTotalRows() > 0) {
			model.addAttribute("mypageSitterReviewList", baMypageService.BaMypageReviewSelectList(baMypageVo));
		}
		
		return "usr/v1/infra/mypage/baSitterMyReview";
	}
	
	// 시터 마이페이지(리뷰 내역 - 내용 보기)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterReviewContents")
	public String baSitterReviewContents(BaMypageDto baMypageDto, Model model) {
		
		model.addAttribute("mypageReviewItem", baMypageService.BaMypageSelectOne(baMypageDto)); 
		return "usr/v1/infra/mypage/baSitterReviewContents";
	}
	
	// 시터 마이페이지(알림장 쓰기)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterNotice")
	public String baSitterNotice() {
		return "usr/v1/infra/mypage/baSitterNotice";
	}
	
	//--
	  
	
	

	
	
	
}
