package com.nongshim.infra.baMeetPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaMeetPointController {
	
	@Autowired
	BaMeetPointService baMeetPointService;
	
	// 중간지점찾기 페이지
	// HTML 화면 반환
	@RequestMapping(value="/usr/v1/infra/baMeetPoint/baMeetPoint")
	public String meetpointselectlist(BaMeetPointDto baMeetPointDto, Model model) {
//	    List<BaMeetPointDto> meetPointList = baMeetPointService.meetpointselectlist(baMeetPointDto);
	    model.addAttribute("meetPointList", baMeetPointService.meetpointselectlist(baMeetPointDto)); // 데이터를 모델에 추가
	    return "usr/v1/infra/baMeetPoint/baMeetPoint";
	}

}
 