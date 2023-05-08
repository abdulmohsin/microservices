package com.abdul.paytm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PaytmApplication {

	@GetMapping("/")
	public String paytmHello() {
		System.out.println("********* Hello Caller from paytm");
		return "Hello Abdul from Paytm";
	}
	public static void main(String[] args) {
		SpringApplication.run(PaytmApplication.class, args);
	}

}
