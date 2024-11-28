package com.nongshim.infra.baMeetPoint;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaMeetPointDao {
	
	// meetpointselectone
	public List<BaMeetPointDto> meetpointselectlist(BaMeetPointDto baMeetPointDto);
	
}
