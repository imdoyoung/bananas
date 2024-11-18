package com.nongshim.infra.baSitterList;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface BaUsrSitterDao {
	
	public List<BaUsrSitterDto> selectList();
	
	public int sitterInsert(BaUsrSitterDto baUsrSitterDto);
	
	public BaUsrSitterDto selectOne(BaUsrSitterDto baUsrSitterDto);

}
