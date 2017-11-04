package com.brogrammers.sst.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.brogrammers.sst.services.SstService;

@Component
public class DataCollectorTask {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private static final Integer KINGS_PERFORMER_ID = 2862;
	
	@Autowired
	SstService sstService;
	
	@Scheduled(cron = "${stub.hub.run.frequency}")
	public void collectStubHubData() {
		log.info("starting ingester");
		sstService.retrieveDailySchedule();
	}

}
