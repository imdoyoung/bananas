package com.nongshim.infra.baMeetPoint;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BaMeetPointController {
	
	@Autowired
	BaMeetPointService baMeetPointService;
	
	// 중간지점찾기 페이지
	@RequestMapping(value="/usr/v1/infra/baMeetPoint/baMeetPoint")
	public String meetpointselectOne() {
	    return "usr/v1/infra/baMeetPoint/baMeetPoint";
	}
	
	
	@ResponseBody // JSON 형식으로 응답 반환
	@RequestMapping(value = "/usr/v1/infra/baMeetPoint/baMeetPointProc", produces = "application/json; charset=utf-8")
	public Map<String, Object> baMeetPointProc(BaMeetPointDto baMeetPointDto) {
		
	    Map<String, Object> rtMap = new HashMap<>();
	    System.out.println("rtMap 돌았다.");
	    
	    // 서비스에서 가장 가까운 역 조회
	    BaMeetPointDto rtMPDto = baMeetPointService.meetpointselectOne(baMeetPointDto);

	    if (rtMPDto != null) {
	    	System.out.println("rtMPDto에 담았다" + rtMPDto.getBameStationName());
	    	
	    	rtMap.put("rt", "success");
	    	System.out.println("rtMPDto에 담아지는거 성공중");
	    	
	        rtMap.put("stationName", rtMPDto.getBameStationName());
	        rtMap.put("latitude", rtMPDto.getBameLatitude());
	        rtMap.put("longitude", rtMPDto.getBameLongitudel());
	    } else {
	    	rtMap.put("rt", "fail");
	    }

	    return rtMap; // 결과 반환
	}

}
 