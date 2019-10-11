package com.tricon.evc.model;


import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Table(name = "geolocation")

public class GeoLocation {

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

@Id
  @Column(name = "id")
String geoLocationId;


  @Column(name = "latitude")
String latitude;

  @Column(name = "longitude")
String longitude;



}
