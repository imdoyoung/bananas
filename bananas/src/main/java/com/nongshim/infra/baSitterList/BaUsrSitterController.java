package com.nongshim.infra.baSitterList;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		// 리뷰 리스트 출력
		model.addAttribute("relist", baUsrSitterService.reSelectList());
		// 예약 옵션 리스트 출력
		model.addAttribute("opList", baUsrSitterService.opSelectList());
		
		System.out.println("시터 상세페이지");
		System.out.println("BasiSeq: " + baUsrSitterDto.getBasiSeq());
		
		return "usr/v1/infra/baSitter/baUsrSitterDetails";
	}
	
	// booking insert
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrSitterBookingInst", method = RequestMethod.POST)
	public String baUsrSitterBookingInst(@RequestParam("basiSeq") String basiSeq, BaUsrSitterDto baUsrSitterDto,
			@RequestParam("optionSeqs") List<String> optionSeqs, HttpSession httpSession) {
		
		// 세션에서 sessSeqXdm, sessPetSeq 값 가져오기
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
		String sessPetSeq = (String) httpSession.getAttribute("sessPetSeq");
		
		if(sessSeqXdm != null) {
			// ba_member_bameSeq 가져오기(회원seq)
//			baUsrSitterDto.setBa_member_bameSeq(sessSeqXdm);
			
			// ba_petprofile_bapeSeq 가져오기(펫seq)
			baUsrSitterDto.setBa_petprofile_bapeSeq(sessPetSeq);
			
			// ba_option_baopSeq 가져오기(옵션번호)
			baUsrSitterDto.setOptionSeqs(optionSeqs);
			
			// ba_sitterlist_basiSeq 가져오기(시터번호)
			baUsrSitterDto.setBa_sitterlist_basiSeq(basiSeq);
			baUsrSitterDto.setBasiSeq(basiSeq);
			
			// baboTotalPrice 값 설정 (자동으로 폼에서 전달된 값이 baUsrSitterDto에 바인딩 됨)
			System.out.println("총금액 : " + baUsrSitterDto.getBaboTotalPrice());	// 확인용 출력
			// basiSeq 값 확인
		    System.out.println("받은 basiSeq: " + basiSeq);
		    System.out.println("Ba_sitterlist_basiSeq: " + baUsrSitterDto.getBa_sitterlist_basiSeq());
			System.out.println("BasiSeq: " + baUsrSitterDto.getBasiSeq());
		    
			
			// 실제 baUsrSitterBookingInst 와 관련된 서비스 호출
			baUsrSitterService.bookingInsert(baUsrSitterDto);
			baUsrSitterService.bookingOptionInsert(baUsrSitterDto);
			
			// baboSeq 값을 baUsrPayment로 전달
			return "redirect:/usr/v1/infra/baSitter/baUsrPayment?baboSeq=" + baUsrSitterDto.getBaboSeq(); // 결제 페이지로 이동 
		} else {
			// 세션에 사용자 정보가 없으면 처리
			return "redirect:/usr/v1/infra/common/baUsrSignIn"; // 로그인페이지로 리다이렉션
		}
	}
	
	
	
	
	// 결제페이지 - 예약 완료
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrPayment")
	public String baUsrSitterForm(BaUsrSitterDto baUsrSitterDto, @RequestParam("baboSeq") String baboSeq, Model model) {
		model.addAttribute("bookingItem", baUsrSitterService.paymentBookingSelectOne(baUsrSitterDto));
		model.addAttribute("optionList", baUsrSitterService.paymentOptionSelectList(baUsrSitterDto));
		return "usr/v1/infra/baSitter/baUsrPayment";
	}
	
	@RequestMapping(value="/usr/v1/infra/baSitter/baUsrPaymentUpt")
	public String baUsrPaymentUpt(BaUsrSitterDto baUsrSitterDto, HttpSession httpSession) {
		
		// 세션에서 sessSeqXdm, sessPetSeq 값 가져오기
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
		String sessPetSeq = (String) httpSession.getAttribute("sessPetSeq");
		
		baUsrSitterDto.setBameSeq(sessSeqXdm);
		baUsrSitterDto.setBa_member_bameSeq(sessSeqXdm);
		
		baUsrSitterDto.setBapeSeq(sessPetSeq);
		baUsrSitterDto.setBa_petprofile_bapeSeq(sessPetSeq);
		
		// 결제정보 업데이트
		baUsrSitterService.paymentBookingUpdate(baUsrSitterDto);
		
		return "redirect:/usr/v1/infra/mypage/baUsrBookingHistory";
	}
	
	
	
	// 시터 상세페이지 - 리뷰 등록
	// DetailReviewInsert
	@ResponseBody
	@RequestMapping(value = "/usr/v1/infra/baSitter/baUsrReInst", method = RequestMethod.POST)
	public Map<String, Object> usrHotelRvInst(@RequestParam("basiSeq") String basiSeq, BaUsrSitterDto baUsrSitterDto, HttpSession httpSession, HttpServletResponse response) throws IOException {
		Map<String, Object> resultMap = new HashMap<>();
	
		// 세션 값 가져오기
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
		String sessNameXdm = (String) httpSession.getAttribute("sessNameXdm");
				    
		baUsrSitterDto.setBa_member_bameSeq(sessSeqXdm);
		baUsrSitterDto.setBa_sitterlist_basiSeq(basiSeq);
		baUsrSitterDto.setBameName(sessNameXdm);
				
//		System.out.println("Received basiSeq : " + baUsrSitterDto.getBa_sitterlist_basiSeq());
//		System.out.println("Received baUsrSitterDto : " + baUsrSitterDto.toString());
	
		// 리뷰 삽입
		int result = baUsrSitterService.reInsert(baUsrSitterDto);
			
	    // 결과 로그 추가
	    System.out.println("Review insert result: " + result);
			
		if (result > 0) {
			resultMap.put("rt", "success");
			resultMap.put("success", true);
			resultMap.put("bameName", baUsrSitterDto.getBameName());
			resultMap.put("bareStar", baUsrSitterDto.getBareStar());	
			resultMap.put("bareContents", baUsrSitterDto.getBareContents());
				
			response.sendRedirect("/usr/v1/infra/baSitter/baUsrSitterDetails?basiSeq=" + basiSeq);
	    } else {
	        resultMap.put("rt", "fail");
	        resultMap.put("message", "리뷰 실패");
	    }
	
		return resultMap;
	}
	
	// 시터 프로필 사진 업로드
	// 관리자 - 시터 페이지
	@RequestMapping(value="/xdm/v1/infra/baSitter/baSitterXdmList")
	public String baSitterXdmList() {
		return "xdm/v1/infra/baSitter/baSitterXdmList";
	}
	
	@RequestMapping(value="/xdm/v1/infra/baSitter/baSitterXdmInst")
	public String insertUploaded(BaUsrSitterDto baUsrSitterDto) throws Exception {
		System.out.println("/// 시터 프로필 사진 파일첨부 실행 ///");
		baUsrSitterService.insertUploaded(baUsrSitterDto, 0);
		return "redirect:/xdm/v1/infra/baSitter/baSitterXdmList";
	}
	
	}