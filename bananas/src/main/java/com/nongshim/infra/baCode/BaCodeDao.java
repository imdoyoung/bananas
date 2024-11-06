package com.nongshim.infra.baCode;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaCodeDao {
	
	// 추상메소드
	// selectList
	public List<BaCodeDto> selectList(BaCodeVo baCodeVo);
		
	// selectListCodeGroup
	// code - codegroup 연결
	public List<BaCodeDto> selectListCodeGroup();
	
	// insert
	public int insert(BaCodeDto baCodeDto);
		
	// selectOne
	public BaCodeDto selectOne(BaCodeDto baCodeDto);
		
	// update
	public int update(BaCodeDto baCodeDto);
	
	// uelete
	public int uelete(BaCodeDto baCodeDto);
		
	// delete
	public int delete(BaCodeDto baCodeDto);
		
	// paging
	public int selectOneCount(BaCodeVo baCodeVo);
		
	// for cache
	public List<BaCodeDto> selectListCachedCodeArrayList();

}
