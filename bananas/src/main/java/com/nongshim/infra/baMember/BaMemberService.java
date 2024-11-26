package com.nongshim.infra.baMember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaMemberService {
	
	@Autowired
	BaMemberDao baMemberDao;
	
	// memberSelectList
	public List<BaMemberDto> memberSelectList() {
		return baMemberDao.memberSelectList();
	}
	
	// memberSelectOne
	public BaMemberDto memberSelectOne(BaMemberDto baMemberDto) {
		return baMemberDao.memberSelectOne(baMemberDto);
	}
	
	// memberInsert
	public int memberInsert(BaMemberDto baMemberDto) {
		return baMemberDao.memberInsert(baMemberDto);
	}
	
	// memberUpdate
	public int memberUpdate(BaMemberDto baMemberDto) {
		return baMemberDao.memberUpdate(baMemberDto);
	}
	
	// 관리자 로그인
	public BaMemberDto xdmSelectOneSignin(BaMemberDto baMemberDto) {
		return baMemberDao.xdmSelectOneSignin(baMemberDto);
	}
	
	// 관리자 로그인 세션 유지
	public BaMemberDto xdmSelectOneID(BaMemberDto baMemberDto) {
		return baMemberDao.xdmSelectOneID(baMemberDto);
	}

}
