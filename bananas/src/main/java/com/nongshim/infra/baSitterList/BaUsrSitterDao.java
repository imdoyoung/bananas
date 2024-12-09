package com.nongshim.infra.baSitterList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nongshim.infra.baCodeGroup.BaCodeGroupVo;

@Repository
public interface BaUsrSitterDao {
	
	public List<BaUsrSitterDto> selectList(BaUsrSitterVo baUsrSitterVo);
	
	public int sitterInsert(BaUsrSitterDto baUsrSitterDto);
	
	public BaUsrSitterDto selectOne(BaUsrSitterDto baUsrSitterDto);
	
	public List<BaUsrSitterDto> reSelectList();
	
	public int reInsert(BaUsrSitterDto baUsrSitterDto);
	
	public List<BaUsrSitterDto> opSelectList();
	
	public int selectOneCount(BaUsrSitterVo baUsrSitterVo);

}
