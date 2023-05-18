package com.abdul.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EcommerceController {
	
	@Autowired
	private EcommerceService eCommerceService;

	@GetMapping("/ecom/begin")
	public TransactionStatus beginTransaction(@RequestParam(name = "name", required = false, value = "name") String name) {
		return new TransactionStatus(eCommerceService.beginTransaction(), true);
	}
	
}
