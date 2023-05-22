package com.abdul.dbservice;

import org.apache.commons.lang.StringUtils;
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
	
	private static String lastUpdatedValue;

	@Scheduled(fixedDelay = 2000)
	public void printLatestProp() {
		if(!StringUtils.isNotBlank(lastUpdatedValue)) {
			lastUpdatedValue = dbConfig.getNameAutorefreshed();
		}
		else if(!lastUpdatedValue.equals(dbConfig.getNameAutorefreshed())) {
			logger.info("********** Prop value : "+ dbConfig.getNameAutorefreshed());
		}
	}
}
