package com.abdul.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import reactor.core.publisher.Hooks;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class EcommerceApplication {

	public static void main(String[] args) {
		//Hooks.enableAutomaticContextPropagation();
		SpringApplication.run(EcommerceApplication.class, args);
	}

	/*
	 * @Bean public Supplier<String> supplyOrder(){ return () -> "order id:" +
	 * java.util.random.RandomGenerator.getDefault().nextInt(1, 100); }
	 */
}
