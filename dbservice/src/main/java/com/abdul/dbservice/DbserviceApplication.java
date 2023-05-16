package com.abdul.dbservice;

import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DbserviceApplication {
	
	private static final Log logger = LogFactory.getLog(DbserviceApplication.class);
	 
	public static void main(String[] args) {
		SpringApplication.run(DbserviceApplication.class, args);
	}

	@Bean
	public Consumer<String> getOrder(){
	 return x -> logger.info("******** Order : "+ x +" consumed from getOrder() !");
	}
	
	@Bean
	public Consumer<String> getNewOrder(){
	 return x -> logger.info("******** New Order : "+ x +" consumed from getNewOrder() !");
	}
	
}
