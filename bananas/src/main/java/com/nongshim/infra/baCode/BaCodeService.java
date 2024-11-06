package com.nongshim.infra.baCode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class BaCodeService {
	
	@Autowired
	private BaCodeDao baCodeDao;
	
	// selectList
	public List<BaCodeDto> selectList(BaCodeVo baCodeVo){
		return baCodeDao.selectList(baCodeVo);
	}
	
	// selectListCode
	// code - codegroup 연결
	public List<BaCodeDto> selectListCodeGroup(){
//		List<CodeDto> codeGroups = codeDao.selectListCodeGroup();
		return baCodeDao.selectListCodeGroup();
	}

	//insert
	public int insert(BaCodeDto baCodeDto) {
		return baCodeDao.insert(baCodeDto);
	}
	
	// selectOne
	public BaCodeDto selectOne(BaCodeDto baCodeDto) {
		return baCodeDao.selectOne(baCodeDto);
	}
	
	// update
	public int update(BaCodeDto baCodeDto) {
		return baCodeDao.update(baCodeDto);
	}
	
	// uelete
	public int uelete(BaCodeDto baCodeDto) {
		return baCodeDao.uelete(baCodeDto);
	}
	
	// delete
	public int delet(BaCodeDto baCodeDto) {
		return baCodeDao.delete(baCodeDto);
	}
	
	// paging
	public int selectOneCount(BaCodeVo baCodeVo) {
		return baCodeDao.selectOneCount(baCodeVo);
	}

// ----- ceche start ----- //
	// for cache
	@PostConstruct
	public void selectListCachedCodeArrayList() {
		System.out.println("selectListCachedCodeArrayList 함수 실행");
		List<BaCodeDto> codeListFromDb = (ArrayList<BaCodeDto>) baCodeDao.selectListCachedCodeArrayList();
		BaCodeDto.cachedCodeArrayList.clear();
		BaCodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + BaCodeDto.cachedCodeArrayList.size() + "chached!!");
	}
	
	// codeDto 캐싱 삭제
	public static void clear() {
		BaCodeDto.cachedCodeArrayList.clear();
	}
	
	// codeGroup의 seq 번호를 받고 해당하는 code의 내용을 List로 출력
	public static List<BaCodeDto> selectListCachedCode(String B_codegroup_ifcgSeq) {
		System.out.println("B_codegroup_ifcgSeq: " + B_codegroup_ifcgSeq);
		List<BaCodeDto> rt = new ArrayList<BaCodeDto>();
		for(BaCodeDto codeRow : BaCodeDto.cachedCodeArrayList) {
			if (codeRow.getBA_codegroup_ifcgSeq().equals(B_codegroup_ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	// code의 정보를 받아서 문자열로 반환
	public static String selectOneCachedCode(int baCode){
		System.out.println("baCode: " + baCode);
		String rt = "";
		for(BaCodeDto codeRow : BaCodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcdSeq().equals(Integer.toString(baCode))) {
				rt = codeRow.getIfcdName();
			} else {
				// by pass
			}
		}
		return rt;
	}
	
// ----- ceche end ----- //

}
