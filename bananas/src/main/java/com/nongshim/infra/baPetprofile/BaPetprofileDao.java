package com.nongshim.infra.baPetprofile;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaPetprofileDao {
	
	// PetSelectList
	public List<BaPetprofileDto> PetSelectList();
	
	// PetSelectOne
	public BaPetprofileDto PetSelectOne(BaPetprofileDto baPetprofileDto);
	
	// PetInsert
	public int PetInsert(BaPetprofileDto baPetprofileDto);

}
