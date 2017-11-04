package com.brogrammers.sst.services.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class RetryableRestTemplate {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private final RestTemplate restTemplate;
	
	public RetryableRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5, random = false), value = {
			HttpServerErrorException.class, ResourceAccessException.class, HttpClientErrorException.class })
	public <T> T getForObject(String url, Class<T> responseType) {
		try {
			return restTemplate.getForObject(url, responseType);
		} catch (ResourceAccessException rae) {
			log.error("Error getting object", url, rae);
			throw rae;
		} catch (HttpServerErrorException hsee) {
			log.error("Error getting object", url, hsee);
			throw hsee;
		}
	}
}
