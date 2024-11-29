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
	public List<BaMypageDto> BaMypageBookingSelectListAll() {
		return baMypageDao.BaMypageBookingSelectListAll();
	}

	

}
