package com.abdul.ecommerce;

import java.time.LocalTime;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EcommerceScheduledJob {

	private static final Log logger = LogFactory.getLog(EcommerceScheduledJob.class);
	
	
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
		logger.info("*********  My config param eCommercePortalName : " + eCommercePortalName);
		logger.info("*********  Spring.profile.active : " + Arrays.asList(environment.getActiveProfiles()));
		paytmCaller.callPaytmSync();
		
		// Output to stream
		logger.info("*********** Sending to stream");
		streamBridge.send("supplyOrder-out", "Hello output"+ LocalTime.now());
	}

}
