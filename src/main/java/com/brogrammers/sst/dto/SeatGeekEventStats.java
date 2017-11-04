package com.brogrammers.sst.dto;

import org.json.JSONException;
import org.json.JSONObject;

import com.couchbase.client.java.repository.annotation.Field;

public class SeatGeekEventStats {
	
	@Field
	private Integer highest_price;
	@Field
	private Integer average_price;
	@Field
	private Integer listing_count;
	@Field
	private Integer lowest_price;
	
	public SeatGeekEventStats(JSONObject response) throws JSONException {
		this.highest_price = ((response.has("highest_price") && !response.isNull("highest_price"))) ? response.getInt("highest_price") : 0;
		this.average_price = ((response.has("average_price") && !response.isNull("average_price"))) ? response.getInt("average_price") : 0;
		this.listing_count = ((response.has("listing_count") && !response.isNull("listing_count"))) ? response.getInt("listing_count") : 0;
		this.lowest_price = ((response.has("lowest_price") && !response.isNull("lowest_price"))) ? response.getInt("lowest_price") : 0;
	}

	public Integer getHighest_price() {
		return highest_price;
	}
	public void setHighest_price(Integer highest_price) {
		this.highest_price = highest_price;
	}
	public Integer getAverage_price() {
		return average_price;
	}
	public void setAverage_price(Integer average_price) {
		this.average_price = average_price;
	}
	public Integer getListing_count() {
		return listing_count;
	}
	public void setListing_count(Integer listing_count) {
		this.listing_count = listing_count;
	}
	public Integer getLowest_price() {
		return lowest_price;
	}
	public void setLowest_price(Integer lowest_price) {
		this.lowest_price = lowest_price;
	}

}
