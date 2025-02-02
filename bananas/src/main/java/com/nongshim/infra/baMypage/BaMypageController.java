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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nongshim.infra.baMember.BaMemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaMypageController {     
	
	@Autowired
	BaMypageService baMypageService;
	
	@Autowired
	BaMemberService baMemberService;
	
	// 사용자 마이페이지 (메인)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrMypage") 
	public String baUsrMypage(BaMypageVo baMypageVo, Model model, HttpSession httpSession) {  
		
		// 세션 값 가져오기
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
	    
	    // vo에 세션 값 set 
	 	baMypageVo.setBameSeq(sessSeqXdm);
	 	
		model.addAttribute("mypageSitterReviewList", baMypageService.BaMypageReviewSelectList(baMypageVo)); // 내가 남긴 리뷰 
		model.addAttribute("mypageBookingList", baMypageService.BaMypageBookingSelectList(baMypageVo)); // 예약 내역
		
		return "usr/v1/infra/mypage/baUsrMypage"; 
	} 
	
	  
	// 사용자 마이페이지 (예약 내역)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrBookingHistory")
	public String baUsrBookingHistory(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model, HttpSession httpSession) { 
		
		// 세션 값 가져오기
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
	    
	    // vo에 세션 값 set 
	 	baMypageVo.setBameSeq(sessSeqXdm);
	 	
		baMypageVo.setParamsPaging(baMypageService.selectMypageBookingCount(baMypageVo));
		 
		if(baMypageVo.getTotalRows() > 0) { 
			model.addAttribute("mypageBookingList", baMypageService.BaMypageBookingSelectList(baMypageVo));
		}
		
		return "usr/v1/infra/mypage/baUsrBookingHistory";
	}
	
	// 사용자 마이페이지 (예약 내역 상세보기)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrBookingHistoryDetails")
	public String baUsrBookingHistoryDetails(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model) {
		
		baMypageVo.setParamsPaging(baMypageService.selectMypageBookingDetailsCount(baMypageVo));
		  
		if(baMypageVo.getTotalRows() > 0) { 
			model.addAttribute("mypageBookingDetailsList", baMypageService.BaMypageBookingDetailsSelectList(baMypageVo));
		} 
		
		return "usr/v1/infra/mypage/baUsrBookingHistoryDetails";
	} 
 	
	// 사용자 마이페이지 (알림장 보기)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrNotice")
	public String baUsrNotice(BaMypageDto baMypageDto, Model model, HttpSession httpSession) {
		
		// 세션 값 가져오기
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
	    
	    // vo에 세션 값 set 
	    baMypageDto.setBameSeq(sessSeqXdm);
	    baMypageDto.setBaboSeq(sessSeqXdm);
	    baMypageDto.setBasiSeq(sessSeqXdm);
		
		model.addAttribute("mypageNoticeList", baMypageService.BaMypageNoticeSelectList(baMypageDto)); // ba_diary
		//model.addAttribute("mypageNoticeOptionList", baMypageService.BaMypageNoticeOptionList(baMypageDto)); // ba_bookingoption
		return "usr/v1/infra/mypage/baUsrNotice";
	}  
	
	
	// 결제 내역
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrPaymentHistory")
	public String baUsrPaymentHistory(BaMypageDto baMypageDto, Model model) {
		
		model.addAttribute("mypagePaymentItem", baMypageService.BaMypagePriceSelectOne(baMypageDto));
		return "usr/v1/infra/mypage/baUsrPaymentHistory";
	}
	
	// 사용자 마이페이지(리뷰 내역)
	@RequestMapping(value="/usr/v1/infra/mypage/baUsrMyReview")
	public String baUsrMyReview(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model, HttpSession httpSession) {
		
		// 세션 값 가져오기
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
	    
	    // vo에 세션 값 set 
	 	baMypageVo.setBameSeq(sessSeqXdm);
		
		baMypageVo.setParamsPaging(baMypageService.selectSitterOneCount(baMypageVo));
		
		if(baMypageVo.getTotalRows() > 0) {                               
			model.addAttribute("mypageSitterReviewList", baMypageService.BaMypageReviewSelectList(baMypageVo)); // 시터 리뷰 리스트
		}
		
		//model.addAttribute("mypagePlaceReviewList", baMypageService.BaMypagePlaceSelectList()); // 장소 리뷰 리스트
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
	public String baSitterMypage(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model, HttpSession httpSession) {
		
		// 세션 값 가져오기
	    String sessSeqSit = (String) httpSession.getAttribute("sessSeqSit");
	    
	    // vo에 세션 값 set
	 	baMypageVo.setBasiSeq(sessSeqSit);
		
		model.addAttribute("sitterPageBookingLsit", baMypageService.sitterPageBookingSelectList(baMypageVo)); // 나의 예약 리스트
		model.addAttribute("sitterMyReviewList", baMypageService.sitterMyReviewList(baMypageVo)); // 시터 리뷰 리스트
		return "usr/v1/infra/mypage/baSitterMypage";
	}
	
	// 시터 마이페이지 (나의 예약) 
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterMyBooking")
	public String baSitterMyBooking(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model, HttpSession httpSession) {
		     
		// 세션 값 가져오기
		String sessSeqSit = (String) httpSession.getAttribute("sessSeqSit");
		
		// vo에 세션 값 set
		baMypageVo.setBasiSeq(sessSeqSit);
		  
		baMypageVo.setParamsPaging(baMypageService.sitterPageBookingCount(baMypageVo));
		
		if(baMypageVo.getTotalRows() > 0) {    
			model.addAttribute("sitterPageBookingLsit", baMypageService.sitterPageBookingSelectList(baMypageVo));
			System.out.println("Total 리스트 : " + baMypageVo.getTotalRows());
		}
		  
		return "usr/v1/infra/mypage/baSitterMyBooking";
	}
	
	
	// 페이징 없는 나의 예약 리스트 
    @RequestMapping(value="/usr/v1/infra/mypage/baSitterBookingEvents")
    @ResponseBody // JSON 반환
    public List<Map<String, Object>> getSitterBookingEvents(BaMypageDto baMypageDto, HttpSession httpSession) {
    	
    	// 세션 값 가져오기
	    String sessSeqSit = (String) httpSession.getAttribute("sessSeqSit");
	    
	    // vo에 세션 값 set
	    baMypageDto.setBasiSeq(sessSeqSit);
    	
    	// 전체 예약 리스트 가져오기
       // List<BaMypageDto> bookingList = baMypageService.BaMypageBookingSelectListAll();
	 	List<BaMypageDto> bookingList = baMypageService.sitterPageBookingCalendarSelectList(baMypageDto);

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
	public String baSitterMyReview(@ModelAttribute("vo") BaMypageVo baMypageVo, Model model, HttpSession httpSession) {
		
		// 세션 값 가져오기
	    String sessSeqSit = (String) httpSession.getAttribute("sessSeqSit");
	    
	    // vo에 세션 값 set
	 	baMypageVo.setBasiSeq(sessSeqSit);
		
		baMypageVo.setParamsPaging(baMypageService.sitterMyReviewSelectOneCount(baMypageVo));
		
		if(baMypageVo.getTotalRows() > 0) {
			model.addAttribute("sitterMyReviewList", baMypageService.sitterMyReviewList(baMypageVo)); // 시터 리뷰 리스트
		}
		
		return "usr/v1/infra/mypage/baSitterMyReview";
	}
	
	// 시터 마이페이지(나의 리뷰 - 리뷰 자세히 보기)
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterReviewContents")
	public String baSitterReviewContents(BaMypageDto baMypageDto, Model model) {
		
		//model.addAttribute("mypageReviewItem", baMypageService.BaMypageSelectOne(baMypageDto)); 
		model.addAttribute("sitterMyReviewItem", baMypageService.sitterMyReviewSelectOne(baMypageDto));
		return "usr/v1/infra/mypage/baSitterReviewContents";
	}
	
	// 시터 마이페이지(알림장 쓰기) 
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterNotice")
	public String baSitterNotice(BaMypageDto baMypageDto, Model model) {
		
		model.addAttribute("sitterNoticeWriteItem", baMypageService.sitterNoticeWriteSelectOne(baMypageDto)); // 시터, 펫, 멤버 정보 끌고오기 
		model.addAttribute("sitterNoticeWriteList", baMypageService.sitterNoticeWriteSelectList(baMypageDto)); // 돌봄서비스, 방문(예약)날짜 정보 끌고오기
		return "usr/v1/infra/mypage/baSitterNotice";
	} 
	
	// 시터 마이페이지(알림장 내용 insert, baboDiaryNy 0 -> 1) 
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterNoticeInstUpat")
	public String baSitterNoticeInstUpat(@RequestParam("baboSeq") String baboSeq, BaMypageDto baMypageDto) throws Exception {
		
		baMypageDto.setBaboSeq(baboSeq);  
		baMypageDto.setBa_booking_baboSeq(baboSeq);
		 
		baMypageService.sitterNoticeInsert(baMypageDto, 0);
		baMypageService.sitterNoticeUpdate(baMypageDto); 
		
		return "redirect:/usr/v1/infra/mypage/baSitterMyBooking"; 
	}
	
	// 시터 마이페이지(알림장 보기)  
	@RequestMapping(value="/usr/v1/infra/mypage/baSitterNoticeRead")
	public String baSitterNoticeRead(BaMypageDto baMypageDto, Model model) {
		
		model.addAttribute("sitterNoticeWriteItem", baMypageService.sitterNoticeWriteSelectOne(baMypageDto)); // 시터, 펫, 멤버 정보 끌고오기 
		model.addAttribute("sitterNoticeWriteList", baMypageService.sitterNoticeWriteSelectList(baMypageDto)); // 돌봄서비스, 방문(예약)날짜 정보 끌고오기
		model.addAttribute("sitterNoticeContentItem", baMypageService.sitterNoticeContentSelectOne(baMypageDto)); // 알림장 컨텐츠 내용 보기
		
//		model.addAttribute("sitterNoticeItem", baMypageService.sitterNoticeSelectOne(baMypageDto));
		return "usr/v1/infra/mypage/baSitterNoticeRead";
	}
	
	

	
	
	

	 
	
	
	
}