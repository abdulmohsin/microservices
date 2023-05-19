package com.abdul.dbservice;

import java.time.ZonedDateTime;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.abdul.dbservice.repository.Order;
import com.abdul.dbservice.repository.OrderRepository;

@SpringBootApplication
@EnableScheduling
public class DbserviceApplication {
	
	private static final Log logger = LogFactory.getLog(DbserviceApplication.class);
	
	@Autowired
	private OrderRepository orderRepository;
	 
	public static void main(String[] args) {
		SpringApplication.run(DbserviceApplication.class, args);
	}

	@Bean
	public Consumer<String> getOrder(){
	 return x -> {
		 logger.info("******** Order : "+ x +" consumed from getOrder() !");
		 Order order = new Order();
		 order.setAcceptanceDateTime(ZonedDateTime.now());
		 order.setOrderId(x);		 
		 orderRepository.save(order);
		 
	 };
	}
	
	@Bean
	public Consumer<String> getNewOrder(){
	 return x -> {
		 logger.info("******** New Order : "+ x +" consumed from getNewOrder() !");
		 
		 Order order = new Order();
		 order.setAcceptanceDateTime(ZonedDateTime.now());
		 order.setOrderId(x +" - 2");		 
		 orderRepository.save(order);
	 };
	}
	
}
