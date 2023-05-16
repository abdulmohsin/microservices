package com.abdul.dbservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RefreshedConsumer {

	private static final Log logger = LogFactory.getLog(RefreshedConsumer.class);
	
	@Autowired
	private DBConfig dbConfig;

	@Scheduled(fixedDelay = 2000)
	public void printLatestProp() {
		logger.info("********** Prop value : "+ dbConfig.getNameAutorefreshed());
	}
}
