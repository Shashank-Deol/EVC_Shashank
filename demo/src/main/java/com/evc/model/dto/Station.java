package com.evc.model.dto;

public class Station {
	
	final String type="Feature";
	int id;
	Properties properties;
	Geometry geometry;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getType() {
		return type;
	}


	
	
	public Station( int id,double latitude,double logitude)
	{
		this.id =id;
		this.properties = new Properties();
		this.geometry = new Geometry(latitude, logitude);
	}

	@Override
	public String toString() {
		return "Station [type=" + type + ", id=" + id + ", properties=" + properties + ", geometry=" + geometry
				+ ", getId()=" + getId() + ", getProperties()=" + getProperties() + ", getGeometry()=" + getGeometry()
				+ ", getType()=" + getType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

	
	
	
	
	
	
}
