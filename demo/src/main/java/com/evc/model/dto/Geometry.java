package com.evc.model.dto;

public class Geometry {

	String type = "Point";
	double[] coordinates = new double[2];
	
	public Geometry(double latitude, double longitude)
	{
		this.coordinates[0] = latitude;
		this.coordinates[1] = longitude;
	}
	
	

	public double[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(double latitute, double longitude) {
		this.coordinates[0] = latitute;
		this.coordinates[1] = longitude;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
