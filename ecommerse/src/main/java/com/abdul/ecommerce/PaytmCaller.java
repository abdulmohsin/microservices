package com.abdul.ecommerce;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	private static final Log logger = LogFactory.getLog(PaytmCaller.class);
	

	private static final String APP_NAME = "paytm";

	public void callPaytmSync() {
		eurekaClient.getApplication(APP_NAME).getInstances().stream()
				.forEach(x -> logger.info("#########\n" + x.getId()
						+ "\n******** Paytm Instance : \n pageURL" + x.getHomePageUrl() + "\n \n healthcheckURL: "
						+ x.getHealthCheckUrl() + " \n\n status : " + x.getStatus()
						+ "\n##########"));
		logger.info("***** Source : "+ source);
		logger.info("********** Output from Paytm : " + paytmClient.getPaytmOutput());
	}

}
