package com.nongshim.infra.baPlace;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BaPlaceController {
	
	@Autowired
	BaPlaceService baPlaceService;

	@RequestMapping(value="/usr/v1/infra/baPlace/baPlaceList")
	public String baPlaceList(Model model) {
		model.addAttribute("placeList", baPlaceService.placeSelectList());
		return "usr/v1/infra/baPlace/baPlaceList";
	}
	
	@RequestMapping(value="/usr/v1/infra/baPlace/baPlaceDetailList")
	public String baPlaceDetailList() {
		return "usr/v1/infra/baPlace/baPlaceDetailList";
	}
	
	
}
