package com.nongshim.infra.baMeetPoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaMeetPointService {
	
	@Autowired
	BaMeetPointDao baMeetPointDao;
	
	// meetpointselectOne
	public BaMeetPointDto meetpointselectOne(BaMeetPointDto baMeetPointDto) {
		return baMeetPointDao.meetpointselectOne(baMeetPointDto);
	};

}
