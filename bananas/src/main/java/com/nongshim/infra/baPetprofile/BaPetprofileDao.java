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

	// PetUpdate
	public int PetUpdate(BaPetprofileDto baPetprofileDto);
	
	// 회원 로그인시 펫 시퀀스 넘기기
	public BaPetprofileDto selectOnePet(BaPetprofileDto baPetprofileDto);
	
	// 회원 로그인시 펫 세션 유지
	public BaPetprofileDto selectOnePetSeq(BaPetprofileDto baPetprofileDto);
	
}
