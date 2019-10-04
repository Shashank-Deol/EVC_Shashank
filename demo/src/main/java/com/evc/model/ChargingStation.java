
package com.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "location")
public class ChargingStation {

	@Id
    @Column(name = "id")
    private String id;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
	@Column(name= "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "country")
    private String country;
    @Column(name="geo_location_id")
    private String geoLocationId;

    
    @Override
	public String toString() {
		return "ChargingStation [id=" + id + ", type=" + type + ", name=" + name + ", address=" + address + ", city="
				+ city + ", postalCode=" + postalCode + ", country=" + country + ", geoLocationId=" + geoLocationId
				+ ", getId()=" + getId() + ", getType()=" + getType() + ", getName()=" + getName() + ", getAddress()="
				+ getAddress() + ", getCity()=" + getCity() + ", getPostalCode()=" + getPostalCode() + ", getCountry()="
				+ getCountry() + ", getGeoLocationId()=" + getGeoLocationId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGeoLocationId() {
		return geoLocationId;
	}
	public void setGeoLocationId(String geoLocationId) {
		this.geoLocationId = geoLocationId;
	}

}
