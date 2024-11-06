package com.nongshim.infra.baCodeGroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaCodeGroupService {
	@Autowired
	private BaCodeGroupDao baCodeGroupDao;
	
	
	// 함수 안에 내용이 없을 경우 아래와 같이 줄여서 쓴다.
	public List<BaCodeGroupDto> selectList(BaCodeGroupVo baCodeGroupVo){
		return baCodeGroupDao.selectList(baCodeGroupVo);
	}
	
	// 축약형
	public int insert(BaCodeGroupDto baCodeGroupDto) {
		return baCodeGroupDao.insert(baCodeGroupDto);
	}
	
	// 축약형
	public BaCodeGroupDto selectOne(BaCodeGroupDto baCodeGroupDto) {
		return baCodeGroupDao.selectOne(baCodeGroupDto);
	}
	
	// 축약형
	public int update(BaCodeGroupDto baCodeGroupDto) {
		System.out.println(baCodeGroupDto.getIfcgSeq());
		return baCodeGroupDao.update(baCodeGroupDto);
	}
	
	// uelete
	public int uelete(BaCodeGroupDto baCodeGroupDto) {
		return baCodeGroupDao.uelete(baCodeGroupDto);
	}
	
	// delete
	public int delete(BaCodeGroupDto baCodeGroupDto) {
		return baCodeGroupDao.delete(baCodeGroupDto);
	}
	
	// paging
	public int selectOneCount(BaCodeGroupVo baCodeGroupVo) {
		return baCodeGroupDao.selectOneCount(baCodeGroupVo);
	}
	
}
