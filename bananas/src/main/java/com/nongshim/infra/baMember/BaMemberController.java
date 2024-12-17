package com.nongshim.infra.baMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaMemberController {
	
	@Autowired
	BaMemberService baMemberService;
	
	@RequestMapping(value="/usr/v1/infra/baMember/baMemberUsrMform")
	public String baMemberUsrMform(BaMemberDto baMemberDto, Model model, HttpSession httpSession) {
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
	    
	    if (sessSeqXdm != null) {
	        // 세션에서 BaMemberDto 객체를 가져옴
	        BaMemberDto sessionBaMemberDto = (BaMemberDto) httpSession.getAttribute("BaMemberDto");
	        
	        if (sessionBaMemberDto != null) {
	            // 세션에 BaMemberDto가 있다면, 그 값을 모델에 담아서 전달
	            model.addAttribute("memberItem", sessionBaMemberDto);
	        } else {
	            // by pass
	            // 필요한 경우 예외 처리 등을 할 수 있음
	        }
	        // BameSeq로 사용되는 값 설정
	        baMemberDto.setBameSeq(sessSeqXdm);
	        
	        // memberSelectOne 서비스 호출
	        model.addAttribute("memberItem", baMemberService.memberSelectOne(baMemberDto));
	        
	    } else {
	        return "redirect:/usr/v1/infra/common/baUsrSignIn"; // 세션에 사용자 정보가 없으면 로그인 페이지로 리디렉션
	    }
	    return "usr/v1/infra/baMember/baMemberUsrMform";
	}
	
	
	@RequestMapping(value="/usr/v1/infra/baMember/baMemberUsrInst")
	public String baMemberUsrInst(BaMemberDto baMemberDto, Model model) {
		baMemberService.memberInsert(baMemberDto);
		return "redirect:/usr/v1/infra/common/baUsrSignIn";
	}
	
	@RequestMapping(value = "/usr/v1/infra/baMember/baMemberUsrUpdt")
	public String baMemberUsrUpdt(BaMemberDto baMemberDto, HttpSession httpSession) {
	    // 세션에서 사용자 정보 가져오기
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");

	    // 세션 값 디버깅 (로그 출력)
	    BaMemberDto sessionBaMemberDto = (BaMemberDto) httpSession.getAttribute("BaMemberDto");

	    if (sessSeqXdm != null && sessionBaMemberDto != null) {
	        // 세션에서 가져온 bameSeq를 baMemberDto에 설정
	        baMemberDto.setBameSeq(sessSeqXdm);

	        // Mapper에 업데이트 처리
	        baMemberService.memberUpdate(baMemberDto);

	        // 세션에 담겨있는 baMemberDto 정보 업데이트하여 반영
	        httpSession.setAttribute("BaMemberDto", baMemberDto);

	        return "redirect:/usr/v1/infra/mypage/baUsrMypage";    // 업데이트 후 마이페이지로 리디렉션
	    } else {
	        return "redirect:/usr/v1/infra/common/baUsrSignIn";    // 세션에 사용자 정보가 없으면 로그인 페이지로 리디렉션
	    }
	}
}
