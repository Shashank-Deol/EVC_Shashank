package com.evc.model.dto;

import java.io.Serializable;

/**
 * Tariff Amount.
 * @author yeshwanth.l
 *
 */
public class Tariff implements Serializable{

	/**
	 * Default Version.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Unit Details.
	 */
	private String unit;
	
	/**
	 * Amount Per Units.
	 */
	private double amount;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
