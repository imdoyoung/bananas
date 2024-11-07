package com.nongshim.infra.baCommon;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nongshim.common.Constants;
import com.nongshim.infra.baMember.BaMemberDto;
import com.nongshim.infra.baMember.BaMemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaCommonController {

	@Autowired
	BaMemberService baMemberService;

	// 관리자 메인화면
	// INDEX
	@RequestMapping(value = "/xdm/v1/infra/common/baXdmIndex")
	public String baXdmIndex() {
		return "/xdm/v1/infra/common/baXdmIndex";
	}

	// 관리자 로그인
	// SIGNIN
	@RequestMapping(value = "/xdm/v1/infra/common/baXdmSignin")
	public String baXdmSignn(BaMemberDto baMemberDto) {
		baMemberService.xdmSelectOneSignin(baMemberDto);
		return "/xdm/v1/infra/common/baXdmSignin";
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

}
