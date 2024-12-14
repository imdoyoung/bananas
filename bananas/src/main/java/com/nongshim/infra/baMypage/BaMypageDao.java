package com.nongshim.infra.baMypage;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaMypageDao {
	
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
	
	// 알림장 보기
	public BaMypageDto sitterNoticeSelectOne(BaMypageDto baMypageDto);
	
	// 알림장 쓰기(booking 마스터)
	public BaMypageDto sitterNoticeWriteSelectOne(BaMypageDto baMypageDto);
	
	// 알림장 쓰기(bookingoption 마스터)
	public List<BaMypageDto> sitterNoticeWriteSelectList(BaMypageDto baMypageDto);
	
	// 알림장 내용 insert
	public int sitterNoticeInsert(BaMypageDto baMypageDto);
	
	// 알림장 baboDiaryNy 0 -> 1 update
	public int sitterNoticeUpdate(BaMypageDto baMypageDto);
	
	// 알림장 내용 selectOne
	public BaMypageDto sitterNoticeContentSelectOne(BaMypageDto baMypageDto);
	
	
	


}
