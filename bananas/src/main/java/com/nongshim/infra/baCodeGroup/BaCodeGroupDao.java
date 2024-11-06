package com.nongshim.infra.baCodeGroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaCodeGroupDao {
	
	//추상메서드
	//selectList
	public List<BaCodeGroupDto> selectList(BaCodeGroupVo baCodeGroupVo);
	
	// insert
	// int인 이유 : 데이터가 몇 건이 처리됐는지 확인하기 위해서
	public int insert(BaCodeGroupDto BaCodeGroupDto);
	
	
	// update - selectOne
	public BaCodeGroupDto selectOne(BaCodeGroupDto BaCodeGroupDto);
	
	// update - update
	// int인 이유 : 데이터가 몇 건이 처리됐는지 확인하기 위해서
	public int update(BaCodeGroupDto BaCodeGroupDto);
	
	
	// uelete
	public int uelete(BaCodeGroupDto BaCodeGroupDto);

	// delete
	public int delete(BaCodeGroupDto BaCodeGroupDto);

	// paging
	public int selectOneCount(BaCodeGroupVo baCodeGroupVo);
}
