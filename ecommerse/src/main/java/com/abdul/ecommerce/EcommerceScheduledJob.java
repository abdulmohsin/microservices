package com.abdul.ecommerce;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EcommerceScheduledJob {

	private static final Log logger = LogFactory.getLog(EcommerceScheduledJob.class);
	
	
	@Autowired
	private EcommerceService eCommerceService;
	
	@Scheduled(fixedRate = 60000)
	public void performScheduledOperation() {
		eCommerceService.beginTransaction();
	}

}
