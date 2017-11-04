package com.brogrammers.sst.dto;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.couchbase.core.mapping.Document;
import com.couchbase.client.java.repository.annotation.Field;

@Document
public class SeatGeekDivision {
	
	@Field
	private Integer taxonomy_id;
	@Field
	private String short_name;
	@Field
	private Integer division_level;
	@Field
	private String display_type;
	@Field
	private String display_name;
	
	public SeatGeekDivision(JSONObject response) throws JSONException {
		this.taxonomy_id = response.getInt("taxonomy_id");
		this.short_name = ((response.has("short_name") && !response.isNull("short_name"))) ? response.getString("short_name") : null;
		this.division_level = response.getInt("division_level");
		this.display_type = response.getString("display_type");
		this.display_name = response.getString("display_name");
	}
	
	public Integer getTaxonomy_id() {
		return taxonomy_id;
	}
	public void setTaxonomy_id(Integer taxonomy_id) {
		this.taxonomy_id = taxonomy_id;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public Integer getDivision_level() {
		return division_level;
	}
	public void setDivision_level(Integer division_level) {
		this.division_level = division_level;
	}
	public String getDisplay_type() {
		return display_type;
	}
	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

}
