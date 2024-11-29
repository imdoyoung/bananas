package com.nongshim.infra.baMeetPoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaMeetPointService {
	
	@Autowired
	BaMeetPointDao baMeetPointDao;
	
	// meetpointselectOne
	public BaMeetPointDto meetpointselectOne(BaMeetPointDto baMeetPointDto) {
		
		System.out.println("DTO 전달값 Latitude: " + baMeetPointDto.getMidpointLatitude());
		System.out.println("DTO 전달값 Longitude: " + baMeetPointDto.getMidpointLongitude());
		
		System.out.println("DAO 호출 전: " + baMeetPointDto);
		
		BaMeetPointDto result = baMeetPointDao.meetpointselectOne(baMeetPointDto);
		
		System.out.println("DAO 반환값: " + result);
		
//		return baMeetPointDao.meetpointselectOne(baMeetPointDto);
		
		return result;
	};

}
