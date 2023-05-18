package com.abdul.ecommerce;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("paytm")
public interface PaytmClient {

	@RequestMapping("/paytm/hello")
    String getPaytmHelloOutput();
	
	@RequestMapping("/paytm/goodBye")
    String getPaytmGoodByeOutput();
}
