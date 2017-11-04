package com.brogrammers.sst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brogrammers.sst.services.SstService;

@RestController
public class SstController {
	
	@Autowired
	SstService sstService;

	@RequestMapping("/force")
	public void forceRun() {
		sstService.retrieveDailySchedule();
	}
	
}
