package com.brogrammers.sst.services.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brogrammers.sst.dto.SeatGeekEvent;
import com.brogrammers.sst.repos.SeatGeekEventsRepo;

@Service
public class SstRepoService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SeatGeekEventsRepo seatGeekEventsRepo;

	public void saveSeatGeekEvents(List<SeatGeekEvent> events) {
		try {
			seatGeekEventsRepo.save(events);
		} catch (Exception e) {
			log.error("Error saving seat geek events", e);
		}
	}
	
	
}
