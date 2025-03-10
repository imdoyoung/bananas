package com.nongshim.infra.baMypage;

import com.nongshim.common.Constants;

public class BaMypageVo {
	
	// paging 
	private int thisPage = 1;									// 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;		// 화면에 보여줄 데이터 줄 개수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;		// 화면에 보여줄 페이징 번호 개수

	private int totalRows;										// 전체 데이터 개수
	private int totalPages;										// 전체 페이지 번호
	private int startPage;										// 시작 페이지 번호
	private int endPage;										// 마지막 페이지 번호
 
	private int startRnumForMysql = 0;							// 쿼리 시작 row 
	
	private String basiSeq; // 시터 seq 
	private String bapeSeq; // 펫 seq
	private String bameSeq; // 멤버 seq
	
	private String baboSeq;
	
	
	//--
	public int getThisPage() {
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	public int getRowNumToShow() {
		return rowNumToShow;
	}
	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}
	public int getPageNumToShow() {
		return pageNumToShow;
	}
	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}
	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}
	public String getBasiSeq() {
		return basiSeq;
	}
	public void setBasiSeq(String basiSeq) {
		this.basiSeq = basiSeq;
	}
	public String getBapeSeq() {
		return bapeSeq;
	}
	public void setBapeSeq(String bapeSeq) {
		this.bapeSeq = bapeSeq;
	}
	public String getBaboSeq() {
		return baboSeq;
	}
	public void setBaboSeq(String baboSeq) {
		this.baboSeq = baboSeq;
	}
	public String getBameSeq() {
		return bameSeq;
	}
	public void setBameSeq(String bameSeq) {
		this.bameSeq = bameSeq;
	}
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////
	
	
	


	public void setParamsPaging(int totalRows) {

		setTotalRows(totalRows);

		if (getTotalRows() == 0) { // 입력 받은 전체 데이터 개수가 0일때 
			setTotalPages(1); // 전체 페이지 번호는 1
		} else { // 그게 아니라면 
			setTotalPages(getTotalRows() / getRowNumToShow()); // (전체 페이지 번호) = (전체 데이터 개수) / (화면에 보여줄 데이터 줄 개수)
		}

		if (getTotalRows() % getRowNumToShow() > 0) { // (전체 데이터 개수) % (화면에 보여줄 데이터 줄 개수) 가 0보다 크면  
			setTotalPages(getTotalPages() + 1); // (전체 페이지 번호) = (전체 페이지 번호 + 1)
		}

		if (getTotalPages() < getThisPage()) { // (전체 페이지 번호) < (현재 페이지 번호) 일때 
			setThisPage(getTotalPages()); // (현재 페이지 번호) 는 (전페 페이지 번호)	
		}
		
		// (시작 페이지 번호) = (현제 페이지 번호 - 1) / (회면에 보여줄 페이징 번호 개수) * (회면에 보여줄 페이징 번호 개수 + 1)
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1); 
		
		// (마지막 페이지 번호) = (시작 페이지 번호) + (화면에 보여줄 페이징 번호 개수) - 1
		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) { // (마지막 페이지 번호) > (전체 페이지 번호) 일때 
			setEndPage(getTotalPages()); // (마지막 페이지 번호) = (전체 페이지 번호)
		}
		
		if (thisPage == 1) { // (현재 페이지가) 1일때 
			setStartRnumForMysql(0); // 쿼리 시작 row는 0
		} else {  // 그게 아니라면 
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1))); 
			// (쿼리 시작 row) = (화면에 보여줄  데이터 개수) * (현재 페이지) - 1
		}
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	

 }
