package com.nongshim.infra.baPlace;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BaPlaceController {

	@RequestMapping(value="/usr/v1/infra/baPlace/baPlaceList")
	public String baPlaceList(Model model) throws Exception {
		
		 // API
		 // 1. URL을 만들기 위한 StringBuilder
		 StringBuilder urlBuilder = new StringBuilder("https://www.pettravel.kr/api/detailSeqArea.do?areaCode=AC01&contentNum=2"); /*URL*/
		 
		 // 2. 오픈 API의 요청 규격에 맞는 파라미터 생성
//	     urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//	     urlBuilder.append("&" + URLEncoder.encode("pageBlock","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//	     urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("AC01", "UTF-8")); /*지역 코드*/
	     
	     // 3. URL 객체 생성 (String으로 변환)
	     URL url = new URL(urlBuilder.toString());
	     // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성
	     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	     // 5. 통신을 위한 메소드 세팅 ("GET")
	     conn.setRequestMethod("GET");
	     // 6. 통신을 위한 Content-type 세팅 ("JSON" 으로 해야함 - reuslt의 값은 String이기 때문에)
	     conn.setRequestProperty("Content-type", "application/json");
	     // 7. 통신 응답 코드 확인
	     System.out.println("Response code: " + conn.getResponseCode());
	     // 8. 전달받은 데이터를 BufferedReader 객체로 저장. 오류가 날 경우 error발생
	     BufferedReader rd;
	     if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	    	 rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	     } else {
	    	 rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	     }
	     
	     // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장
	     StringBuilder sb = new StringBuilder();
	     String line;
	     while ((line = rd.readLine()) != null) {
	    	 sb.append(line);
	     }
	     
	     // 10. 객체 해제
	     rd.close();
	     conn.disconnect();
	     System.out.println(sb.toString());
				
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(sb.toString());
//		
//		model.addAttribute("node", node.get("resultList").get("title"));
//			
//		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
//		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
//		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
		
		return "/usr/v1/infra/baPlace/baPlaceList";
	}
	
	@RequestMapping(value="/usr/v1/infra/baPlace/baPlaceDetailList")
	public String baPlaceDetailList() {
		return "/usr/v1/infra/baPlace/baPlaceDetailList";
	}
	
	
}
