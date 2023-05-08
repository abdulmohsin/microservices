package com.abdul.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RefreshedConsumer {

	@Autowired
	private DBConfig dbConfig;

	@Scheduled(fixedDelay = 2000)
	public void printLatestProp() {
		System.out.println("********** Prop value : "+ dbConfig.getNameAutorefreshed());
	}
}
