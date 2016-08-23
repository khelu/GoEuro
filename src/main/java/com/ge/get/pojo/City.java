package com.ge.get.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author cristi.chelaru
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
	private Integer _id;
	private String name;
	private String type;
	private GeoPosition geo_position;
	
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public GeoPosition getGeo_position() {
		return geo_position;
	}
	public void setGeo_position(GeoPosition geo_position) {
		this.geo_position = geo_position;
	}
	
	
	
}
