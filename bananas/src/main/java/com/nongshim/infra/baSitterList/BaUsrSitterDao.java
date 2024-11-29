package com.nongshim.infra.baSitterList;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface BaUsrSitterDao {
	
	public List<BaUsrSitterDto> selectList();
	
	public int sitterInsert(BaUsrSitterDto baUsrSitterDto);
	
	public BaUsrSitterDto selectOne(BaUsrSitterDto baUsrSitterDto);
	
	public List<BaUsrSitterDto> reSelectList();
	
	public int reInsert(BaUsrSitterDto baUsrSitterDto);
	
	public List<BaUsrSitterDto> opSelectList();
	
	//public int selectOneCount(BaUsrSitterVo baUsrSittervo);

}
