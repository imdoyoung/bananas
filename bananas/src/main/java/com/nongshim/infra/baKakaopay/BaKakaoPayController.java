package com.nongshim.infra.baKakaopay;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaKakaoPayController {
	
	@Autowired
	BaKakaoPayDao bdao;

	@RequestMapping(value="/usr/v1/infra/baKakaopay/jq")
	public ModelAndView main(ModelAndView mv, HttpSession s, RedirectView rv ) {
		mv.setViewName("jq/serve");
		return mv;
	}
	
	@RequestMapping(value="/usr/v1/infra/baKakaopay/pay")
	public ModelAndView serve(ModelAndView mv, HttpSession s, RedirectView rv ) {
		mv.setViewName("jq/serve");
		return mv;
	}

	@RequestMapping(value="/usr/v1/infra/baKakaopay/kakaopay")
	@ResponseBody
	public String kakaopay() {

		try {
			URL address = new URL("https://open-api.kakaopay.com/online/v1/payment/ready HTTP/1.1");
			HttpURLConnection serverConnection = (HttpURLConnection)address.openConnection();
			serverConnection.setRequestMethod("POST");
			serverConnection.setRequestProperty("Authorization", "SECRET_KEY 02a73b108a71279c601a4938f1b63a59");
			serverConnection.setRequestProperty("Content-Type", "application/json");
			serverConnection.setDoOutput(true);
			String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=초코파이&quantity=1&total_amount=2200&tax_free_amount=0&approval_url=http://localhost/usr/v1/infra/baKakaopay/pay&cancel_url=http://localhost/cancel&fail_url=http://localhost/fail";
			
			OutputStream output = serverConnection.getOutputStream();
			DataOutputStream dataOutput = new DataOutputStream(output);
			dataOutput.writeBytes(parameter);
			dataOutput.close();
			
			int resultCode = serverConnection.getResponseCode();
			
			InputStream input;
			if(resultCode == 200) {
				input = serverConnection.getInputStream();
			}else {
				input = serverConnection.getErrorStream();
			}
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader br = new BufferedReader(reader);
			return br.readLine();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return "{\"result\":\"NO\"}";  

	}

}