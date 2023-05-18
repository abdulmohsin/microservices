package com.abdul.paytm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PaytmApplication {

	private static final Log logger = LogFactory.getLog(PaytmApplication.class);
	
	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@GetMapping("/paytm/hello")
	public String paytmHello() {
		logger.info("********* Hello Caller from paytm :) , active profile:"+ activeProfile);
		return "********* Hello Caller from paytm :)";
	}
	
	@GetMapping("/paytm/goodBye")
	public String paytmGoodBye() {
		logger.info(" #####  Good bye Caller from paytm :( , active profile:"+ activeProfile);
		return " #####  Good bye Caller from paytm :(";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PaytmApplication.class, args);
	}

}
