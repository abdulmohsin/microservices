package com.abdul.dbservice;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DbserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DbserviceApplication.class, args);
	}

	@Bean
	public Consumer<String> getOrder(){
	 return x -> System.out.println("******** Order : "+ x +" consumed from getOrder() !");
	}
	
	@Bean
	public Consumer<String> getNewOrder(){
	 return x -> System.out.println("******** New Order : "+ x +" consumed from getNewOrder() !");
	}
	
}
