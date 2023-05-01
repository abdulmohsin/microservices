package com.abdul.ecommerce;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.netflix.discovery.EurekaClient;

@Component
public class EcommerceScheduledJob {

	@Value("${eCommercePortalName:}")
	private String eCommercePortalName;

	@Autowired
	private Environment environment;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	private static final String APP_NAME="paytm";
	
	@Autowired
	private PaytmClient paytmClient;
	
	@Scheduled(fixedRate = 10000)
	public void performScheduledOperation() {
		System.out.println("*********  My config param eCommercePortalName : " + eCommercePortalName);
		System.out.println("*********  Spring.profile.active : " + Arrays.asList(environment.getActiveProfiles()));
		eurekaClient.getApplication(APP_NAME).getInstances().stream().forEach(x -> System.out.println("######################################\n"+ x.getId() +"\n******** Paytm Instance : \n pageURL" + x.getHomePageUrl() +"\n \n healthcheckURL: " + x.getHealthCheckUrl() +" \n\n status : " + x.getStatus()+"\n#############################"));
		System.out.println("********** Output from Paytm : "+ paytmClient.getPaytmOutput());
	}
}
