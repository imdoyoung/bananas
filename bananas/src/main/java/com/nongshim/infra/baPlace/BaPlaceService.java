package com.nongshim.infra.baPlace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaPlaceService {
	
	@Autowired
	BaPlaceDao baPlaceDao;

	public List<BaPlaceDto> placeSelectList() {
		return baPlaceDao.placeSelectList();
	}
	
}
