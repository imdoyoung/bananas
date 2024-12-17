package com.nongshim.infra.baPetprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nongshim.infra.baMember.BaMemberDto;
import com.nongshim.infra.baMember.BaMemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaPetprofileController {
	
	@Autowired
	BaPetprofileService baPetprofileService;
	
//	@Autowired
//	BaMemberService baMemberService;
	
	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrForm")
	public String baPetprofileUsrForm() {
		return "usr/v1/infra/baPetprofile/baPetprofileUsrForm";
	}

	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrMform")
	public String baPetprofileUsrMform(BaPetprofileDto baPetprofileDto, Model model, HttpSession httpSession) {
		String sessPetSeq = (String) httpSession.getAttribute("sessPetSeq");
	    
	    if (sessPetSeq != null) {
	        // 세션에서 BaPetprofileDto 객체를 가져옴
	    	BaPetprofileDto sessionBaPetprofileDto = (BaPetprofileDto) httpSession.getAttribute("baPetprofileDto");
	    	
	        
	        if (sessionBaPetprofileDto != null) {
	            // 세션에 BaMemberDto가 있다면, 그 값을 모델에 담아서 전달
	            model.addAttribute("PetItem", sessionBaPetprofileDto);
	        } else {
	            // by pass
	            // 필요한 경우 예외 처리 등을 할 수 있음
	        }
	        // BapeSeq로 사용되는 값 설정
	        baPetprofileDto.setBapeSeq(sessPetSeq);
	        
	        // memberSelectOne 서비스 호출
	        model.addAttribute("PetItem", baPetprofileService.PetSelectOne(baPetprofileDto));
	        
	    } else {
	        return "redirect:/usr/v1/infra/common/baUsrSignIn"; // 세션에 펫 정보가 없으면 로그인 페이지로 리디렉션
	    }
		return "usr/v1/infra/baPetprofile/baPetprofileUsrMform";
	}
	
	@RequestMapping(value="/usr/v1/infra/baPetprofile/baPetprofileUsrInst")
	public String baPetprofileUsrInst(BaPetprofileDto baPetprofileDto) {
		baPetprofileService.PetInsert(baPetprofileDto);
		return "redirect:/usr/v1/infra/mypage/baUsrMypage";
	}
	
	@RequestMapping(value = "/usr/v1/infra/baPetprofile/baPetprofileUsrUpdt")
	public String baPetprofileUsrUpdt(BaPetprofileDto baPetprofileDto, HttpSession httpSession) {
		
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
		String sessPetSeq = (String) httpSession.getAttribute("sessPetSeq");
		
//		System.out.println("sessSeqXdm : " + sessSeqXdm);
//		System.out.println("sessPetSeq : " + sessPetSeq);
		
		baPetprofileDto.setBameSeq(sessSeqXdm);
		baPetprofileDto.setBA_Member_bameSeq(sessSeqXdm);
		baPetprofileDto.setBapeSeq(sessPetSeq);
		
		baPetprofileService.PetUpdate(baPetprofileDto);
		return "redirect:/usr/v1/infra/mypage/baUsrMypage";
		
		
	}
	
}
