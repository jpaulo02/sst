package com.brogrammers.sst.services;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.brogrammers.sst.converters.SeatGeekConverters;
import com.brogrammers.sst.dto.SeatGeekEvent;
import com.brogrammers.sst.services.repo.SstRepoService;
import com.brogrammers.sst.services.web.SstWebService;
import com.brogrammers.sst.util.SstUtil;

@Service
public class SstService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private static final String PAGE_SIZE_50 = "&per_page=50";
	
	@Value("${seat.geek.base.url}")
	String seatGeekBaseUrl;
	
	@Value("${seat.geek.events}")
	String seatGeekEventsUrl;
	
	@Value("${seat.geek.client.id}")
	String seatGeekClientId;
	
	@Autowired
	SstWebService webService;
	
	@Autowired
	SstUtil sstUtil;
	
	@Autowired
	SstRepoService repoService;
	
	@Autowired
	SeatGeekConverters seatGeekConverters;

	public void retrieveDailySchedule() {
		String url = sstUtil.urlBuilder(seatGeekBaseUrl, seatGeekEventsUrl+"nba", "&"+seatGeekClientId+PAGE_SIZE_50);
		String stringResponse = webService.getForObject(url, String.class);
		JSONObject response = new JSONObject(stringResponse);
		List<SeatGeekEvent> events = seatGeekConverters.convertEventResponse(response);
		repoService.saveSeatGeekEvents(events);
	}

	
}
