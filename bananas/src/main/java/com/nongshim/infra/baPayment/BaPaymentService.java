package com.nongshim.infra.baPayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaPaymentService {

	@Autowired
	private BaPaymentDao baPaymentDao;

}
