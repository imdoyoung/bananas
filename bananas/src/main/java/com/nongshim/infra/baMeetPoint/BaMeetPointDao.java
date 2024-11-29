package com.nongshim.infra.baMeetPoint;

import org.springframework.stereotype.Repository;

@Repository
public interface BaMeetPointDao {
	
	// meetpointselectOne
	public BaMeetPointDto meetpointselectOne(BaMeetPointDto baMeetPointDto);
	
}
