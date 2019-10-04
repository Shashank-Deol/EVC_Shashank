package com.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="geo_location")

public class GeoLocation{

	@Id
	@Column(name ="id")
	String geoLocationId;
	

	@Column(name="latitude")
	String latitude;

	@Column(name="longitude")
	String longitude;

	public String getGeoLocationId() {
		return geoLocationId;
	}

	public void setGeoLocationId(String geoLocationId) {
		this.geoLocationId = geoLocationId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "GeoLocation [geoLocationId=" + geoLocationId + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", getGeoLocationId()=" + getGeoLocationId() + ", getLatitude()=" + getLatitude()
				+ ", getLongitude()=" + getLongitude() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
