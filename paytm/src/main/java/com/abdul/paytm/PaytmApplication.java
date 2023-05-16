package com.abdul.paytm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PaytmApplication {

	private static final Log logger = LogFactory.getLog(PaytmApplication.class);
	
	@GetMapping("/")
	public String paytmHello() {
		logger.info("********* Hello Caller from paytm");
		return "Hello Abdul from Paytm";
	}
	public static void main(String[] args) {
		SpringApplication.run(PaytmApplication.class, args);
	}

}
