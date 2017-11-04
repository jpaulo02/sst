package com.brogrammers.sst.dto;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

public class SeatGeekPerformer {

	@Id
	@Field
	private Integer id;
	@Field
	private boolean home_team;
	@Field
	private Integer home_venue_id;
	@Field
	private String name;
	@Field
	private String short_name;
	@Field
	private double popularity;
	@Field
	private List<SeatGeekDivision> divisions;
	
	public SeatGeekPerformer(JSONObject response) throws JSONException {
		this.id = response.getInt("id");
		this.home_team = ((response.has("home_team") && !response.isNull("home_team"))) ? response.getBoolean("home_team") : false;
		this.home_venue_id = ((response.has("home_venue_id") && !response.isNull("home_venue_id"))) ? response.getInt("home_venue_id") : null;
		this.name = response.getString("name");
		this.short_name = response.getString("short_name");
		this.popularity = response.getDouble("popularity");
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isHome_team() {
		return home_team;
	}
	public void setHome_team(boolean home_team) {
		this.home_team = home_team;
	}
	public Integer getHome_venue_id() {
		return home_venue_id;
	}
	public void setHome_venue_id(Integer home_venue_id) {
		this.home_venue_id = home_venue_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	
	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public List<SeatGeekDivision> getDivisions() {
		return divisions;
	}
	public void setDivisions(List<SeatGeekDivision> divisions) {
		this.divisions = divisions;
	}
}
