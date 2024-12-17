package com.nongshim.infra.baSitterList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nongshim.infra.baCodeGroup.BaCodeGroupVo;

@Repository
public interface BaUsrSitterDao {
	
	// 시터 리스트 출력
	public List<BaUsrSitterDto> selectList(BaUsrSitterVo baUsrSitterVo);
	
	// 시터 리스트 페이지 페이징
	public int selectOneCount(BaUsrSitterVo baUsrSitterVo);
	
	// 시터 상세페이지 - 시터 정보 출력
	public BaUsrSitterDto selectOne(BaUsrSitterDto baUsrSitterDto);
	
	// 시터 상세페이지 - 리뷰 리스트 출력
	public List<BaUsrSitterDto> reSelectList();
	
	// 시터 상세페이지 - 리뷰 등록
	public int reInsert(BaUsrSitterDto baUsrSitterDto);
	
	// 시터 상세페이지 - 예약 옵션 리스트 출력
	public List<BaUsrSitterDto> opSelectList();
	
	// sitterDetil에서 booking insert
	public int bookingInsert(BaUsrSitterDto baUsrSitterDto);
	
	// sitterDetil에서 bookingOption insert
	public int bookingOptionInsert(BaUsrSitterDto baUsrSitterDto);
	
	// baUsrPayment 페이지 booking 테이블 정보 출력
	public BaUsrSitterDto paymentBookingSelectOne(BaUsrSitterDto baUsrSitterDto);
	
	// baUsrPayment 페이지 option 테이블 정보 출력
	public List<BaUsrSitterDto> paymentOptionSelectList(BaUsrSitterDto baUsrSitterDto);
	
	// baUsrPayment 페이지 결제정보 update
	public int paymentBookingUpdate(BaUsrSitterDto baUsrSitterDto);

}