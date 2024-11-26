package com.nongshim.infra.baMember;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaMemberDao {
	
	// memberSelectList
	public List<BaMemberDto> memberSelectList();
	
	// memberSelectOne
	public BaMemberDto memberSelectOne(BaMemberDto baMemberDto);
	
	// memberInsert
	public int memberInsert(BaMemberDto baMemberDto);
	
	// memberUpdate
	public int memberUpdate(BaMemberDto baMemberDto);
	
	// 관리자 로그인
	public BaMemberDto xdmSelectOneSignin(BaMemberDto baMemberDto);
	
	// 관리자 로그인 세션 유지
	public BaMemberDto xdmSelectOneID(BaMemberDto baMemberDto);

}
