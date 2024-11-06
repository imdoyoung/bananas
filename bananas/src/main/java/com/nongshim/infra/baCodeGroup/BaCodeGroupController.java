package com.nongshim.infra.baCodeGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nongshim.common.util.UtilDateTime;

@Controller
public class BaCodeGroupController {
	
	@Autowired
	BaCodeGroupService baCodeGroupService;

	//LIST
	@RequestMapping(value="/xdm/v1/infra/baCodeGroup/baCodeGroupXdmList")
	public String baCodeGroupXdmList(@ModelAttribute("vo") BaCodeGroupVo baCodeGroupVo, Model model) throws IOException {
		
		// 날짜 필드에 시간 추가
//		codeGroupVo.setShDateStart(codeGroupVo.getShDateStart()+" 00:00:00");			
//		codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd()+" 23:59:59");			
		
		// 초기값 세팅이 없는 경우 사용
		baCodeGroupVo.setShDateStart(baCodeGroupVo.getShDateStart() == null || baCodeGroupVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(baCodeGroupVo.getShDateStart()));
		baCodeGroupVo.setShDateEnd(baCodeGroupVo.getShDateEnd() == null || baCodeGroupVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(baCodeGroupVo.getShDateEnd()));
		
		// paging
		baCodeGroupVo.setParamsPaging(baCodeGroupService.selectOneCount(baCodeGroupVo));
		System.out.println("StartRnumForMySql22: " + baCodeGroupVo.getStartRnumForMySql());
		
		if (baCodeGroupVo.getTotalRows() > 0) {
			model.addAttribute("list", baCodeGroupService.selectList(baCodeGroupVo));
//			model.addAttribute("vo", codeGroupVo);
		}
		
		return "/xdm/v1/infra/baCodeGroup/baCodeGroupXdmList";
	}
	
	// Form
	@RequestMapping(value="/xdm/v1/infra/baCodeGroup/baCodeGroupXdmForm")
	public String baCodeGroupXdmForm() {
		
		return "/xdm/v1/infra/baCodeGroup/baCodeGroupXdmForm";
	}
	
	// INSERT
	@RequestMapping(value="/xdm/v1/infra/baCodeGroup/baCodeGroupXdmInst")
	public String baCodeGroupXdmInst(BaCodeGroupDto baCodeGroupDto) {
		
//		System.out.println(codeGroupDto.getIfcgName());

		baCodeGroupService.insert(baCodeGroupDto);
		
		return "redirect:/xdm/v1/infra/baCodeGroup/baCodeGroupXdmList";
	}
	
	// MfORM
	// 축약형
	@RequestMapping(value="/xdm/v1/infra/baCodeGroup/baCodeGroupXdmMfom")
	public String baCodeGroupXdmMfom(BaCodeGroupDto baCodeGroupDto, Model model) {
		model.addAttribute("item", baCodeGroupService.selectOne(baCodeGroupDto));
		return "/xdm/v1/infra/baCodeGroup/baCodeGroupXdmMfom";
	}
	
	//UPDATE
	@RequestMapping(value="/xdm/v1/infra/baCodeGroup/baCodeGroupXdmUpdt")
	public String baCodeGroupXdmUpdt(BaCodeGroupDto baCodeGroupDto) {
		baCodeGroupService.update(baCodeGroupDto);
		return "redirect:/xdm/v1/infra/baCodeGroup/baCodeGroupXdmList";
	}
	
	// UELETE
	@RequestMapping(value="/xdm/v1/infra/baCodeGroup/baCodeGroupXdmUel")
	public String baCodeGroupXdmUel(BaCodeGroupDto baCodeGroupDto) {
		baCodeGroupService.uelete(baCodeGroupDto);
		return "redirect:/xdm/v1/infra/baCodeGroup/baCodeGroupXdmList";
	}
	
	// DELETE
	@RequestMapping(value="/xdm/v1/infra/baCodeGroup/baCodeGroupXdmDel")
	public String baCodeGroupXdmDel(BaCodeGroupDto baCodeGroupDto) {
		baCodeGroupService.delete(baCodeGroupDto);
		return "redirect:/xdm/v1/infra/baCodeGroup/baCodeGroupXdmList";
	}
	
}
