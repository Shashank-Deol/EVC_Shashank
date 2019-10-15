package com.tricon.evc.controllertest;

import java.util.*;

import com.tricon.evc.constants.ChargingStationConstants;
import com.tricon.evc.exceptionhandler.UpdatedRuntimeException;
import com.tricon.evc.model.dto.*;
import com.tricon.evc.model.dto.Properties;
import com.tricon.evc.responsemodel.CustomResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tricon.evc.controller.ChargingStationController;
import com.tricon.evc.responsemodel.Stations;
import com.tricon.evc.service.ChargingStationServiceImpl;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class ChargingStationControllerTest {


    @InjectMocks
    private ChargingStationController chargingStationController;

    @Mock
    private ChargingStationServiceImpl chargingstationserviceimpl;

    private static final int ID = 1002;
    private static final double LATITUDE = 12.928141;
    private static final double LONGITUDE = 77.618713;

    private static final String TARIFFUNITTEST_1_TARIFF = "pkw";
    private static final double TARIFFAMOUNTTEST_1_TARIFF = 5.0;
    private static final String TARIFFUNITTEST_2_TARIFF = "pkw";
    private static final double TARIFFAMOUNTTEST_2_TARIFF = 8.0;
    private static final String NAMETEST_STATION_INFO = "test";
    private static final String ADDRESSTEST_STATION_INFO = "test_address";
    private static final String IMAGESOURCE_STATION_ID_RESPONSE = "/test_image.png";
    private static final String FEATURES_FEATURE_1_STATION_ID_RESPONSE = "Multi Plug Connectors Available";
    private static final String FEATURES_FEATURE_2_STATION_ID_RESPONSE = "Level 3 Charging";
    private static final String FEATURES_FEATURE_3_STATION_ID_RESPONSE = "Fast Charging";
    private static final String PAYMENTOPTIONS_OPTION_1_STATION_ID_RESPONSE = "credit-card";
    private static final String PAYMENTOPTIONS_OPTION_2_STATION_ID_RESPONSE = "debit-card";

    private static final double EXCEPTIONCAUSINGLATITUDE = -100.0;
    private static final double EXCEPTIONCAUSINGLONGITUDE = -181;

    private static final int EXCEPTIONCAUSINGID = 0001;

    private static final int MOCK_VALUE_CORRECT_RADIUS = 5;
    private static final int MOCK_VALUE_CORRECT_CHARGERTYPE = 5;
    private static final int MOCK_VALUE_CORRECT_TIMEREQUEST = 5;

    private static final int MOCK_VALUE_INCORRECT_RADIUS = 0;
    private static final int MOCK_VALUE_INCORRECT_CHARGERTYPE = -2;
    private static final int MOCK_VALUE_INCORRECT_TIMEREQUEST = -5;


    /**
     * This Test case should return all the charging stations. To check the coverage of getStations() method.
     */
    @Test
    public void shouldReturnAllStations() {

        //TODO Write Java Docs, Meaningful names, Constants in CAPS and meaningful test values.

        ArrayList<Double> co_ordinates = new ArrayList<Double>(Arrays.asList(LATITUDE, LONGITUDE));
        Geometry geometry = Geometry.builder()
                .coOrdinates(co_ordinates)
                .type(ChargingStationConstants.CHARGING_TYPE)
                .build();

        Station station1 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        Station station2 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        List<Station> listmock = Arrays.asList(station1, station2);

        Stations mockreceiveallstations = Stations.builder()
                .type("")
                .features(listmock)
                .build();


        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse mockreceiveallstationscustom = CustomResponse.builder()
                .metadata(metaData)
                .data(mockreceiveallstations)
                .build();

        List<String> companyidList = new ArrayList<String>();
        companyidList.add("9002");
        companyidList.add("9001");

        FilterValues filterValues = FilterValues.builder()
                .startingLatitude(12.928141)
                .startingLongitude(77.618713)
                .endingLatitude(12.928141)
                .endingLongitude(77.618713)
                .radius(5)
                .companyIdList(companyidList)
                .chargerType(99)
                .timeRequired(99)
                .timeStamp("99")
                .build();

        Mockito.when(chargingstationserviceimpl.getStations(filterValues)).thenReturn(mockreceiveallstationscustom);

        final CustomResponse result = chargingStationController.getStations(filterValues);

        assertEquals(mockreceiveallstationscustom, result);
    }

    /**
     * This Test Case is to check the coverage of getStationDetails() method inside controller.
     */
    @Test
    public void shouldReturnDetailsOfStations() {
        Tariff tariff1 = Tariff.builder()
                .unit(TARIFFUNITTEST_1_TARIFF)
                .amount(TARIFFAMOUNTTEST_1_TARIFF)
                .build();

        Tariff tariff2 = Tariff.builder()
                .unit(TARIFFUNITTEST_2_TARIFF)
                .amount(TARIFFAMOUNTTEST_2_TARIFF)
                .build();

        TariffDeails tariffDeails = TariffDeails.builder()
                .memberTariff(tariff1)
                .nonMemberTariff(tariff2)
                .build();

        StationInfo stationInfo = StationInfo.builder()
                .name(NAMETEST_STATION_INFO)
                .address(ADDRESSTEST_STATION_INFO)
                .build();

        List<String> features = new ArrayList<String>();
        features.add(FEATURES_FEATURE_1_STATION_ID_RESPONSE);
        features.add(FEATURES_FEATURE_2_STATION_ID_RESPONSE);
        features.add(FEATURES_FEATURE_3_STATION_ID_RESPONSE);

        List<String> paymentOptions = new ArrayList<String>();
        paymentOptions.add(PAYMENTOPTIONS_OPTION_1_STATION_ID_RESPONSE);
        paymentOptions.add(PAYMENTOPTIONS_OPTION_2_STATION_ID_RESPONSE);

        StationIdResponse stationIdResponse = StationIdResponse.builder()
                .features(features)
                .image(IMAGESOURCE_STATION_ID_RESPONSE)
                .paymentOptions(paymentOptions)
                .stationInfo(stationInfo)
                .tariffDetails(tariffDeails)
                .build();

        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse customResponseStationId = CustomResponse.builder().metadata(metaData).data(stationIdResponse).build();

        Mockito.when(chargingstationserviceimpl.getStationDetails(Mockito.anyString())).thenReturn(customResponseStationId);

        /**
         * The below comment is just for Spike(Self-Learning)
         */
//        ChargingStationController dummyClass = Mockito.mock(ChargingStationController.class);
//        Mockito.doReturn(customResponse1).when(dummyClass).getStationDetails(Mockito.anyString());

        final CustomResponse result = chargingStationController.getStationDetails("" + 1002);

        final StationIdResponse expectedStationIdResponse = StationIdResponse.builder()
                .features(features)
                .image(IMAGESOURCE_STATION_ID_RESPONSE)
                .paymentOptions(paymentOptions)
                .stationInfo(stationInfo)
                .tariffDetails(tariffDeails)
                .build();

        Map<String, Object> metaData2 = new HashMap<String, Object>();
        CustomResponse customResponse = CustomResponse.builder().metadata(metaData).data(expectedStationIdResponse).build();

        assertEquals(customResponse, result);

    }

    /**
     * The Latitude and Longitude values should lie between -90 to +90 degrees and -180 to +180 degrees respectively.
     */
    @Test(expected = UpdatedRuntimeException.class)
    public void shouldReturnExceptionBecauseOfWrongInputValuesOfLatitudesAndLongitudes() {
        ArrayList<Double> co_ordinates = new ArrayList<Double>(Arrays.asList(EXCEPTIONCAUSINGLATITUDE, EXCEPTIONCAUSINGLONGITUDE));

        Geometry geometry = Geometry.builder()
                .coOrdinates(co_ordinates)
                .type(ChargingStationConstants.CHARGING_TYPE)
                .build();

        Station station1 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        Station station2 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        List<Station> listmock = Arrays.asList(station1, station2);

        Stations mockreceiveallstations = Stations.builder()
                .type("")
                .features(listmock)
                .build();


        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse mockreceiveallstationscustom = CustomResponse.builder()
                .metadata(metaData)
                .data(mockreceiveallstations)
                .build();

        List<String> companyidList = new ArrayList<String>();
        companyidList.add("9002");
        companyidList.add("9001");

        FilterValues filterValues = FilterValues.builder()
                .startingLatitude(12.928141)
                .startingLongitude(77.618713)
                .endingLatitude(12.928141)
                .endingLongitude(77.618713)
                .radius(5)
                .companyIdList(companyidList)
                .chargerType(99)
                .timeRequired(99)
                .timeStamp("99")
                .build();

        Mockito.when(chargingstationserviceimpl.getStations(filterValues)).thenThrow(new UpdatedRuntimeException("Test case for failing latitude and longitude"));

        final CustomResponse result = chargingStationController.getStations(filterValues);
    }

    /**
     * The Value of a station corresponding to a station id should be present , else throw NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void shouldReturnAnExceptionForGetStationDetailsMethod() {
        Tariff tariff1 = Tariff.builder()
                .unit(TARIFFUNITTEST_1_TARIFF)
                .amount(TARIFFAMOUNTTEST_1_TARIFF)
                .build();

        Tariff tariff2 = Tariff.builder()
                .unit(TARIFFUNITTEST_2_TARIFF)
                .amount(TARIFFAMOUNTTEST_2_TARIFF)
                .build();

        TariffDeails tariffDeails = TariffDeails.builder()
                .memberTariff(tariff1)
                .nonMemberTariff(tariff2)
                .build();

        StationInfo stationInfo = StationInfo.builder()
                .name(NAMETEST_STATION_INFO)
                .address(ADDRESSTEST_STATION_INFO)
                .build();

        List<String> features = new ArrayList<String>();
        features.add(FEATURES_FEATURE_1_STATION_ID_RESPONSE);
        features.add(FEATURES_FEATURE_2_STATION_ID_RESPONSE);
        features.add(FEATURES_FEATURE_3_STATION_ID_RESPONSE);

        List<String> paymentOptions = new ArrayList<String>();
        paymentOptions.add(PAYMENTOPTIONS_OPTION_1_STATION_ID_RESPONSE);
        paymentOptions.add(PAYMENTOPTIONS_OPTION_2_STATION_ID_RESPONSE);

        StationIdResponse stationIdResponse = StationIdResponse.builder()
                .features(features)
                .image(IMAGESOURCE_STATION_ID_RESPONSE)
                .paymentOptions(paymentOptions)
                .stationInfo(stationInfo)
                .tariffDetails(tariffDeails)
                .build();

        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse customResponseStationId = CustomResponse.builder().metadata(metaData).data(stationIdResponse).build();

        Mockito.when(chargingstationserviceimpl.getStationDetails("" + EXCEPTIONCAUSINGID)).thenThrow(new NullPointerException());

        final CustomResponse result = chargingStationController.getStationDetails("" + 0001);

    }

    /**
     * To Check the Correctness of Radius,TimeStamp and TimeRequest.
     */
    @Test
    public void shouldCheckForWrongValuesOfVariablesCorrect() {
        ArrayList<Double> co_ordinates = new ArrayList<Double>(Arrays.asList(LATITUDE, LONGITUDE));
        Geometry geometry = Geometry.builder()
                .coOrdinates(co_ordinates)
                .type(ChargingStationConstants.CHARGING_TYPE)
                .build();

        Station station1 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        Station station2 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        List<Station> listmock = Arrays.asList(station1, station2);

        Stations mockreceiveallstations = Stations.builder()
                .type("")
                .features(listmock)
                .build();


        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse mockreceiveallstationscustom = CustomResponse.builder()
                .metadata(metaData)
                .data(mockreceiveallstations)
                .build();

        List<String> companyidList = new ArrayList<String>();
        companyidList.add("9002");
        companyidList.add("9001");

        FilterValues filterValues = FilterValues.builder()
                .startingLatitude(12.928141)
                .startingLongitude(77.618713)
                .endingLatitude(12.928141)
                .endingLongitude(77.618713)
                .radius(5)
                .companyIdList(companyidList)
                .chargerType(99)
                .timeRequired(99)
                .timeStamp("99")
                .build();

        if (MOCK_VALUE_CORRECT_RADIUS < 5 || MOCK_VALUE_CORRECT_CHARGERTYPE < 1 || MOCK_VALUE_CORRECT_TIMEREQUEST < 1) {
            Mockito.when(chargingstationserviceimpl.getStations(filterValues)).thenThrow(new UpdatedRuntimeException("The values are wrongly provided."));
        } else {

            Mockito.when(chargingstationserviceimpl.getStations(filterValues)).thenReturn(mockreceiveallstationscustom);

        }

        final CustomResponse result = chargingStationController.getStations(filterValues);

        assertEquals(mockreceiveallstationscustom, result);

    }

    /**
     * To Check the Correctness of Radius,TimeStamp and TimeRequest.
     */

    @Test(expected = UpdatedRuntimeException.class)
    public void shouldCheckForWrongValuesOfVariablesIncorrect() {
        ArrayList<Double> co_ordinates = new ArrayList<Double>(Arrays.asList(LATITUDE, LONGITUDE));
        Geometry geometry = Geometry.builder()
                .coOrdinates(co_ordinates)
                .type(ChargingStationConstants.CHARGING_TYPE)
                .build();

        Station station1 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        Station station2 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        List<Station> listmock = Arrays.asList(station1, station2);

        Stations mockreceiveallstations = Stations.builder()
                .type("")
                .features(listmock)
                .build();


        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse mockreceiveallstationscustom = CustomResponse.builder()
                .metadata(metaData)
                .data(mockreceiveallstations)
                .build();

        List<String> companyidList = new ArrayList<String>();
        companyidList.add("9002");
        companyidList.add("9001");

        FilterValues filterValues = FilterValues.builder()
                .startingLatitude(12.928141)
                .startingLongitude(77.618713)
                .endingLatitude(12.928141)
                .endingLongitude(77.618713)
                .radius(5)
                .companyIdList(companyidList)
                .chargerType(99)
                .timeRequired(99)
                .timeStamp("99")
                .build();

        if (MOCK_VALUE_INCORRECT_RADIUS < 5 || MOCK_VALUE_INCORRECT_CHARGERTYPE < 1 || MOCK_VALUE_INCORRECT_TIMEREQUEST < 1) {
            Mockito.when(chargingstationserviceimpl.getStations(filterValues)).thenThrow(new UpdatedRuntimeException("The Values are wrongly provided."));
        } else {

            Mockito.when(chargingstationserviceimpl.getStations(filterValues)).thenReturn(mockreceiveallstationscustom);

        }

        final CustomResponse result = chargingStationController.getStations(filterValues);


    }

    /**
     * This test case is used to check the working of getStations() method for less FilterValues provided.
     */
    @Test
    public void shouldWorkForLessValuesPassedIntoFilterValues() {
        ArrayList<Double> co_ordinates = new ArrayList<Double>(Arrays.asList(LATITUDE, LONGITUDE));
        Geometry geometry = Geometry.builder()
                .coOrdinates(co_ordinates)
                .type(ChargingStationConstants.CHARGING_TYPE)
                .build();

        Station station1 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        Station station2 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        List<Station> listmock = Arrays.asList(station1, station2);

        Stations mockreceiveallstations = Stations.builder()
                .type("")
                .features(listmock)
                .build();


        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse mockreceiveallstationscustom = CustomResponse.builder()
                .metadata(metaData)
                .data(mockreceiveallstations)
                .build();

        List<String> companyidList = new ArrayList<String>();
        companyidList.add("9002");
        companyidList.add("9001");

        FilterValues filterValues = FilterValues.builder()
                .startingLatitude(12.928141)
                .startingLongitude(77.618713)
                .radius(5)
                .companyIdList(companyidList)
                .build();

        Mockito.when(chargingstationserviceimpl.getStations(filterValues)).thenReturn(mockreceiveallstationscustom);

        final CustomResponse result = chargingStationController.getStations(filterValues);

        assertEquals(mockreceiveallstationscustom, result);

    }

    /**
     * This test case is used to check the working of getStations() method for no FilterValues given.
     */
    @Test
    public void shouldWorkCorrectlyForZeroValuesPassedAsFilterValues() {

        ArrayList<Double> co_ordinates = new ArrayList<Double>(Arrays.asList(LATITUDE, LONGITUDE));
        Geometry geometry = Geometry.builder()
                .coOrdinates(co_ordinates)
                .type(ChargingStationConstants.CHARGING_TYPE)
                .build();

        Station station1 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        Station station2 = Station.builder()
                .id(ID)
                .geometry(geometry)
                .properties(Properties.builder().icon("").build())
                .type("")
                .build();

        List<Station> listmock = Arrays.asList(station1, station2);

        Stations mockreceiveallstations = Stations.builder()
                .type("")
                .features(listmock)
                .build();


        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse mockreceiveallstationscustom = CustomResponse.builder()
                .metadata(metaData)
                .data(mockreceiveallstations)
                .build();

        List<String> companyidList = new ArrayList<String>();
        companyidList.add("9002");
        companyidList.add("9001");

        FilterValues filterValues = FilterValues.builder().build();

        Mockito.when(chargingstationserviceimpl.getStations(filterValues)).thenReturn(mockreceiveallstationscustom);

        final CustomResponse result = chargingStationController.getStations(filterValues);

        assertEquals(mockreceiveallstationscustom, result);
    }

}
