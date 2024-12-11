package com.nongshim.infra.baPlace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaPlaceController {
	
	@Autowired
	BaPlaceService baPlaceService;

	@RequestMapping(value="/usr/v1/infra/baPlace/baUsrPlaceList")
	public String baUsrPlaceList(@ModelAttribute("vo") BaPlaceVo baPlaceVo, Model model) {
		
		//paging
		baPlaceVo.setParamsPaging(baPlaceService.placeSelectOneCount(baPlaceVo));

		if (baPlaceVo.getTotalRows() > 0) {
			model.addAttribute("placeList", baPlaceService.placeSelectList(baPlaceVo));
		}
		return "usr/v1/infra/baPlace/baUsrPlaceList";
	}
	
	@RequestMapping(value="/usr/v1/infra/baPlace/baUsrPlaceDetailList")
	public String baUsrPlaceDetailList(BaPlaceDto baPlaceDto, Model model) {
		
		model.addAttribute("placeDeList", baPlaceService.placeDetailList(baPlaceDto));
		
		return "usr/v1/infra/baPlace/baUsrPlaceDetailList";
	}
	
	
}
