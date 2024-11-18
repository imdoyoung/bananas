package com.nongshim.infra.baPlace;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BaPlaceController {

	@RequestMapping(value="/usr/v1/infra/baPlace/baPlaceList")
	public String baPlaceList() {
		
		// API
//		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551011/KorPetTourService/detailCommon?serviceKey=NbI1b9h7KgOqb%252B31Yf1PETThy2SUYDCddS95jD5cnhBizLTSpMYO%252F3DyipSM3V1VPaqOXAonaoV%252FeLouDlud4Q%253D%253D&numOfRows=9&pageNo=1&MobileOS=ETC&MobileApp=Pet%20With%20Me&contentId=Pet%20With%20Me"); /*URL*/
//		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=NbI1b9h7KgOqb%252B31Yf1PETThy2SUYDCddS95jD5cnhBizLTSpMYO%252F3DyipSM3V1VPaqOXAonaoV%252FeLouDlud4Q%253D%253D"); /*Service Key*/
//		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과 수*/
//		urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) default : xml*/
//		urlBuilder.append("&" + URLEncoder.encode("YYYY","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*년도*/
//		urlBuilder.append("&" + URLEncoder.encode("MM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*실적월*/
//		URL url = new URL(urlBuilder.toString());
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-type", "application/json");
//		System.out.println("Response code: " + conn.getResponseCode());
//		BufferedReader rd;
//		
//		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		} else {
//			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//		}
//		StringBuilder sb = new StringBuilder();
//		String line;
//		while ((line = rd.readLine()) != null) {
//			sb.append(line);
//		}
//		rd.close();
//		conn.disconnect();
//		System.out.println(sb.toString());
//				
//		ObjectMapper objectMapper = new ObjectMapper();
//		JsonNode node = objectMapper.readTree(sb.toString());
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
