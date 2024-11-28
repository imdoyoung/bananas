package com.nongshim.infra.baMeetPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaMeetPointService {
	
	@Autowired
	BaMeetPointDao baMeetPointDao;
	
	// meetpointselectlist
	public List<BaMeetPointDto> meetpointselectlist(BaMeetPointDto baMeetPointDto) {
		return baMeetPointDao.meetpointselectlist(baMeetPointDto);
	};

}
