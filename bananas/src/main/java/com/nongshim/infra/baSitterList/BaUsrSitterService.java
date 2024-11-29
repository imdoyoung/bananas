package com.nongshim.infra.baSitterList;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BaUsrSitterService {
	
	@Autowired
	private BaUsrSitterDao baUsrSitterDao;
	
	public List<BaUsrSitterDto>selectList(){
       return baUsrSitterDao.selectList();
    }
	
	public int sitterInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.sitterInsert(baUsrSitterDto);
	}
	
	public BaUsrSitterDto selectOne(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.selectOne(baUsrSitterDto);
	}
	
	public List<BaUsrSitterDto>reSelectList(){
	    return baUsrSitterDao.reSelectList();
	}
	public int reInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.reInsert(baUsrSitterDto);
	}
	
	public List<BaUsrSitterDto>opSelectList(){
	    return baUsrSitterDao.opSelectList();
	}
	

	public ReadyResponse payReady(String name, int totalPrice , int quantity, String userId) {
		Random random = new Random();
		String randomNumberString = String.valueOf((long) (random.nextDouble() * 9999999999L));
		String url = "http://localhost";
		
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");                                    // 가맹점 코드(테스트용)
        parameters.put("partner_order_id", "O"+randomNumberString);                       // 주문번호
        parameters.put("partner_user_id", userId);                          // 회원 아이디
        parameters.put("item_name", name);                                      // 상품명
        parameters.put("quantity", String.valueOf(quantity));                                        // 상품 수량
        parameters.put("total_amount", String.valueOf(totalPrice));             // 상품 총액
        parameters.put("tax_free_amount", "0");                                 // 상품 비과세 금액
        parameters.put("approval_url", url+"/usr/v1/infra/baSitter/pay");       // 결제 성공 시 URL
        parameters.put("cancel_url", url+"/usr/v1/infra/baSitter/cancel");      // 결제 취소 시 URL
        parameters.put("fail_url", url+"/usr/v1/infra/baSitter/fail");          // 결제 실패 시 URL
        
        // HttpEntity : HTTP 요청 또는 응답에 해당하는 Http Header와 Http Body를 포함하는 클래스
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // RestTemplate
        // : Rest 방식 API를 호출할 수 있는 Spring 내장 클래스
        //   REST API 호출 이후 응답을 받을 때까지 기다리는 동기 방식 (json, xml 응답)
        RestTemplate template = new RestTemplate();
        url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        // RestTemplate의 postForEntity : POST 요청을 보내고 ResponseEntity로 결과를 반환받는 메소드
        ResponseEntity<ReadyResponse> responseEntity = template.postForEntity(url, requestEntity, ReadyResponse.class);
        System.out.println("결제준비 응답객체: " + responseEntity.getBody());

        return responseEntity.getBody();
	}
	
    // 카카오페이 측에 요청 시 헤더부에 필요한 값
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "SECRET_KEY " + "DEVC7E95EE4D196C2D130BFB9DB3240F9B59CAE4");
        headers.set("Content-type", "application/json");
//  application/json
        return headers;
    }
    
//    public int selectOneCount(BaUsrSitterVo baUsrSittervo){
//        return baUsrSitterDao.selectOneCount(baUsrSittervo);
//
//}
}
