package com.nongshim.infra.baPlace;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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
	
	// 시터 프로필 사진 파일첨부 
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	private String fSeq;
	private Integer fType;
	private Integer fDefaultNy;
	private Integer fSort;
	private String fPath;
	private String fOriginalName;
	private String fUuidName;
	private String fExt;
	private long fSize;
	private Integer fDelNy;
	private String fPseq;
	private Integer fOrder;
	private String fRegIp;
	private Integer fRegSeq;
	private Integer fRegDeviceCd;
	private Date fRegDateTime;
	private Date fRegDateTimeSvr;
	private String fTableName;
	
	// 사진 이름!!!
	private String mainImg1;
	
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
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public String getfSeq() {
		return fSeq;
	}
	public void setfSeq(String fSeq) {
		this.fSeq = fSeq;
	}
	public Integer getfType() {
		return fType;
	}
	public void setfType(Integer fType) {
		this.fType = fType;
	}
	public Integer getfDefaultNy() {
		return fDefaultNy;
	}
	public void setfDefaultNy(Integer fDefaultNy) {
		this.fDefaultNy = fDefaultNy;
	}
	public Integer getfSort() {
		return fSort;
	}
	public void setfSort(Integer fSort) {
		this.fSort = fSort;
	}
	public String getfPath() {
		return fPath;
	}
	public void setfPath(String fPath) {
		this.fPath = fPath;
	}
	public String getfOriginalName() {
		return fOriginalName;
	}
	public void setfOriginalName(String fOriginalName) {
		this.fOriginalName = fOriginalName;
	}
	public String getfUuidName() {
		return fUuidName;
	}
	public void setfUuidName(String fUuidName) {
		this.fUuidName = fUuidName;
	}
	public String getfExt() {
		return fExt;
	}
	public void setfExt(String fExt) {
		this.fExt = fExt;
	}
	public long getfSize() {
		return fSize;
	}
	public void setfSize(long fSize) {
		this.fSize = fSize;
	}
	public Integer getfDelNy() {
		return fDelNy;
	}
	public void setfDelNy(Integer fDelNy) {
		this.fDelNy = fDelNy;
	}
	public String getfPseq() {
		return fPseq;
	}
	public void setfPseq(String fPseq) {
		this.fPseq = fPseq;
	}
	public Integer getfOrder() {
		return fOrder;
	}
	public void setfOrder(Integer fOrder) {
		this.fOrder = fOrder;
	}
	public String getfRegIp() {
		return fRegIp;
	}
	public void setfRegIp(String fRegIp) {
		this.fRegIp = fRegIp;
	}
	public Integer getfRegSeq() {
		return fRegSeq;
	}
	public void setfRegSeq(Integer fRegSeq) {
		this.fRegSeq = fRegSeq;
	}
	public Integer getfRegDeviceCd() {
		return fRegDeviceCd;
	}
	public void setfRegDeviceCd(Integer fRegDeviceCd) {
		this.fRegDeviceCd = fRegDeviceCd;
	}
	public Date getfRegDateTime() {
		return fRegDateTime;
	}
	public void setfRegDateTime(Date fRegDateTime) {
		this.fRegDateTime = fRegDateTime;
	}
	public Date getfRegDateTimeSvr() {
		return fRegDateTimeSvr;
	}
	public void setfRegDateTimeSvr(Date fRegDateTimeSvr) {
		this.fRegDateTimeSvr = fRegDateTimeSvr;
	}
	public String getfTableName() {
		return fTableName;
	}
	public void setfTableName(String fTableName) {
		this.fTableName = fTableName;
	}
	public String getMainImg1() {
		return mainImg1;
	}
	public void setMainImg1(String mainImg1) {
		this.mainImg1 = mainImg1;
	}
	
	

}
