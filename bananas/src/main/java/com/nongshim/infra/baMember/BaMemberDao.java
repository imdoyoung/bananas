package com.nongshim.infra.baMember;

import org.springframework.stereotype.Repository;

@Repository
public interface BaMemberDao {
	
	// 관리자 로그인
	public BaMemberDto xdmSelectOneSignin(BaMemberDto baMemberDto);
	
	// 관리자 로그인 세션 유지
	public BaMemberDto xdmSelectOneID(BaMemberDto baMemberDto);

}
