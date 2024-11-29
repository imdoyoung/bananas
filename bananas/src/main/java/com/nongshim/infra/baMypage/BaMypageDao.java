package com.nongshim.infra.baMypage;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaMypageDao {
	
	// 효빈아 받아라
	
	// 이용자 마이페이지
	
	// 시터 리뷰 리스트
	public List<BaMypageDto> BaMypageReviewSelectList(BaMypageVo baMypageVo);
	
	// 장소 리뷰 리스트
	public List<BaMypageDto> BaMypagePlaceSelectList();
	
	// 리뷰 selectOne
	public BaMypageDto BaMypageSelectOne(BaMypageDto baMypageDto);
	
	// 시터 리뷰 paging  
	public int selectSitterOneCount(BaMypageVo baMypageVo);
	
	// 장소 리뷰 paging 
	
	//--
	
	// 예약 내역 리스트
	public List<BaMypageDto> BaMypageBookingSelectList(BaMypageVo baMypageVo);
	
	// 예약 내역 selectOne
	public BaMypageDto BaMypagePriceSelectOne(BaMypageDto baMypageDto);
	
	// 예약 내역 paging
	public int selectMypageBookingCount(BaMypageVo baMypageVo);
	
	

	
	
	// 시터 마이페이지
	
	// 나의 예약 리스트 
	public List<BaMypageDto> sitterPageBookingSelectList(BaMypageVo baMypageVo);
	
	// 나의 예약 paging
	public int sitterPageBookingCount(BaMypageVo baMypageVo);
	
	// 페이징 없는 예약 리스트
	public List<BaMypageDto> BaMypageBookingSelectListAll();

	


}
