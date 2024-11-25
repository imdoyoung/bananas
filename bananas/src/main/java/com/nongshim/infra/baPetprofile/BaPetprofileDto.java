package com.nongshim.infra.baPetprofile;

import java.util.Date;

public class BaPetprofileDto {
	
	private String bapeSeq;
	private String bapeName;
    private Integer bapeGender;
    private String bapeType;
    private String bapeAge;
    private String bapeWeight;
    private Integer bapeNtrNy;
    private String bapehospital;
    private String bapeDesc;
    private Date bapeRegDate;
    private Date bapeEditDate;
    private Integer bapeUseNy;
    private Integer bapeDelNy;
    private String BA_Member_bameSeq;
    
    // ------ getter/setter ------
	public String getBapeSeq() {
		return bapeSeq;
	}
	public void setBapeSeq(String bapeSeq) {
		this.bapeSeq = bapeSeq;
	}
	public String getBapeName() {
		return bapeName;
	}
	public void setBapeName(String bapeName) {
		this.bapeName = bapeName;
	}
	public Integer getBapeGender() {
		return bapeGender;
	}
	public void setBapeGender(Integer bapeGender) {
		this.bapeGender = bapeGender;
	}
	public String getBapeType() {
		return bapeType;
	}
	public void setBapeType(String bapeType) {
		this.bapeType = bapeType;
	}
	public String getBapeAge() {
		return bapeAge;
	}
	public void setBapeAge(String bapeAge) {
		this.bapeAge = bapeAge;
	}
	public String getBapeWeight() {
		return bapeWeight;
	}
	public void setBapeWeight(String bapeWeight) {
		this.bapeWeight = bapeWeight;
	}
	public Integer getBapeNtrNy() {
		return bapeNtrNy;
	}
	public void setBapeNtrNy(Integer bapeNtrNy) {
		this.bapeNtrNy = bapeNtrNy;
	}
	public String getBapehospital() {
		return bapehospital;
	}
	public void setBapehospital(String bapehospital) {
		this.bapehospital = bapehospital;
	}
	public String getBapeDesc() {
		return bapeDesc;
	}
	public void setBapeDesc(String bapeDesc) {
		this.bapeDesc = bapeDesc;
	}
	public Date getBapeRegDate() {
		return bapeRegDate;
	}
	public void setBapeRegDate(Date bapeRegDate) {
		this.bapeRegDate = bapeRegDate;
	}
	public Date getBapeEditDate() {
		return bapeEditDate;
	}
	public void setBapeEditDate(Date bapeEditDate) {
		this.bapeEditDate = bapeEditDate;
	}
	public Integer getBapeUseNy() {
		return bapeUseNy;
	}
	public void setBapeUseNy(Integer bapeUseNy) {
		this.bapeUseNy = bapeUseNy;
	}
	public Integer getBapeDelNy() {
		return bapeDelNy;
	}
	public void setBapeDelNy(Integer bapeDelNy) {
		this.bapeDelNy = bapeDelNy;
	}
	public String getBA_Member_bameSeq() {
		return BA_Member_bameSeq;
	}
	public void setBA_Member_bameSeq(String bA_Member_bameSeq) {
		BA_Member_bameSeq = bA_Member_bameSeq;
	}

}
