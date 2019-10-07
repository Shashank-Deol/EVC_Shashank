package com.evc.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Response Model For Charging Station Details with respect to the ID.
 * 
 * @author yeshwanth.l
 *
 */
public class StationIdResponse implements Serializable {

	public StationIdResponse(StationInfo stationInfo, double distance, String image, List<String> features,
			TariffDeails tariffDetails, List<String> paymentOptions) {
		super();
		this.stationInfo = stationInfo;
		this.distance = distance;
		this.image = image;
		this.features = features;
		this.tariffDetails = tariffDetails;
		this.paymentOptions = paymentOptions;
	}
	
	public StationIdResponse() {
		super();
	}

	/**
	 * serial version default ID. TO-DO Change Later.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Charging Station Information.
	 */
	private StationInfo stationInfo;

	/**
	 * Distance of charging station with respect to the origin.
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

	public StationInfo getStationInfo() {
		return stationInfo;
	}

	public void setStationInfo(StationInfo stationInfo) {
		this.stationInfo = stationInfo;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public TariffDeails getTariffDetails() {
		return tariffDetails;
	}

	public void setTariffDetails(TariffDeails tariffDetails) {
		this.tariffDetails = tariffDetails;
	}

	public List<String> getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(List<String> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}

}
