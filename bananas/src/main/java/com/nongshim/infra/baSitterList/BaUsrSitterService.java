package com.nongshim.infra.baSitterList;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BaUsrSitterService {

	@Autowired
	private BaUsrSitterDao baUsrSitterDao;
	
	// 시터 리스트 출력
	public List<BaUsrSitterDto>selectList(BaUsrSitterVo baUsrSitterVo){
       return baUsrSitterDao.selectList(baUsrSitterVo);
    }
	
	// 시터 리스트 페이지 페이징
	public int selectOneCount(BaUsrSitterVo baUsrSitterVo) {
		return baUsrSitterDao.selectOneCount(baUsrSitterVo);
	}
	
	// 시터 상세페이지 - 시터 정보 출력
	public BaUsrSitterDto selectOne(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.selectOne(baUsrSitterDto);
	}
	
	// 시터 상세페이지 - 리뷰 리스트 출력
	public List<BaUsrSitterDto>reSelectList(){
	    return baUsrSitterDao.reSelectList();
	}
	
	// 시터 상세페이지 - 리뷰 등록
	public int reInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.reInsert(baUsrSitterDto);
	}
	
	// 시터 상세페이지 - 예약 옵션 리스트 출력
	public List<BaUsrSitterDto>opSelectList(){
	    return baUsrSitterDao.opSelectList();
	}
	
	// sitterDetil에서 booking insert
	public int bookingInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.bookingInsert(baUsrSitterDto);
	}
	
	// sitterDetil에서 bookingOption insert
	public int bookingOptionInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.bookingOptionInsert(baUsrSitterDto);
	}
	


   
}