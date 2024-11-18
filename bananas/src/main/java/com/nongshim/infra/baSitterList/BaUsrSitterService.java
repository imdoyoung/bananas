package com.nongshim.infra.baSitterList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaUsrSitterService {
	
	@Autowired
	private BaUsrSitterDao baUsrSitterDao;
	
	public List<BaUsrSitterDto>selectList(){
       return baUsrSitterDao.selectList();
    }
	
	public int sitterInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.sitterInsert(baUsrSitterDto);
	}
	
	public BaUsrSitterDto selectOne(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.selectOne(baUsrSitterDto);
	}

}
