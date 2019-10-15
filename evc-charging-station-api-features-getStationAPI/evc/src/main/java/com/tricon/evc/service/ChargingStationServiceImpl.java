package com.tricon.evc.service;

import com.tricon.evc.constants.ChargingStationConstants;
import com.tricon.evc.constants.MapBoxConstants;
import com.tricon.evc.dao.IChargingStationDao;
import com.tricon.evc.dao.IEvseDao;
import com.tricon.evc.dao.IStatusScheduleDao;
import com.tricon.evc.model.ChargingStation;
import com.tricon.evc.model.StatusSchedule;
import com.tricon.evc.model.dto.Properties;
import com.tricon.evc.model.dto.*;
import com.tricon.evc.responsemodel.CustomResponse;
import com.tricon.evc.responsemodel.Stations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * The Class ChargingStationServiceImpl.
 */
@Service
public class ChargingStationServiceImpl implements IChargingStationService {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The charging station DAO object.
     */
    @Autowired
    private IChargingStationDao chargingStationDaoObject;

    /**
     * The EVSE DAO object.
     */
    @Autowired
    private IEvseDao evseDaoObject;

    /**
     * The status schedlule DAO object.
     */
    @Autowired
    private IStatusScheduleDao statusSchedluleDaoObject;

    /**
     * @return Returns CustomResponse object containing stations inside it.
     * * @param filterValues Contains the request body values as an object with values stored inside .
     */
    public CustomResponse getStations(FilterValues filterValues) {

        double distance = 0;

        List<Station> stationList = new ArrayList<Station>();

        /**
         * fetching all the charging stations
         */

        List<ChargingStation> chargingStationList =
                chargingStationDaoObject.findAll();

        /**
         * this loop is filtering for distance
         */

        for (int i = 0; i < chargingStationList.size(); i++) {
            distance = calculateDistance(
                    filterValues.getStartingLatitude(),
                    filterValues.getStartingLongitude(),
                    Double.parseDouble(
                            chargingStationList.get(i)
                                    .getGeoLocation()
                                    .getLatitude()),
                    Double.parseDouble(
                            chargingStationList
                                    .get(i)
                                    .getGeoLocation()
                                    .getLongitude()), ChargingStationConstants.KILOMETER);

            /**
             * if the charging staion is not present
             * in the given radius that is removed
             * from the list
             */

            if (distance > filterValues.getRadius()) {

                chargingStationList.remove(i);
                i--;
            }

        }
        /**
         * availability filter
         */

        Date date = stringToDate("2019-10-10 12:10:00");
        Date date2 = addMinutesToDate(70, date);

        List<StatusSchedule> idList = statusSchedluleDaoObject
                .findAllByperiodBeginBetween(date, date2);

        System.out.println(idList);

        /**
         * this loop is for filter of availability
         */
        for (int i = 0; i < chargingStationList.size(); i++) {
        }

        /**
         * filetering the charging station based on company
         */

//    companyIdList.add("9002");
//    //companyIdList.add("9001");
//    if (!filterValues.getCompanyIdList().isEmpty()) {
//      for (int i = 0; i < chargingStationList.size(); i++) {
//        int flag = 0;
//        for (int j = 0; j < chargingStationList.get(i)
//            .getEvseList().size(); j++) {
//
//          for (int k = 0; k < filterValues.getCompanyIdList().size(); k++) {
//            if (chargingStationList.get(i).getEvseList().get(j)
//                .getCompany()
//                .getCompanyId()
//                .equals(filterValues.getCompanyIdList().get(k))) {
//              flag = 1;
//            }
//
//          }
//        }
//        if (flag == 0) {
//          chargingStationList.remove(i);
//          i--;
//        }
//      }
//
//    }

        /**
         * setting charging stations to dto objects
         */
        for (
                int i = 0; i < chargingStationList.size(); i++) {

//            double[] coordinates = new double[2];
//            coordinates[0] = Double.parseDouble(chargingStationList.get(i)
//                    .getGeoLocation().getLongitude());
//            coordinates[1] = Double.parseDouble(chargingStationList.get(i)
//                    .getGeoLocation().getLatitude());
            List<Double> coordinates = new ArrayList<Double>(2);
            coordinates.add(Double.parseDouble(chargingStationList.get(i).getGeoLocation().getLongitude()));
            coordinates.add(Double.parseDouble(chargingStationList.get(i).getGeoLocation().getLongitude()));

            Geometry geometry = Geometry.builder()
                    .type(MapBoxConstants.MAP_BOX_POINT)
                    .coOrdinates(coordinates)
                    .build();
            com.tricon.evc.model.dto.Properties properties = Properties.builder()
                    .icon(MapBoxConstants.FUEL)
                    .build();

            Station station = Station.builder()
                    .type(MapBoxConstants.FEATURE)
                    .id(Integer.parseInt(chargingStationList.get(i)
                            .getId())).geometry(geometry).properties(properties)
                    .build();

            stationList.add(station);
        }

        Stations stations = Stations.builder()
                .type(MapBoxConstants.FEATURE_COLLECTION)
                .features(stationList)
                .build();

        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse customResponse = CustomResponse.builder()
                .metadata(metaData)
                .data(stations)
                .build();

        return customResponse;
    }

