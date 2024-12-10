package com.nongshim.infra.baCommon;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nongshim.common.Constants;
import com.nongshim.infra.baMember.BaMemberDto;
import com.nongshim.infra.baMember.BaMemberService;
import com.nongshim.infra.baPetprofile.BaPetprofileDto;
import com.nongshim.infra.baPetprofile.BaPetprofileService;
import com.nongshim.infra.baSitter.BaSitterDto;
import com.nongshim.infra.baSitter.BaSitterService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaCommonController {

	@Autowired
	BaMemberService baMemberService;
	
	@Autowired
	BaSitterService baSitterService;
	
	@Autowired
	BaPetprofileService baPetprofileService;

	// 사용자 메인화면
	// INDEX
	@RequestMapping(value = "/usr/v1/infra/common/baUsrIndex")
	public String baUsrIndex() {
		return "usr/v1/infra/common/baUsrIndex";
	}
	
	// 사용자 로그인
	// SIGNIN
	@RequestMapping(value = "/usr/v1/infra/common/baUsrSignIn")
	public String baUsrSignIn() {
		return "usr/v1/infra/common/baUsrSignIn";
	}
	

	// 사용자 로그인 세션유지
	// LoginProc
	@ResponseBody
	@RequestMapping(value = "/usr/v1/infra/common/baUsrSignInProc")
	public Map<String, Object> baUsrSignInProc(BaMemberDto baMemberDto, BaPetprofileDto baPetprofileDto, HttpSession httpSession) {
		
	    Map<String, Object> returnMap = new HashMap<>();	// 결과를 담기 위한 맵 생성

	    BaMemberDto rtUser = baMemberService.xdmSelectOneSignin(baMemberDto);	// 사용자 정보 조회
	    
	    if (rtUser != null) {// 객체를 대상으로 null을 검사
	    	
	        baPetprofileDto.setBameSeq(rtUser.getBameSeq()); // 사용자의 bameSeq를 설정

	        BaMemberDto rtUser2 = baMemberService.xdmSelectOneID(baMemberDto);	// 로그인 후 세션 정보 저장
	        BaPetprofileDto rtPet2 = baPetprofileService.selectOnePetSeq(baPetprofileDto);	// 로그인 후 펫정보 세션에 저장

	        if (rtUser2 != null) {
	        	// 저장된 세션값 확인
	            httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
	            httpSession.setAttribute("sessSeqXdm", rtUser2.getBameSeq());
	            httpSession.setAttribute("sessIdXdm", rtUser2.getBameId());
	            httpSession.setAttribute("sessNameXdm", rtUser2.getBameName());
	            httpSession.setAttribute("sessGradeXdm", rtUser2.getBameGrade());
	            httpSession.setAttribute("sessEmailXdm", rtUser2.getBameEmail());

	            if (rtPet2 != null) {
	            	// 저장된 세션값 확인
	                httpSession.setAttribute("sessPetSeq", rtPet2.getBapeSeq());
	                httpSession.setAttribute("sessPetName", rtPet2.getBapeName());
	            } else {
	                System.out.println("회원정보를 찾을 수 없습니다.");
	            }

	            returnMap.put("rt", "success");	// 성공 응답 설정
	        } else {
	            returnMap.put("rt", "fail"); // 실패 응답 설정
	        }
	    } else {
	        returnMap.put("rt", "fail"); // 실패 응답 설정
	    }

	    return returnMap;
	}

	
	// 사용자 로그아웃
	// LogoutProc
	@ResponseBody
	@RequestMapping(value = "/usr/v1/infra/common/baUsrSignOutProc")
	public Map<String, Object> baUsrSignOutProc(HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	// 사용자 회원가입
	// SIGNUP
	@RequestMapping(value = "/usr/v1/infra/common/baUsrSignUp")
	public String baUsrSignUp(BaMemberDto baMemberDto) {
		baMemberService.memberInsert(baMemberDto);
		return "usr/v1/infra/common/baUsrSignUp";
	}
	
	
	// 관리자 메인화면
	// INDEX
	@RequestMapping(value = "/xdm/v1/infra/common/baXdmIndex")
	public String baXdmIndex() {
		return "xdm/v1/infra/common/baXdmIndex";
	}

	// 관리자 로그인
	// SIGNIN
	@RequestMapping(value = "/xdm/v1/infra/common/baXdmSignin")
	public String baXdmSignn(BaMemberDto baMemberDto) {
		baMemberService.xdmSelectOneSignin(baMemberDto);
		return "xdm/v1/infra/common/baXdmSignin";
	}

	// 관리자 로그인 세션유지
	// LoginProc
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/common/baXdmSigninProc")
	public Map<String, Object> userXdmSigninProc(BaMemberDto baMemberDto, HttpSession httpSession) {

		Map<String, Object> returnMap = new HashMap<String, Object>(); // 결과를 담기 위한 맵 생성

		BaMemberDto rtUser = baMemberService.xdmSelectOneSignin(baMemberDto); // 사용자 정보 조회

		if (rtUser != null) { // 객체를 대상으로 null을 검사

			BaMemberDto rtUser2 = baMemberService.xdmSelectOneID(baMemberDto); // 로그인 후 세션 정보 저장

			if (rtUser2 != null) {
				// 세션값 저장
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtUser2.getBameSeq());
				httpSession.setAttribute("sessIdXdm", rtUser2.getBameId());
				httpSession.setAttribute("sessNameXdm", rtUser2.getBameName());
				httpSession.setAttribute("sessGradeXdm", rtUser2.getBameGrade());
				// 성공 응답 설정
				returnMap.put("rt", "success");
				// 저장된 세션값 확인
				System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
				System.out.println("sessGradeXdm: " + httpSession.getAttribute("sessGradeXdm"));
			} else {
				returnMap.put("rt", "fail"); // 실패 응답 설정
			}
		}
		return returnMap;
	}
	
	// LogoutProc
	@ResponseBody
	@RequestMapping(value = "/xdm/v1/infra/common/baXdmSignoutProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	//--
	
	
	// 시터 로그인
	@RequestMapping(value="/usr/v1/infra/common/baSitterSignIn")
	public String baSitterSignIn(BaSitterDto baSitterDto)  {
		
		baSitterService.sitterLoginSelectOne(baSitterDto);
		return "usr/v1/infra/common/baSitterSignIn";
	}
	
	// 시터 로그인 처리 페이지
	@ResponseBody // ajax 어노테이션
	@RequestMapping(value="/usr/v1/infra/common/baSitterSignInProc") // 로그인 처리 페이지 
	public Map<String, Object> signinXdmProc(BaSitterDto baSitterDto, HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>(); // 결과를 담기 위한 맵 생성 
		
		BaSitterDto rtMember = baSitterService.sitterLoginSelectOne(baSitterDto); // 로그인 정보를 가져옴
		 	
		if(rtMember != null) { // 로그인 정보가 있을 때 
			BaSitterDto rtMemberSession = baSitterService.sitterLoginSelectOne(baSitterDto); // 세션을 생성
		 
			if(rtMemberSession != null) { // 세션 정보가 있을 때 
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqSit", rtMemberSession.getBasiSeq()); // seq 정보를 가져옴 
				httpSession.setAttribute("sessIdSit", rtMemberSession.getBasiId()); // 아이디 정보를 가져옴
				httpSession.setAttribute("sessNameSit", rtMemberSession.getBasiName()); // 이름 정보를 가져옴 
				httpSession.setAttribute("sessEmailSit", rtMemberSession.getBasiEmail()); // 이메일 정보를 가져옴
				 
				returnMap.put("rt", "success"); // 로그인 성공 
				
			}
			
	  } else {
		  	System.out.println("로그인 실패");
			returnMap.put("rt", "fail"); // 로그인 실패 
    }
		return returnMap;   
 } // end 
	
	
	// 시터 로그아웃
	@ResponseBody
	@RequestMapping(value="/usr/v1/infra/common/baSitterSignOutProc")
	public Map<String, Object> baSitterSignOutProc(HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate(); 
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	 

}
