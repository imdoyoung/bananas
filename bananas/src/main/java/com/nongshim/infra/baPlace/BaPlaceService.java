package com.nongshim.infra.baPlace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaPlaceService {
	
	@Autowired
	BaPlaceDao baPlaceDao;

	public List<BaPlaceDto> placeSelectList(BaPlaceVo baPlaceVo) {
		return baPlaceDao.placeSelectList(baPlaceVo);
	}
	
	// placeSelectOneCount - 페이징
	public int placeSelectOneCount(BaPlaceVo baPlaceVo) {
		return baPlaceDao.placeSelectOneCount(baPlaceVo);
	}
	
	// placeDetailList - 장소추천 세부리스트
	public List<BaPlaceDto> placeDetailList(BaPlaceDto baPlaceDto) {
		return baPlaceDao.placeDetailList(baPlaceDto);
	}
	
	// PlaceReviewInsert - 리뷰 insert
//	public int PlaceReviewInsert(BaPlaceDto baPlaceDto) {
//		return baPlaceDao.PlaceReviewInsert(baPlaceDto);
//	}
	
}
