package com.nongshim.infra.baSitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaSitterService {
	
	@Autowired
	BaSitterDao baSitterDao;
	
	// 시터 로그인
	public BaSitterDto sitterLoginSelectOne(BaSitterDto baSitterDto) {
		return baSitterDao.sitterLoginSelectOne(baSitterDto);
	}

}
