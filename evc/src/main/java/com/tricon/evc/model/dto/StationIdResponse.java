package com.tricon.evc.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * Response Model For Charging Station Details with respect to the ID.
 * @author yeshwanth.l
 *
 */
@Data
@Builder
public class StationIdResponse implements Serializable{

	/**
	 * serial version default ID.
	 * TO-DO Change Later.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Charging Station Information.
	 */
	private StationInfo stationInfo;
	
	/**
	 * Distace of charging station with respect to the origin.
	 */
	private double distance;
	
	/**
	 * Charging station image URL.
	 */
	private String image;
	
	/**
	 * Available charging station features.
	 */
	private List<String> features;
	
	/**
	 * Tariff details with respect to the charging station.
	 */
	private TariffDeails tariffDetails;
	
	/**
	 * Payment options available.
	 */
	private List<String> paymentOptions;
	
	

}


	 