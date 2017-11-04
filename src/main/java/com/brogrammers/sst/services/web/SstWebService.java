package com.brogrammers.sst.services.web;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SstWebService {

	@Autowired
	RetryableRestTemplate retryableRestTemplate;
	
	public String getForObject(String url, Object responseType) {
		return retryableRestTemplate.getForObject(url, String.class);
	}
}
