package com.evc.model.dto;

public class CoOrdinates {

Double latitude ;
Double logitude ;

public CoOrdinates(Double latitude,Double logitude)
{
	this.latitude = latitude;
	this.logitude = logitude;
}

public Double getLatitude() {
	return latitude;
}
public void setLatitude(Double latitude) {
	this.latitude = latitude;
}
public Double getLogitude() {
	return logitude;
}
public void setLogitude(Double logitude) {
	this.logitude = logitude;
}

}
