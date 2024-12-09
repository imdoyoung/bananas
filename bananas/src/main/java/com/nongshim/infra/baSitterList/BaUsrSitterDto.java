package com.nongshim.infra.baSitterList;

import java.util.Date;
 
public class BaUsrSitterDto {
	
	private String basiSeq;
	private String basiName;
	private String basiId;
	private String basiPw;
	private Integer basiGender;
	private String basiCareer;
	private String basiZipCode;
	private String basiAddr;
	private String basiAddrDetail;
	private String basiEmail;
	private String basiDesc;
	private String basiTel;
	private Integer basiTosNy;
	private Integer basiUseNy;
	private Integer basiDelNy;
	private Date basiRegDate;
	private Date basiEditDate;
	
	private String bareSeq;
	private Integer bareType;
	private Integer bareStar; 
	private String bareContents; 
	private Date bareRegDate; 
	private Date bareEditDate; 
	private Integer bareDelNy;
	
	
	private String baopSeq;
	private Integer baopType;
	private String baopName;
	private Integer baopPrice;
	private Integer baopUseNy; 
	private Integer baopDelNy;
	
	private String baboSeq; 
	private Date baboDate;
	private Integer baboTime;
    private String baboLocation;
    private Integer baboPayment;
    private Integer baboTotalPrice;
    private Date baboSettleDate;
    private Date baboRegDate;
    private Date baboEditDate;
    private Integer baboDelNy;
    
	private String name;      // 주문 상품 이름
	private int quantity;      // 주문 수량
    private int totalPrice;   // 주문 금액
    private String userId;
    

	//--------Getter setter----------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBasiSeq() {
		return basiSeq;
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
	public Integer getBaboTime() {
		return baboTime;
	}
	public void setBaboTime(Integer baboTime) {
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
	public String getBasiCareer() {
		return basiCareer;
	}
	public void setBasiCareer(String basiCareer) {
		this.basiCareer = basiCareer;
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

	
			 
}
