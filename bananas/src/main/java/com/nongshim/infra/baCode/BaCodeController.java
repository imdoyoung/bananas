package com.nongshim.infra.baCode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nongshim.common.util.UtilDateTime;
import com.nongshim.infra.baCodeGroup.BaCodeGroupService;

@Controller
public class BaCodeController {

	@Autowired
	BaCodeService baCodeService;
	@Autowired
	BaCodeGroupService baCodeGroupService;
	
	// selectList
	@RequestMapping(value="/xdm/v1/infra/baCode/baCodeXdmList")
	public String baCodeXdmList(@ModelAttribute("vo") BaCodeVo baCodeVo, Model model) {
		
		// 날짜
//		codeVo.setShcdDateStart(codeVo.getShcdDateStart() + " 00:00:00");
//		codeVo.setShcdDateEnd(codeVo.getShcdDateEnd() + " 23:59:59");
		// 초기값 세팅이 없는 경우 사용
		baCodeVo.setShcdDateStart(baCodeVo.getShcdDateStart() == null || baCodeVo.getShcdDateStart() == "" ? null : UtilDateTime.add00TimeString(baCodeVo.getShcdDateStart()));
		baCodeVo.setShcdDateEnd(baCodeVo.getShcdDateEnd() == null || baCodeVo.getShcdDateEnd() == "" ? null : UtilDateTime.add59TimeString(baCodeVo.getShcdDateEnd()));
		
		baCodeVo.setParamsPaging(baCodeService.selectOneCount(baCodeVo));
		if(baCodeVo.getTotalRows() > 0) {
			model.addAttribute("list", baCodeService.selectList(baCodeVo));
//			model.addAttribute("vo", codeVo);
		}
		
		return "xdm/v1/infra/baCode/baCodeXdmList";
	}

	// Form
	// code - codegroup 연결
	@RequestMapping(value="/xdm/v1/infra/baCode/baCodeXdmForm")
	public String codeXdmFom(Model model) {
		
		// 코드그룹 정보를 불러와야함
		List<BaCodeDto> codeGroups = baCodeService.selectListCodeGroup();
		
		// 불러온 코드그룹 정보를 codeXdmForm에 전달해주어야함
		model.addAttribute("listCodeGroup", baCodeService.selectListCodeGroup());
		
		return "xdm/v1/infra/baCode/baCodeXdmForm";
	}
	
	// Inst
	@RequestMapping(value="/xdm/v1/infra/baCode/baCodeXdmInst")
	public String baCodeXdmInst(BaCodeDto baCodeDto) {
		baCodeService.insert(baCodeDto);
		return "redirect:/xdm/v1/infra/baCode/baCodeXdmList";
	}
	
	// Mfom - selectOne
	@RequestMapping(value="/xdm/v1/infra/baCode/baCodeXdmMfom")
	public String baCodeXdmInst(BaCodeDto baCodeDto, Model model) {
		
		// 코드의 정보를 codeXdmForm.html에 전달함
		model.addAttribute("item", baCodeService.selectOne(baCodeDto));
		
		// 코드그룹 정보를 불러와야함
		List<BaCodeDto> codeGroups = baCodeService.selectListCodeGroup();

		// 불러온 코드그룹 정보를 codeXdmForm.html에 전달함
		model.addAttribute("listCodeGroup", baCodeService.selectListCodeGroup());
		return "xdm/v1/infra/baCode/baCodeXdmMfom";
	}
	
	// Updt - update
	@RequestMapping(value="/xdm/v1/infra/baCode/baCodeXdmUpdt")
	public String baCodeXdmUpdt(BaCodeDto baCodeDto) {
		baCodeService.update(baCodeDto);
		return "redirect:/xdm/v1/infra/baCode/baCodeXdmList";
	}
	
	// Uel - uelete
	@RequestMapping(value="/xdm/v1/infra/baCode/baCodeXdmUel")
	public String baCodeXdmUel(BaCodeDto baCodeDto) {
		baCodeService.uelete(baCodeDto);
		return "redirect:/xdm/v1/infra/baCode/baCodeXdmList";
	}
	
	// Del - delete
	@RequestMapping(value="/xdm/v1/infra/baCode/baCodeXdmDel")
	public String baCodeXdmDel(BaCodeDto baCodeDto) {
		baCodeService.delet(baCodeDto);
		return "redirect:/xdm/v1/infra/baCode/baCodeXdmList";
	}
	
}
