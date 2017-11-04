package com.brogrammers.sst.converters;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.brogrammers.sst.dto.SeatGeekDivision;
import com.brogrammers.sst.dto.SeatGeekEvent;
import com.brogrammers.sst.dto.SeatGeekPerformer;

@Component
public class SeatGeekConverters {
	
	Logger log = LoggerFactory.getLogger(getClass());

	public List<SeatGeekEvent> convertEventResponse(JSONObject response) {
		List<SeatGeekEvent> events = new ArrayList<>();
		try {
			JSONArray eventsArray = response.getJSONArray("events"); 
			for (int i = 0; i < eventsArray.length(); i++) {
				log.info("event {}", eventsArray.getJSONObject(i));
				SeatGeekEvent event = new SeatGeekEvent(eventsArray.getJSONObject(i));
				event.setPerformers(this.convertPerformersResponse(eventsArray.getJSONObject(i)));
				events.add(event);
			}
		} catch (Exception e) {
			log.error("Error converting event response", e);
		}
		return events;
	}

	private List<SeatGeekPerformer> convertPerformersResponse(JSONObject response) throws JSONException {
		List<SeatGeekPerformer> performers = new ArrayList<>();
		JSONArray performersArray = response.getJSONArray("performers");
		for (int i = 0; i < performersArray.length(); i++) {
			SeatGeekPerformer performer = new SeatGeekPerformer(performersArray.getJSONObject(i));
			if (this.hasDivision(performersArray.getJSONObject(i))) {
				performer.setDivisions(this.convertDivisionsResponse(performersArray.getJSONObject(i)));
			}
			performers.add(performer);
		}
		return performers;
	}

	private List<SeatGeekDivision> convertDivisionsResponse(JSONObject jsonObject) throws JSONException {
		List<SeatGeekDivision> divisions = new ArrayList<>();
		JSONArray divisionsArray = jsonObject.getJSONArray("divisions");
		for (int i = 0; i < divisionsArray.length(); i++) {
			divisions.add(new SeatGeekDivision(divisionsArray.getJSONObject(i)));
		}
		return divisions;
	}
	
	private boolean hasDivision(JSONObject jsonObject) {
		//NBA G League does not have divisions in response
		return jsonObject.has("divisions") && !jsonObject.isNull("divisions");
	}

}
