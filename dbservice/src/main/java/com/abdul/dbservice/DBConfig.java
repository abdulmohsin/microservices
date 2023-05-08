package com.abdul.dbservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class DBConfig {

	@Value("${nameAutorefreshed:Not assigned}")
	private String nameAutorefreshed;

	public String getNameAutorefreshed() {
		return nameAutorefreshed;
	}

	public void setNameAutorefreshed(String nameAutorefreshed) {
		this.nameAutorefreshed = nameAutorefreshed;
	}
	
}
