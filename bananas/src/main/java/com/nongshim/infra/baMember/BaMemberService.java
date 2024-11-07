package com.nongshim.infra.baMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaMemberService {
	
	@Autowired
	BaMemberDao baMemberDao;
	
	// 관리자 로그인
	public BaMemberDto xdmSelectOneSignin(BaMemberDto baMemberDto) {
		return baMemberDao.xdmSelectOneSignin(baMemberDto);
	}
	
	// 관리자 로그인 세션 유지
	public BaMemberDto xdmSelectOneID(BaMemberDto baMemberDto) {
		return baMemberDao.xdmSelectOneID(baMemberDto);
	}

}
