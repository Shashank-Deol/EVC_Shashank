package com.evc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evc.dao.DaoDemo;
import com.evc.eventhandler.UpdatedRuntimeException;
import com.evc.model.ChargingStation;
import com.evc.model.GeoLocation;
import com.evc.model.dto.StationIdResponse;
import com.evc.model.dto.StationInfo;
import com.evc.model.dto.Tariff;
import com.evc.model.dto.TariffDeails;
import com.evc.responsemodel.CustomResponse;
import com.evc.responsemodel.Stations;

@Component
public class ChargingStationServiceImpl implements IChargingStationService {

	@Autowired
	DaoDemo daolayer;

	@Override
	public Stations getStations(double startingLatitude, double startingLongitude, double endingLatitude,
			double endingLongitude, int radius, int chargerType, int companyId, String timeStamp, int timeRequired) {
		double distance = 0;
		Stations returnList = new Stations();
		List<ChargingStation> list = daolayer.get(timeStamp);

//		IntStream.range(0, list.size()).forEach(index->{
//			System.out.println(index);
//		});
		try {

			for (int i = 0; i < list.size(); i++) {

				GeoLocation stationGeoLocation = daolayer.getGeoLocation(list.get(i).getGeoLocationId());

				// if station latitude,longitude is within the radius of user's
				// latitude,longitude then we would add the station in the returnList
				// distance = calcDistance(startingLatitude, startingLongitude,
				// Double.parseDouble(list.get(i).getLatitude()),
				// Double.parseDouble(list.get(i).getLongitude()), "K");
				distance = calcDistance(startingLatitude, startingLongitude,
						Double.parseDouble(stationGeoLocation.getLatitude()),
						Double.parseDouble(stationGeoLocation.getLongitude()), "K");
				if (distance > radius) {
					list.remove(i);
				}

			}
		} catch (Exception e) {
			throw new UpdatedRuntimeException("Exception occured in getStations method : " + e.getLocalizedMessage(),
					e);
		}
//		

		for (int i = 0; i < list.size(); i++) {

			try {
				GeoLocation stationGeoLocation = daolayer.getGeoLocation(list.get(i).getGeoLocationId());

				returnList.add(list.get(i).getId(), Double.parseDouble(stationGeoLocation.getLongitude()),
						Double.parseDouble(stationGeoLocation.getLatitude()));
				// returnList.add(list.get(i).getId(),
				// Double.parseDouble(list.get(i).getLongitude()),Double.parseDouble(list.get(i).getLatitude()));
			} catch (Exception e) {
				throw new UpdatedRuntimeException("Exception occured in getStations method : " + e.getLocalizedMessage(),
						e);
			}
		}

		try {
			CustomResponse response = new CustomResponse();
			response.setData(returnList);

			return returnList;
		} catch (Exception e) {
			throw new UpdatedRuntimeException("Exception occured in getStations method : " + e.getLocalizedMessage(),
					e);
		}
	}

	private static double calcDistance(double lat1, double lon1, double lat2, double lon2, String unit) {

		try {
			if ((lat1 == lat2) && (lon1 == lon2)) {
				return 0;
			} else {
				double theta = lon1 - lon2;
				double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
						+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
								* Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.1515;
				if (unit == "K") {
					dist = dist * 1.609344;
				} else if (unit == "N") {
					dist = dist * 0.8684;
				}
				return (dist);
			}
		} catch (Exception e) {
			throw new UpdatedRuntimeException("Exception occured in calcDistance method : " + e.getLocalizedMessage(),
					e);
		}
	}

	@Override
	public CustomResponse getStationById(int id) {
		// TODO Auto-generated method stub

		return null;
	}

	@SuppressWarnings("unchecked")
	public StationIdResponse getStationDetails(String id) {

		try {
			StationIdResponse response = new StationIdResponse();

			// TO-DO NO HARD CODING. EVERYTHING NEEDS TO COME FROM DB OR CONSTANTS FILE.
			ChargingStation stationDetails = daolayer.getStationDetails(id);
			StationInfo stationInfo = new StationInfo();
			stationInfo.setName(stationDetails.getName());
			stationInfo.setAddress(stationDetails.getAddress());

			TariffDeails tariffDetails = new TariffDeails();
			Tariff memberTariff = new Tariff();
			memberTariff.setAmount(5.0);
			memberTariff.setUnit("pkw");
			tariffDetails.setMembers(memberTariff);

			Tariff nonMemberTariff = new Tariff();
			nonMemberTariff.setAmount(8.0);
			nonMemberTariff.setUnit("pkw");
			tariffDetails.setNonMembers(nonMemberTariff);

			response.setDistance(4.0);
			response.setImage("dummy-image-to-be-updated");
			List<String> features = new ArrayList<String>();
			features.add("Multi Plug Connectors Available");
			features.add("Level 3 Charging");
			features.add("Fast Charging");
			response.setFeatures(features);
			response.setStationInfo(stationInfo);
			response.setTariffDetails(tariffDetails);

			List<String> paymentOptions = new ArrayList<String>();
			paymentOptions.add("credit-card");
			paymentOptions.add("debit-card");

			response.setPaymentOptions(paymentOptions);

			System.out.println("hello");
			return response;
			// TODO Auto-generated method stub
		} catch (Exception e) {
			throw new UpdatedRuntimeException("Exception occured in getStationDetails method : " + e.getLocalizedMessage(),
					e);
		}

	}

}
