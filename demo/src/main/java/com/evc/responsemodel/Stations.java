package com.evc.responsemodel;

import java.util.ArrayList;
import java.util.List;

import com.evc.model.dto.Station;

public class Stations {

	String type = "FeatureCollection";
	List<Station> features = new ArrayList<Station>();

	public Stations(List<Station> listmock) {
		this.features = listmock;
	}

	public Stations() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Station> getFeatures() {
		return features;
	}

	public void setFeatures(List<Station> features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "Stations [type=" + type + ", features=" + features + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stations other = (Stations) obj;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public void add(String id, double latitude, double longitude) {
		// TODO Auto-generated method stub

		features.add(new Station(Integer.parseInt(id), latitude, longitude));

	}

}
