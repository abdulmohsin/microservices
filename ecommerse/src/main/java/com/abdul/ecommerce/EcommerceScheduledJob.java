package com.abdul.ecommerce;

import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EcommerceScheduledJob {

	@Value("${eCommercePortalName:}")
	private String eCommercePortalName;

	@Autowired
	private Environment environment;
	
	@Autowired
	private PaytmCaller paytmCaller;
	
	@Autowired
	private StreamBridge streamBridge;
	
	@Scheduled(fixedRate = 60000)
	public void performScheduledOperation() {
		System.out.println("*********  My config param eCommercePortalName : " + eCommercePortalName);
		System.out.println("*********  Spring.profile.active : " + Arrays.asList(environment.getActiveProfiles()));
		paytmCaller.callPaytmSync();
		
		// Output to stream
		System.out.println("*********** Sending to stream");
		streamBridge.send("supplyOrder-out", "Hello output"+ LocalTime.now());
	}

}
