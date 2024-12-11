package com.nongshim.infra.baPlace;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BaPlaceDto {
	
	private String baplSeq;
	private String baplCity;
	private Integer baplType;
	private String baplDeType;
	private String baplName;
	private String baplAddr;
	private String baplTel;
	private String baplWeb;
	private String baplAvailPlace;
	private String baplRestrictions;
	private String baplFee;
	private String baplEtc;
	private String baplTime;
	private String baplOff;
	private String baplParking;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date baplRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date baplEditDate;
	private Integer baplUseNy;
	private Integer baplDelNy;
	
	// ba_review
	private String bareSeq;
	private Integer bareType;
	private Integer bareStar;
	private String bareContents;
	private String bareId;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bareRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bareEditDate;
	private Integer bareDelNy;
	private String ba_place_baplSeq;
	private String ba_booking_baboSeq;
	
	// ------ getter / setter ------
	public String getBaplSeq() {
		return baplSeq;
	}
	public void setBaplSeq(String baplSeq) {
		this.baplSeq = baplSeq;
	}
	public String getBaplCity() {
		return baplCity;
	}
	public void setBaplCity(String baplCity) {
		this.baplCity = baplCity;
	}
	public Integer getBaplType() {
		return baplType;
	}
	public void setBaplType(Integer baplType) {
		this.baplType = baplType;
	}
	public String getBaplDeType() {
		return baplDeType;
	}
	public void setBaplDeType(String baplDeType) {
		this.baplDeType = baplDeType;
	}
	public String getBaplName() {
		return baplName;
	}
	public void setBaplName(String baplName) {
		this.baplName = baplName;
	}
	public String getBaplAddr() {
		return baplAddr;
	}
	public void setBaplAddr(String baplAddr) {
		this.baplAddr = baplAddr;
	}
	public String getBaplTel() {
		return baplTel;
	}
	public void setBaplTel(String baplTel) {
		this.baplTel = baplTel;
	}
	public String getBaplWeb() {
		return baplWeb;
	}
	public void setBaplWeb(String baplWeb) {
		this.baplWeb = baplWeb;
	}
	public String getBaplAvailPlace() {
		return baplAvailPlace;
	}
	public void setBaplAvailPlace(String baplAvailPlace) {
		this.baplAvailPlace = baplAvailPlace;
	}
	public String getBaplRestrictions() {
		return baplRestrictions;
	}
	public void setBaplRestrictions(String baplRestrictions) {
		this.baplRestrictions = baplRestrictions;
	}
	public String getBaplFee() {
		return baplFee;
	}
	public void setBaplFee(String baplFee) {
		this.baplFee = baplFee;
	}
	public String getBaplEtc() {
		return baplEtc;
	}
	public void setBaplEtc(String baplEtc) {
		this.baplEtc = baplEtc;
	}
	public String getBaplTime() {
		return baplTime;
	}
	public void setBaplTime(String baplTime) {
		this.baplTime = baplTime;
	}
	public String getBaplOff() {
		return baplOff;
	}
	public void setBaplOff(String baplOff) {
		this.baplOff = baplOff;
	}
	public String getBaplParking() {
		return baplParking;
	}
	public void setBaplParking(String baplParking) {
		this.baplParking = baplParking;
	}
	public Date getBaplRegDate() {
		return baplRegDate;
	}
	public void setBaplRegDate(Date baplRegDate) {
		this.baplRegDate = baplRegDate;
	}
	public Date getBaplEditDate() {
		return baplEditDate;
	}
	public void setBaplEditDate(Date baplEditDate) {
		this.baplEditDate = baplEditDate;
	}
	public Integer getBaplUseNy() {
		return baplUseNy;
	}
	public void setBaplUseNy(Integer baplUseNy) {
		this.baplUseNy = baplUseNy;
	}
	public Integer getBaplDelNy() {
		return baplDelNy;
	}
	public void setBaplDelNy(Integer baplDelNy) {
		this.baplDelNy = baplDelNy;
	}
	public String getBareSeq() {
		return bareSeq;
	}
	public void setBareSeq(String bareSeq) {
		this.bareSeq = bareSeq;
	}
	public Integer getBareType() {
		return bareType;
	}
	public void setBareType(Integer bareType) {
		this.bareType = bareType;
	}
	public Integer getBareStar() {
		return bareStar;
	}
	public void setBareStar(Integer bareStar) {
		this.bareStar = bareStar;
	}
	public String getBareContents() {
		return bareContents;
	}
	public void setBareContents(String bareContents) {
		this.bareContents = bareContents;
	}
	public Date getBareRegDate() {
		return bareRegDate;
	}
	public void setBareRegDate(Date bareRegDate) {
		this.bareRegDate = bareRegDate;
	}
	public Date getBareEditDate() {
		return bareEditDate;
	}
	public void setBareEditDate(Date bareEditDate) {
		this.bareEditDate = bareEditDate;
	}
	public Integer getBareDelNy() {
		return bareDelNy;
	}
	public void setBareDelNy(Integer bareDelNy) {
		this.bareDelNy = bareDelNy;
	}
	public String getBa_place_baplSeq() {
		return ba_place_baplSeq;
	}
	public void setBa_place_baplSeq(String ba_place_baplSeq) {
		this.ba_place_baplSeq = ba_place_baplSeq;
	}
	public String getBa_booking_baboSeq() {
		return ba_booking_baboSeq;
	}
	public void setBa_booking_baboSeq(String ba_booking_baboSeq) {
		this.ba_booking_baboSeq = ba_booking_baboSeq;
	}
	public String getBareId() {
		return bareId;
	}
	public void setBareId(String bareId) {
		this.bareId = bareId;
	}
	
	

}
