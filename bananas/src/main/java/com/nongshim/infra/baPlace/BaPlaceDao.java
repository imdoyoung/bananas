package com.nongshim.infra.baPlace;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaPlaceDao {
	
	public List<BaPlaceDto> placeSelectList();

}
