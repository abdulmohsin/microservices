package com.abdul.ecommerce;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EcommerceController {
	
	@Autowired
	private EcommerceService eCommerceService;
	
	private static final Log logger = LogFactory.getLog(EcommerceController.class);
	

	@GetMapping("/ecom/begin")
	public TransactionStatus beginTransaction(@RequestParam(name = "name", required = false, value = "name") String name) {
		logger.info("***** Transaction started from ecommerce service");
		return new TransactionStatus(eCommerceService.beginTransaction(), true);
	}
	
}
