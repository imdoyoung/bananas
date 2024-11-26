package com.nongshim.infra.baPetprofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaPetprofileService {
	
	@Autowired
	private BaPetprofileDao baPetprofileDao;
	
	// PetSelectList
	public List<BaPetprofileDto> PetSelectList() {
		return baPetprofileDao.PetSelectList();
	}
	
	// PetSelectOne
	public BaPetprofileDto PetSelectOne(BaPetprofileDto baPetprofileDto) {
		return baPetprofileDao.PetSelectOne(baPetprofileDto);
	}
	
	// PetInsert
	public int PetInsert(BaPetprofileDto baPetprofileDto) {
		return baPetprofileDao.PetInsert(baPetprofileDto);
	}
	
	// PetUpdate
	public int PetUpdate(BaPetprofileDto baPetprofileDto) {
		return baPetprofileDao.PetUpdate(baPetprofileDto);
	}

}