    /**
     * Gets the station details.
     *
     * @param id the id
     * @return the station details
     */
    public CustomResponse getStationDetails(final String id) {
        // TO-DO NO HARD CODING. EVERYTHING NEEDS TO COME FROM DB OR CONSTANTS FILE.
        Optional<ChargingStation> stationDetails =
                chargingStationDaoObject.findById(id);
        String address = stationDetails.get()
                .getAddress() + stationDetails.get().getCity()
                + stationDetails.get().getState()
                + stationDetails.get().getCountry()
                + stationDetails.get().getPostalCode();
        StationInfo stationInfo = StationInfo.builder()
                .name(stationDetails.get().getName()).address(address).build();
        String[] paymentDetails = stationDetails.get().getTarrifDetails().getPaymentDetails().split(",");
        List<String> paymentOptions = new ArrayList<String>(Arrays.asList(paymentDetails));

        ChargingStation x = new ChargingStation();
        Tariff memberTariff = Tariff.builder()
                .amount(stationDetails.get().getTarrifDetails().getMinimunCostForUsers()).unit(ChargingStationConstants.UNIT_PWD).build();
        Tariff nonMemberTariff = Tariff.builder()
                .amount(stationDetails.get().getTarrifDetails().getMinimunCostForNonUsers()).unit(ChargingStationConstants.UNIT_PWD).build();

        String[] featuresData = stationDetails.get()
                .getDispalyText().getText().split(",");

        ArrayList<String> featuresList =
                new ArrayList<>(Arrays.asList(featuresData));

        String image = ChargingStationConstants.IMAGE_URL;

        TariffDeails tariffDetails = TariffDeails.builder()
                .memberTariff(memberTariff)
                .nonMemberTariff(nonMemberTariff)
                .build();

        StationIdResponse response = StationIdResponse.builder()
                .stationInfo(stationInfo)
                .features(featuresList)
                .tariffDetails(tariffDetails)
                .image(image)
                .paymentOptions(paymentOptions)
                .build();

        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse customResponse = CustomResponse.builder()
                .metadata(metaData)
                .data(response)
                .build();

        return customResponse;

    }

    /**
     * Calc distance.
     *
     * @param startingLatitude  The Start Point Latitude.
     * @param startingLongitude The Start Point longitude.
     * @param endingLatitude    The End Point Latitude.
     * @param endingLongitude   The End Point Longitude.
     * @param unit              The unit .
     * @return the double
     */
    private static double calculateDistance(
            final double startingLatitude,
            final double startingLongitude,
            final double endingLatitude,
            final double endingLongitude,
            final String unit) {
        if ((startingLatitude == endingLatitude) && (startingLongitude == endingLongitude)) {
            return 0;
        } else {
            double theta = startingLongitude - endingLongitude;
            double dist = Math.sin(Math.toRadians(startingLatitude))
                    * Math.sin(Math.toRadians(endingLatitude))
                    + Math.cos(Math.toRadians(startingLatitude))
                    * Math.cos(Math.toRadians(endingLatitude)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit == ChargingStationConstants.KILOMETER) {
                dist = dist * 1.609344;
            } else if (unit == ChargingStationConstants.MILES) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

    /**
     * String to date.
     *
     * @param date
     * @return the date
     */
    public Date stringToDate(final String date) {

        Date result = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(ChargingStationConstants.DATE_FORMAT);
            result = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return result;
    }

    /**
     * Adds the minutes to date.
     *
     * @param minutes    the minutes
     * @param beforeTime the before time
     * @return the date
     */
    private static Date addMinutesToDate(
            final int minutes, final Date beforeTime) {
        final long oneMinuteInMilliSeconds = ChargingStationConstants.ONE_MINUTE_IN_MILLIS;

        final long curTimeInMs = beforeTime.getTime();
        Date afterAddingMins =
                new Date(curTimeInMs + (minutes * oneMinuteInMilliSeconds));
        return afterAddingMins;
    }


}
