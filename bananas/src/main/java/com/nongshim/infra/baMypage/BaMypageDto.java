package com.nongshim.infra.baMypage;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class BaMypageDto {
	
	// 리뷰
	private String bareSeq;
	private Integer bareType; 
	private Integer bareStar; 
	private String bareContents;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bareRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bareEditDate; 
	private Integer bareDelNy; 
	private String ba_Place_baplSeq; 
	private String ba_booking_baboSeq;
	
	// 예약
	private String baboSeq;  
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date baboDate; 
	@DateTimeFormat(pattern="HH:mm:ss")
	private Date baboTime; 
	private String baboLocation;
	private Integer baboPayment;
	private Integer baboTotalPrice; 
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date baboSettleDate; 
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date baboRegDate; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date baboEditDate; 
	private Integer baboDelNy; 
	private String ba_Petprofile_bapeSeq; 
	private String ba_SitterList_basiSeq; 
	private Integer baboDiaryNy;
	
	// 예약 내역 
	private String baboopSeq;
	private Integer baboopUseNy;
	private Integer baboopDelNy;
	private String ba_Option_baopSeq;
	
	// 메뉴 
	private String baopSeq;
	private Integer baopType;
	private String baopName; 
	private Integer baopPrice;
	private Integer baopUseNy; 
	private Integer baopDelNy;
	
	// 펫프로필
	private String bapeSeq; 
	private String bapeName; 
	private Integer bapeGender; 
	private String bapeType; 
	private String bapeAge;
	private String bapeWeight;  
	private Integer bapeNtrNy; 
	private String bapehospital; 
	private String bapeDesc; 
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bapeRegDate; 
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bapeEditDate; 
	private Integer bapeUseNy; 
	private Integer apeDelNy;
	private String ba_Member_bameSeq;
	
	// 멤버 
	private String bameSeq;
	private String bameName;
	private String bameId;
	private String bamePw;
	private Integer bameGender;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
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
	
	// 시터 
	private String basiSeq; 
	private String basiName; 
	private String basiId;
	private String basiPw; 
	private Integer basiGender; 
	private Integer basiGrade; 
	private String basiCareer; 
	private String basiDesc; 
    private String basiTel; 
    private String basiZipCode; 
    private String basiAddr; 
    private String basiAddrDetail; 
    private String basiEmail; 
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date basiRegDate; 
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date basiEditDate; 
    private Integer basiTosNy; 
    private Integer basiUseNy; 
    private Integer basiDelNy;
    
    // 장소
    private String baplSeq;
    private Integer baplType;
    private String baplName;
    private String baplComment;
    private String baplZipCode;
    private String baplAddr;
    private String baplAddrDetail;
    private String baplTel;
    private String baplTime;
    private Date baplRegDate;
    private Date baplEditDate;
    private Integer baplUseNy;
    private Integer baplDelNy;
    
    // 알림장
    private String badiSeq;
    private String badiContent;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date badiRegDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date badiEditDate;
    private Integer badiDelNy;
    private String ba_bookingoption_baboopSeq;
    
	// 알림장 사진 파일첨부 
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
	private String fRegSeq;
	private Integer fRegDeviceCd;
	private Date fRegDateTime;
	private Date fRegDateTimeSvr;
	private String fTableName;
	
	// 사진 이름!!!
	private String mainImg1;
    
    //--
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
	public String getBa_Place_baplSeq() {
		return ba_Place_baplSeq;
	}
	public void setBa_Place_baplSeq(String ba_Place_baplSeq) {
		this.ba_Place_baplSeq = ba_Place_baplSeq;
	}
	public String getBa_booking_baboSeq() {
		return ba_booking_baboSeq;
	}
	public void setBa_booking_baboSeq(String ba_booking_baboSeq) {
		this.ba_booking_baboSeq = ba_booking_baboSeq;
	}
	public String getBaboSeq() {
		return baboSeq;
	}
	public void setBaboSeq(String baboSeq) {
		this.baboSeq = baboSeq;
	}
	public Date getBaboDate() {
		return baboDate;
	}
	public void setBaboDate(Date baboDate) {
		this.baboDate = baboDate;
	}
	public Date getBaboTime() {
		return baboTime;
	}
	public void setBaboTime(Date baboTime) {
		this.baboTime = baboTime;
	}
	public String getBaboLocation() {
		return baboLocation;
	}
	public void setBaboLocation(String baboLocation) {
		this.baboLocation = baboLocation;
	}
	public Integer getBaboPayment() {
		return baboPayment;
	}
	public void setBaboPayment(Integer baboPayment) {
		this.baboPayment = baboPayment;
	}
	public Integer getBaboTotalPrice() {
		return baboTotalPrice;
	}
	public void setBaboTotalPrice(Integer baboTotalPrice) {
		this.baboTotalPrice = baboTotalPrice;
	}
	public Date getBaboSettleDate() {
		return baboSettleDate;
	}
	public void setBaboSettleDate(Date baboSettleDate) {
		this.baboSettleDate = baboSettleDate;
	}
	public Date getBaboRegDate() {
		return baboRegDate;
	}
	public void setBaboRegDate(Date baboRegDate) {
		this.baboRegDate = baboRegDate;
	}
	public Date getBaboEditDate() {
		return baboEditDate;
	}
	public void setBaboEditDate(Date baboEditDate) {
		this.baboEditDate = baboEditDate;
	}
	public Integer getBaboDelNy() {
		return baboDelNy;
	}
	public void setBaboDelNy(Integer baboDelNy) {
		this.baboDelNy = baboDelNy;
	}
	public String getBa_Petprofile_bapeSeq() {
		return ba_Petprofile_bapeSeq;
	}
	public void setBa_Petprofile_bapeSeq(String ba_Petprofile_bapeSeq) {
		this.ba_Petprofile_bapeSeq = ba_Petprofile_bapeSeq;
	}
	public String getBa_SitterList_basiSeq() {
		return ba_SitterList_basiSeq;
	}
	public void setBa_SitterList_basiSeq(String ba_SitterList_basiSeq) {
		this.ba_SitterList_basiSeq = ba_SitterList_basiSeq;
	}
	public Integer getBaboDiaryNy() {
		return baboDiaryNy;
	}
	public void setBaboDiaryNy(Integer baboDiaryNy) {
		this.baboDiaryNy = baboDiaryNy;
	}
	public String getBaboopSeq() {
		return baboopSeq;
	}
	public void setBaboopSeq(String baboopSeq) {
		this.baboopSeq = baboopSeq;
	}
	public Integer getBaboopUseNy() {
		return baboopUseNy;
	}
	public void setBaboopUseNy(Integer baboopUseNy) {
		this.baboopUseNy = baboopUseNy;
	}
	public Integer getBaboopDelNy() {
		return baboopDelNy;
	}
	public void setBaboopDelNy(Integer baboopDelNy) {
		this.baboopDelNy = baboopDelNy;
	}
	public String getBa_Option_baopSeq() {
		return ba_Option_baopSeq;
	}
	public void setBa_Option_baopSeq(String ba_Option_baopSeq) {
		this.ba_Option_baopSeq = ba_Option_baopSeq;
	}
	public String getBaopSeq() {
		return baopSeq;
	}
	public void setBaopSeq(String baopSeq) {
		this.baopSeq = baopSeq;
	}
	public Integer getBaopType() {
		return baopType;
	}
	public void setBaopType(Integer baopType) {
		this.baopType = baopType;
	}
	public String getBaopName() {
		return baopName;
	}
	public void setBaopName(String baopName) {
		this.baopName = baopName;
	}
	public Integer getBaopPrice() {
		return baopPrice;
	}
	public void setBaopPrice(Integer baopPrice) {
		this.baopPrice = baopPrice;
	}
	public Integer getBaopUseNy() {
		return baopUseNy;
	}
	public void setBaopUseNy(Integer baopUseNy) {
		this.baopUseNy = baopUseNy;
	}
	public Integer getBaopDelNy() {
		return baopDelNy;
	}
	public void setBaopDelNy(Integer baopDelNy) {
		this.baopDelNy = baopDelNy;
	}
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
	public Integer getApeDelNy() {
		return apeDelNy;
	}
	public void setApeDelNy(Integer apeDelNy) {
		this.apeDelNy = apeDelNy;
	}
	public String getBa_Member_bameSeq() {
		return ba_Member_bameSeq;
	}
	public void setBa_Member_bameSeq(String ba_Member_bameSeq) {
		this.ba_Member_bameSeq = ba_Member_bameSeq;
	}
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
	public String getBasiSeq() {
		return basiSeq;
	}
	public void setBasiSeq(String basiSeq) {
		this.basiSeq = basiSeq;
	}
	public String getBasiName() {
		return basiName;
	}
	public void setBasiName(String basiName) {
		this.basiName = basiName;
	}
	public String getBasiId() {
		return basiId;
	}
	public void setBasiId(String basiId) {
		this.basiId = basiId;
	}
	public String getBasiPw() {
		return basiPw;
	}
	public void setBasiPw(String basiPw) {
		this.basiPw = basiPw;
	}
	public Integer getBasiGender() {
		return basiGender;
	}
	public void setBasiGender(Integer basiGender) {
		this.basiGender = basiGender;
	}
	public Integer getBasiGrade() {
		return basiGrade;
	}
	public void setBasiGrade(Integer basiGrade) {
		this.basiGrade = basiGrade;
	}
	public String getBasiCareer() {
		return basiCareer;
	}
	public void setBasiCareer(String basiCareer) {
		this.basiCareer = basiCareer;
	}
	public String getBasiDesc() {
		return basiDesc;
	}
	public void setBasiDesc(String basiDesc) {
		this.basiDesc = basiDesc;
	}
	public String getBasiTel() {
		return basiTel;
	}
	public void setBasiTel(String basiTel) {
		this.basiTel = basiTel;
	}
	public String getBasiZipCode() {
		return basiZipCode;
	}
	public void setBasiZipCode(String basiZipCode) {
		this.basiZipCode = basiZipCode;
	}
	public String getBasiAddr() {
		return basiAddr;
	}
	public void setBasiAddr(String basiAddr) {
		this.basiAddr = basiAddr;
	}
	public String getBasiAddrDetail() {
		return basiAddrDetail;
	}
	public void setBasiAddrDetail(String basiAddrDetail) {
		this.basiAddrDetail = basiAddrDetail;
	}
	public String getBasiEmail() {
		return basiEmail;
	}
	public void setBasiEmail(String basiEmail) {
		this.basiEmail = basiEmail;
	}
	public Date getBasiRegDate() {
		return basiRegDate;
	}
	public void setBasiRegDate(Date basiRegDate) {
		this.basiRegDate = basiRegDate;
	}
	public Date getBasiEditDate() {
		return basiEditDate;
	}
	public void setBasiEditDate(Date basiEditDate) {
		this.basiEditDate = basiEditDate;
	}
	public Integer getBasiTosNy() {
		return basiTosNy;
	}
	public void setBasiTosNy(Integer basiTosNy) {
		this.basiTosNy = basiTosNy;
	}
	public Integer getBasiUseNy() {
		return basiUseNy;
	}
	public void setBasiUseNy(Integer basiUseNy) {
		this.basiUseNy = basiUseNy;
	}
	public Integer getBasiDelNy() {
		return basiDelNy;
	}
	public void setBasiDelNy(Integer basiDelNy) {
		this.basiDelNy = basiDelNy;
	}
	public String getBaplSeq() {
		return baplSeq;
	}
	public void setBaplSeq(String baplSeq) {
		this.baplSeq = baplSeq;
	}
	public Integer getBaplType() {
		return baplType;
	}
	public void setBaplType(Integer baplType) {
		this.baplType = baplType;
	}
	public String getBaplName() {
		return baplName;
	}
	public void setBaplName(String baplName) {
		this.baplName = baplName;
	}
	public String getBaplComment() {
		return baplComment;
	}
	public void setBaplComment(String baplComment) {
		this.baplComment = baplComment;
	}
	public String getBaplZipCode() {
		return baplZipCode;
	}
	public void setBaplZipCode(String baplZipCode) {
		this.baplZipCode = baplZipCode;
	}
	public String getBaplAddr() {
		return baplAddr;
	}
	public void setBaplAddr(String baplAddr) {
		this.baplAddr = baplAddr;
	}
	public String getBaplAddrDetail() {
		return baplAddrDetail;
	}
	public void setBaplAddrDetail(String baplAddrDetail) {
		this.baplAddrDetail = baplAddrDetail;
	}
	public String getBaplTel() {
		return baplTel;
	}
	public void setBaplTel(String baplTel) {
		this.baplTel = baplTel;
	}
	public String getBaplTime() {
		return baplTime;
	}
	public void setBaplTime(String baplTime) {
		this.baplTime = baplTime;
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
	public String getBadiSeq() {
		return badiSeq;
	}
	public void setBadiSeq(String badiSeq) {
		this.badiSeq = badiSeq;
	}
	public String getBadiContent() {
		return badiContent;
	}
	public void setBadiContent(String badiContent) {
		this.badiContent = badiContent;
	}
	public Date getBadiRegDate() {
		return badiRegDate;
	}
	public void setBadiRegDate(Date badiRegDate) {
		this.badiRegDate = badiRegDate;
	}
	public Date getBadiEditDate() {
		return badiEditDate;
	}
	public void setBadiEditDate(Date badiEditDate) {
		this.badiEditDate = badiEditDate;
	}
	public Integer getBadiDelNy() {
		return badiDelNy;
	}
	public void setBadiDelNy(Integer badiDelNy) {
		this.badiDelNy = badiDelNy;
	}
	public String getBa_bookingoption_baboopSeq() {
		return ba_bookingoption_baboopSeq;
	}
	public void setBa_bookingoption_baboopSeq(String ba_bookingoption_baboopSeq) {
		this.ba_bookingoption_baboopSeq = ba_bookingoption_baboopSeq;
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
	public String getfRegSeq() {
		return fRegSeq;
	}
	public void setfRegSeq(String fRegSeq) {
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
