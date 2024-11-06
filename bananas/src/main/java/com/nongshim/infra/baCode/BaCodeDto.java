package com.nongshim.infra.baCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaCodeDto {
	private String ifcdSeq;
	private String ifcdName;
	private Integer ifcdUseNy;
	private Integer ifcdOrder;
	private String ifcdDesc;
	private Integer ifcdDelNy;
	private Date ifcdRegist;
	private Date ifcdEdit;
	private String BA_codegroup_ifcgSeq;
	// BA_codegroup에서 가져올 데이터 추가 & getter/setter 다시 하기
	private String ifcgSeq;
	private String ifcgName;
	// for cache
	public static List<BaCodeDto> cachedCodeArrayList = new ArrayList<BaCodeDto>();

	
	
//	----- getter / setter -----

	public String getIfcdSeq() {
		return ifcdSeq;
	}
	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public Integer getIfcdUseNy() {
		return ifcdUseNy;
	}
	public void setIfcdUseNy(Integer ifcdUseNy) {
		this.ifcdUseNy = ifcdUseNy;
	}
	public Integer getIfcdOrder() {
		return ifcdOrder;
	}
	public void setIfcdOrder(Integer ifcdOrder) {
		this.ifcdOrder = ifcdOrder;
	}
	public String getIfcdDesc() {
		return ifcdDesc;
	}
	public void setIfcdDesc(String ifcdDesc) {
		this.ifcdDesc = ifcdDesc;
	}
	public Integer getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(Integer ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}
	public Date getIfcdRegist() {
		return ifcdRegist;
	}
	public void setIfcdRegist(Date ifcdRegist) {
		this.ifcdRegist = ifcdRegist;
	}
	public Date getIfcdEdit() {
		return ifcdEdit;
	}
	public void setIfcdEdit(Date ifcdEdit) {
		this.ifcdEdit = ifcdEdit;
	}
	public String getBA_codegroup_ifcgSeq() {
		return BA_codegroup_ifcgSeq;
	}
	public void setBA_codegroup_ifcgSeq(String bA_codegroup_ifcgSeq) {
		BA_codegroup_ifcgSeq = bA_codegroup_ifcgSeq;
	}
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public static List<BaCodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<BaCodeDto> cachedCodeArrayList) {
		BaCodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	
}
