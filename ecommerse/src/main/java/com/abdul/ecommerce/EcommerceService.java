package com.abdul.ecommerce;

import java.time.LocalTime;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EcommerceService {

	private static final Log logger = LogFactory.getLog(EcommerceService.class);
	
	@Value("${eCommercePortalName:}")
	private String eCommercePortalName;

	@Autowired
	private Environment environment;
	
	@Autowired
	private PaytmCaller paytmCaller;
	
	@Autowired
	private StreamBridge streamBridge;
	
	public String beginTransaction() {
		logger.info("*********  My config param eCommercePortalName : " + eCommercePortalName);
		logger.info("*********  Spring.profile.active : " + Arrays.asList(environment.getActiveProfiles()));
		String output = paytmCaller.callPaytmSync();
		
		// Output to stream
		logger.info("*********** Sending to stream");
		streamBridge.send("supplyOrder-out", "Hello output"+ LocalTime.now());
		return output;
	}
}
