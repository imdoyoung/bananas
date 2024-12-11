package com.nongshim.infra.baPayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaPaymentController {
	
	@Autowired
	BaPaymentService baPaymentService;
	
	//시터 예약 결제하기
		@RequestMapping(value="/usr/v1/infra/baPayment/baPaymentBook")
		public String baPaymentBook() {
			return "usr/v1/infra/baPayment/baPaymentBook";
		}
		
		
		//결제완료페이지 
		@RequestMapping(value="/usr/v1/infra/baPayment/baPaymentBookEnds")
		public String baPaymentBookEnds() {
			return "usr/v1/infra/baPayment/baPaymentBookEnds";
		}

}
