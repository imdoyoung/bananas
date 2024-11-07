package com.nongshim.infra.baMember;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BaMemberDto {

// ---- filed ----- //
	private String bameSeq;
	private String bameName;
	private String bameId;
	private String bamePw;
	private Integer bameGender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bameBirth;
	private String bameEmail;
	private String bameTel;
	private String bameZipCode;
	private String bameAddr;
	private String bameAddrDetail;
	private Integer bameGrade;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bameRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bameEditDate;
	private Integer bameTosNy;
	private Integer bameMktNy;
	private Integer bameDelNy;
	
// ----- getter/setter ----- //
	public String getBameSeq() {
		return bameSeq;
	}
	public void setBameSeq(String bameSeq) {
		this.bameSeq = bameSeq;
	}
	public String getBameName() {
		return bameName;
	}
	public void setBameName(String bameName) {
		this.bameName = bameName;
	}
	public String getBameId() {
		return bameId;
	}
	public void setBameId(String bameId) {
		this.bameId = bameId;
	}
	public String getBamePw() {
		return bamePw;
	}
	public void setBamePw(String bamePw) {
		this.bamePw = bamePw;
	}
	public Integer getBameGender() {
		return bameGender;
	}
	public void setBameGender(Integer bameGender) {
		this.bameGender = bameGender;
	}
	public Date getBameBirth() {
		return bameBirth;
	}
	public void setBameBirth(Date bameBirth) {
		this.bameBirth = bameBirth;
	}
	public String getBameEmail() {
		return bameEmail;
	}
	public void setBameEmail(String bameEmail) {
		this.bameEmail = bameEmail;
	}
	public String getBameTel() {
		return bameTel;
	}
	public void setBameTel(String bameTel) {
		this.bameTel = bameTel;
	}
	public String getBameZipCode() {
		return bameZipCode;
	}
	public void setBameZipCode(String bameZipCode) {
		this.bameZipCode = bameZipCode;
	}
	public String getBameAddr() {
		return bameAddr;
	}
	public void setBameAddr(String bameAddr) {
		this.bameAddr = bameAddr;
	}
	public String getBameAddrDetail() {
		return bameAddrDetail;
	}
	public void setBameAddrDetail(String bameAddrDetail) {
		this.bameAddrDetail = bameAddrDetail;
	}
	public Integer getBameGrade() {
		return bameGrade;
	}
	public void setBameGrade(Integer bameGrade) {
		this.bameGrade = bameGrade;
	}
	public Date getBameRegDate() {
		return bameRegDate;
	}
	public void setBameRegDate(Date bameRegDate) {
		this.bameRegDate = bameRegDate;
	}
	public Date getBameEditDate() {
		return bameEditDate;
	}
	public void setBameEditDate(Date bameEditDate) {
		this.bameEditDate = bameEditDate;
	}
	public Integer getBameTosNy() {
		return bameTosNy;
	}
	public void setBameTosNy(Integer bameTosNy) {
		this.bameTosNy = bameTosNy;
	}
	public Integer getBameMktNy() {
		return bameMktNy;
	}
	public void setBameMktNy(Integer bameMktNy) {
		this.bameMktNy = bameMktNy;
	}
	public Integer getBameDelNy() {
		return bameDelNy;
	}
	public void setBameDelNy(Integer bameDelNy) {
		this.bameDelNy = bameDelNy;
	}

	
}
