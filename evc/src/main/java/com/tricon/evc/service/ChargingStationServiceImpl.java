package com.tricon.evc.service;

import com.tricon.evc.constants.ChargingStationConstants;
import com.tricon.evc.dao.IChargingStationDao;
import com.tricon.evc.exceptionhandler.UpdatedRuntimeException;
import com.tricon.evc.model.ChargingStation;
import com.tricon.evc.model.dto.Properties;
import com.tricon.evc.model.dto.*;
import com.tricon.evc.responsemodel.CustomResponse;
import com.tricon.evc.responsemodel.Stations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChargingStationServiceImpl implements IChargingStationService {

    @Autowired
    IChargingStationDao chargingStationDaoObject;

    public CustomResponse getStations(double startingLatitude, double startingLongitude, double endingLatitude,
									  double endingLongitude, int radius, int chargerType, int companyId, String timeStamp, int timeRequired) {
        try {
            double distance = 0;

            List<Station> stationlist = new ArrayList<Station>();
            /**
             * fetching all the charging stations
             */
            List<ChargingStation> chargingStationList = chargingStationDaoObject.findAll();
            System.out.println(chargingStationList.get(0).getGeoLocation().getGeoLocationId());

            for (int i = 0; i < chargingStationList.size(); i++) {
                distance = calcDistance(startingLatitude, startingLongitude,
                        Double.parseDouble(chargingStationList.get(i).getGeoLocation().getLatitude()),
                        Double.parseDouble(chargingStationList.get(i).getGeoLocation().getLongitude()), "K");
                /**
                 *
                 * if the charging staion is not present in the given radius that is removed
                 * from the list
                 */
                if (distance > radius) {

                    chargingStationList.remove(i);
                }

            }

            for (int i = 0; i < chargingStationList.size(); i++) {

                //
//				double[] coordinates = new double[2];
//				coordinates[0] = Double.parseDouble(chargingStationList.get(i).getGeoLocation().getLongitude());
//				coordinates[1] = Double.parseDouble(chargingStationList.get(i).getGeoLocation().getLatitude());


                List<Double> coordinates = new ArrayList<Double>(2);
                coordinates.add(Double.parseDouble(chargingStationList.get(i).getGeoLocation().getLongitude()));
                coordinates.add(Double.parseDouble(chargingStationList.get(i).getGeoLocation().getLongitude()));


                Geometry geometry = Geometry.builder().type(ChargingStationConstants.POINT).coordinates(coordinates)
                        .build();
                Properties properties = Properties.builder().icon(ChargingStationConstants.FUEL).build();

                Station station = Station.builder().type(ChargingStationConstants.FEATURE)
                        .id(Integer.parseInt(chargingStationList.get(i).getId())).geometry(geometry)
                        .properties(properties).build();
                stationlist.add(station);
            }

            Stations stations = Stations.builder()
					.type(ChargingStationConstants.FEATURE_COLLECTION)
                    .features(stationlist)
					.build();

            Map<String, Object> metaData = new HashMap<String, Object>();
            CustomResponse customResponse = CustomResponse.builder()
					.metadata(metaData)
					.data(stations)
					.build();

            return customResponse;
        } catch (Exception e) {
            throw new UpdatedRuntimeException("Exception occured in getStations method : " + e.getLocalizedMessage(),
                    e);
        }
    }

    public CustomResponse getStationDetails(String id) {

        if (id == ""){
            throw new RuntimeException("Id value is empty");
        }
        try {
            // TO-DO NO HARD CODING. EVERYTHING NEEDS TO COME FROM DB OR CONSTANTS FILE.
            Optional<ChargingStation> stationDetails = chargingStationDaoObject.findById(id);
            String address = stationDetails.get().getAddress() + stationDetails.get().getCity()
                    + stationDetails.get().getState() + stationDetails.get().getCountry()
                    + stationDetails.get().getPostalCode();
            StationInfo stationInfo = StationInfo.builder().name(stationDetails.get().getName()).address(address).build();

            Tariff memberTariff = Tariff.builder().amount(5.0).unit(ChargingStationConstants.UNIT).build();
            Tariff nonMemberTariff = Tariff.builder().amount(8.0).unit(ChargingStationConstants.UNIT).build();

            List<String> features = new ArrayList<String>();
            features.add(ChargingStationConstants.CONNECTOR_TYPES);
            features.add(ChargingStationConstants.CHARGING_TYPE);

            List<String> paymentOptions = new ArrayList<String>();
            paymentOptions.add(ChargingStationConstants.CREDIT_CARD);
            paymentOptions.add(ChargingStationConstants.DEBIT_CARD);

            String image = "dummy-image-to-be-updated";

            TariffDeails tariffDetails = TariffDeails.builder().memberTariff(memberTariff).nonMemberTariff(nonMemberTariff)
                    .build();

            StationIdResponse response = StationIdResponse.builder().stationInfo(stationInfo).features(features)
                    .tariffDetails(tariffDetails).distance(4.0).image(image).paymentOptions(paymentOptions).build();

            Map<String, Object> metaData = new HashMap<String, Object>();
            CustomResponse customResponse = CustomResponse.builder().metadata(metaData).data(response).build();

            return customResponse;
        } catch (Exception e) {
            throw new UpdatedRuntimeException("Exception occured in getStationDetails method : " + e.getLocalizedMessage(),
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
                        + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
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

}
