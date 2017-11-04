package com.brogrammers.sst.dto;

import java.util.List;

import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.couchbase.core.mapping.Document;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class SeatGeekEvent {
	
	@Id
	@Field
	private Integer id;
	@Field
	private String title;
	@Field
	private String short_title;
	//private enum SeatGeekEventType {NBA};
	@Field
	private String type;
	@Field
	private SeatGeekEventStats eventStats;
	@Field
	private DateTime datetime_local;
	@Field
	private String url;
	@Field
	private List<SeatGeekPerformer> performers;
	
	public SeatGeekEvent(JSONObject response) throws JSONException {
		this.id = response.getInt("id");
		this.title = response.getString("title");
		this.short_title = response.getString("short_title");
		this. type = response.getString("type");
		this.eventStats = new SeatGeekEventStats(response.getJSONObject("stats"));
		this.datetime_local = DateTime.parse(response.getString("datetime_local"));
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShort_title() {
		return short_title;
	}
	public void setShort_title(String short_title) {
		this.short_title = short_title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public SeatGeekEventStats getEventStats() {
		return eventStats;
	}
	public void setEventStats(SeatGeekEventStats eventStats) {
		this.eventStats = eventStats;
	}
	public DateTime getDatetime_local() {
		return datetime_local;
	}
	public void setDatetime_local(DateTime datetime_local) {
		this.datetime_local = datetime_local;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<SeatGeekPerformer> getPerformers() {
		return performers;
	}
	public void setPerformers(List<SeatGeekPerformer> performers) {
		this.performers = performers;
	}
	
}
