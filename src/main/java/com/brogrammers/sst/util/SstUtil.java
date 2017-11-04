package com.brogrammers.sst.util;

import org.springframework.stereotype.Component;

@Component
public class SstUtil {

	public String urlBuilder(String... args) {
		StringBuffer sb = new StringBuffer();
		for (String arg : args) {
			sb.append(arg);
		}
		return sb.toString();
	}
}
