package com.abdul.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.netflix.discovery.EurekaClient;

@Component
@RefreshScope
public class PaytmCaller {

	@Autowired
	private PaytmClient paytmClient;

	@Autowired
	private EurekaClient eurekaClient;
	
	@Value("${source}")
	private String source;

	private static final String APP_NAME = "paytm";

	public void callPaytmSync() {
		eurekaClient.getApplication(APP_NAME).getInstances().stream()
				.forEach(x -> System.out.println("#########\n" + x.getId()
						+ "\n******** Paytm Instance : \n pageURL" + x.getHomePageUrl() + "\n \n healthcheckURL: "
						+ x.getHealthCheckUrl() + " \n\n status : " + x.getStatus()
						+ "\n##########"));
		System.out.println("***** Source : "+ source);
		System.out.println("********** Output from Paytm : " + paytmClient.getPaytmOutput());
	}

}
