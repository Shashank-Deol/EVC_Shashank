package com.evc.model.dto;

import java.io.Serializable;
/**
 * Station INfo to be displayed in the Charging Details Page.
 * @author yeshwanth.l
 *
 */

public class StationInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Charging Station Name.
	 */
	private String name;
	
	/**
	 * Charging Station Details.
	 */
	private String address;

	/**
	 * Get name.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get address.
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set Address.
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
