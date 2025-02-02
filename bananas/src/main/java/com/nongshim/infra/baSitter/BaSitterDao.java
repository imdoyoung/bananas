package com.nongshim.infra.baSitter;

import org.springframework.stereotype.Repository;

@Repository
public interface BaSitterDao {
	
	// 시터 로그인
	public BaSitterDto sitterLoginSelectOne(BaSitterDto baSitterDto);
	


}
