package com.nongshim.infra.baMypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaMypageService {
	
	@Autowired
	BaMypageDao baMypageDao;
	
	// 이용자 마이페이지
	
	// 시터 리뷰 리스트
	public List<BaMypageDto> BaMypageReviewSelectList(BaMypageVo baMypageVo) {
		return baMypageDao.BaMypageReviewSelectList(baMypageVo);
	}
	
	// 장소 리뷰 리스트
	public List<BaMypageDto> BaMypagePlaceSelectList() {
		return baMypageDao.BaMypagePlaceSelectList();
	}
	
	// 리뷰 selectOne
	public BaMypageDto BaMypageSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.BaMypageSelectOne(baMypageDto);
	}
	
	// 시터 리뷰 paging  
	public int selectSitterOneCount(BaMypageVo baMypageVo) {
		return baMypageDao.selectSitterOneCount(baMypageVo);
	} 
	
	// 장소 리뷰 paging
	
	//--
	
	// 예약 내역 리스트
	public List<BaMypageDto> BaMypageBookingSelectList(BaMypageVo baMypageVo) {
		return baMypageDao.BaMypageBookingSelectList(baMypageVo);
	}
	
	// 예약 내역 selectOne
	public BaMypageDto BaMypagePriceSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.BaMypagePriceSelectOne(baMypageDto);
	}
	
	// 예약 내역 paging
	public int selectMypageBookingCount(BaMypageVo baMypageVo) {
		return baMypageDao.selectMypageBookingCount(baMypageVo);
	}
	
	// 예약 내역 상세 리스트
	public List<BaMypageDto> BaMypageBookingDetailsSelectList(BaMypageVo baMypageVo) {
		return baMypageDao.BaMypageBookingDetailsSelectList(baMypageVo);
	}
	
	// 예약 내역 상세 리스트 paging 
	public int selectMypageBookingDetailsCount(BaMypageVo baMypageVo) {
		return baMypageDao.selectMypageBookingDetailsCount(baMypageVo);
	}
	
	// 알림장 확인하기
	public List<BaMypageDto> BaMypageNoticeSelectList(BaMypageDto baMypageDto) {
		return baMypageDao.BaMypageNoticeSelectList(baMypageDto);
	}
	


	
	
	
	
	
	
	
	// 시터 마이페이지
	
	
	
	
	
	// 나의 예약 리스트 
	public List<BaMypageDto> sitterPageBookingSelectList(BaMypageVo baMypageVo) {
		return baMypageDao.sitterPageBookingSelectList(baMypageVo);
	}  
	
	// 나의 예약 paging
	public int sitterPageBookingCount(BaMypageVo baMypageVo) {
		return baMypageDao.sitterPageBookingCount(baMypageVo);
	}
	
	// 페이징 없는 예약 리스트
//	public List<BaMypageDto> BaMypageBookingSelectListAll() {
//		return baMypageDao.BaMypageBookingSelectListAll();
//	}
	
	// 나의 예약 페이징 없는 리스트(캘린더 용)
	public List<BaMypageDto> sitterPageBookingCalendarSelectList(BaMypageDto baMypageDto) {
		return baMypageDao.sitterPageBookingCalendarSelectList(baMypageDto);
	}
	
	// 나의 리뷰 리스트 
	public List<BaMypageDto> sitterMyReviewList(BaMypageVo baMypageVo) {
		return baMypageDao.sitterMyReviewList(baMypageVo);
	}
		
	// 나의 리뷰 paging
	public int sitterMyReviewSelectOneCount(BaMypageVo baMypageVo) {
		return baMypageDao.sitterMyReviewSelectOneCount(baMypageVo);
	}
	
	// 나의 리뷰 자세히 보기 selectOne
	public BaMypageDto sitterMyReviewSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.sitterMyReviewSelectOne(baMypageDto);
	}
	
	// 알림장 보기
	public BaMypageDto sitterNoticeSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeSelectOne(baMypageDto);
	}
	
	// 알림장 쓰기(booking 마스터)
	public BaMypageDto sitterNoticeWriteSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeWriteSelectOne(baMypageDto);
	}
	
	// 알림장 쓰기(bookingoption 마스터)
	public List<BaMypageDto> sitterNoticeWriteSelectList(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeWriteSelectList(baMypageDto);
	}
	
	// 알림장 내용 insert
	public int sitterNoticeInsert(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeInsert(baMypageDto);
	}
	
	// 알림장 baboDiaryNy 0 -> 1 update
	public int sitterNoticeUpdate(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeUpdate(baMypageDto);
	}
	
	// 알림장 내용 selectOne
    public BaMypageDto sitterNoticeContentSelectOne(BaMypageDto baMypageDto) {
    	return baMypageDao.sitterNoticeContentSelectOne(baMypageDto);
    }
	
	
	
	
	


}
