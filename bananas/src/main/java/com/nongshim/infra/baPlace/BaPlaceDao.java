package com.nongshim.infra.baPlace;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nongshim.infra.baSitterList.BaUsrSitterDto;

@Repository
public interface BaPlaceDao {
	
	// placeSelectList - 장소 리스트 출력
	public List<BaPlaceDto> placeSelectList(BaPlaceVo baPlaceVo);
	
	// placeSelectOneCount - 페이징
	public int placeSelectOneCount(BaPlaceVo baPlaceVo);
	
	// placeDetailList - 장소추천 세부리스트
	public List<BaPlaceDto> placeDetailList(BaPlaceDto baPlaceDto);
	
	// PlaceReviewInsert - 리뷰 insert
//	public int PlaceReviewInsert(BaPlaceDto baPlaceDto);
	
	// 시터 프로필 사진 업로드
	public int insertUploaded(BaPlaceDto baPlaceDto);

}
