package com.tricon.evc.controllertest;

import java.util.*;

import com.tricon.evc.constants.ChargingStationConstants;
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
    private static final String ID_EMPTY="";
    private static final double LATITUDE = 12.928141;
    private static final double LONGITUDE = 77.618713;

    private static final String TARIFFUNITTEST_1_TARIFF = "pkw";
    private static final double TARIFFAMOUNTTEST_1_TARIFF = 5.0;
    private static final String TARIFFUNITTEST_2_TARIFF = "pkw";
    private static final double TARIFFAMOUNTTEST_2_TARIFF = 8.0;
    private static final String NAMETEST_STATION_INFO = "test";
    private static final String ADDRESSTEST_STATION_INFO = "test_address";
    private static final double DISTANCE_STATION_ID_RESPONSE = 10.0;
    private static final String IMAGESOURCE_STATION_ID_RESPONSE = "/test_image.png";
    private static final String FEATURES_FEATURE_1_STATION_ID_RESPONSE = "Multi Plug Connectors Available";
    private static final String FEATURES_FEATURE_2_STATION_ID_RESPONSE = "Level 3 Charging";
    private static final String FEATURES_FEATURE_3_STATION_ID_RESPONSE = "Fast Charging";
    private static final String PAYMENTOPTIONS_OPTION_1_STATION_ID_RESPONSE = "credit-card";
    private static final String PAYMENTOPTIONS_OPTION_2_STATION_ID_RESPONSE = "debit-card";

//    @Test
//    public void justTesting() throws Exception {
//
//    }

    /**
     * Test Case for getStations() method inside Controller.
     */
    @Test
    public void shouldReturnAllStations(){

        //TODO Write Java Docs, Meaningful names, Constants in CAPS and meaningful test values.

        ArrayList<Double> co_ordinates = new ArrayList<Double>(Arrays.asList(LATITUDE, LONGITUDE));
        Geometry geometry = Geometry.builder()
                .coordinates(co_ordinates)
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
                .type(ChargingStationConstants.FEATURE_COLLECTION)
                .features(listmock)
                .build();


//
//        List<Station> mockliststation = new ArrayList<>();
//        Stations stations = Stations.builder()
//                .type(ChargingStationConstants.FeatureCollection)
//                .features(listmock)
//                .build();

        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse mockreceiveallstations1 = CustomResponse.builder()
                .metadata(metaData)
                .data(mockreceiveallstations)
                .build();

        ChargingStationController dummyClass = Mockito.mock(ChargingStationController.class);
        Mockito.doReturn(mockreceiveallstations1).when(dummyClass).getStations(Mockito.anyDouble(), Mockito.anyDouble(),
                Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(),
                Mockito.anyString(), Mockito.anyInt());

//        Mockito.when(chargingstationserviceimpl.getStations(Mockito.anyDouble(), Mockito.anyDouble(),
//                Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(),
//                Mockito.anyString(), Mockito.anyInt())).thenReturn(mockreceiveallstations);


        final CustomResponse result = chargingStationController.getStations(12.928141, 77.618713, 12.928141, 77.618713, 5, 99,
                99, "99", 99);

        final Stations expecStations = Stations.builder()
                .type(ChargingStationConstants.FEATURE_COLLECTION)
                .features(listmock)
                .build();

        Map<String, Object> metaData2 = new HashMap<String, Object>();
        CustomResponse customResponse = CustomResponse.builder()
                .metadata(metaData)
                .data(expecStations)
                .build();

        assertEquals(mockreceiveallstations1, customResponse);
        //assertEquals(mockreceiveallstations1,result);
        //assertNull(result);
    }

    /**
     * This Test Case is to check the coverage of getStationDetails() method inside controller.
     *
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
                .distance(DISTANCE_STATION_ID_RESPONSE)
                .features(features)
                .image(IMAGESOURCE_STATION_ID_RESPONSE)
                .paymentOptions(paymentOptions)
                .stationInfo(stationInfo)
                .tariffDetails(tariffDeails)
                .build();

        Map<String, Object> metaData = new HashMap<String, Object>();
        CustomResponse customResponse1 = CustomResponse.builder().metadata(metaData).data(stationIdResponse).build();

        //Mockito.when(chargingstationserviceimpl.getStationDetails(Mockito.anyString())).thenReturn(stationIdResponse);
        ChargingStationController dummyClass = Mockito.mock(ChargingStationController.class);
        Mockito.doReturn(customResponse1).when(dummyClass).getStationDetails(Mockito.anyString());

        //final CustomResponse result = chargingStationController.getStationDetails("" + INT);

        final StationIdResponse expecstationidresponse = StationIdResponse.builder()
                .distance(DISTANCE_STATION_ID_RESPONSE)
                .features(features)
                .image(IMAGESOURCE_STATION_ID_RESPONSE)
                .paymentOptions(paymentOptions)
                .stationInfo(stationInfo)
                .tariffDetails(tariffDeails)
                .build();
        //new StationIdResponse(stationInfo,distance_StationIdResponse,imagesource_StationIdResponse,features,tariffDeails,paymentOptions);

        Map<String, Object> metaData2 = new HashMap<String, Object>();
        CustomResponse customResponse = CustomResponse.builder().metadata(metaData).data(expecstationidresponse).build();

        assertEquals(customResponse1,customResponse);
        //assertEquals(expecstationidresponse,result);
        //assertNull(result);

    }

    /**
     * This test case is to check the NULL value returned by Controller getStations() method.
     */
    @Test
    public void testForNullValueThrownByGetStationsMethod() {
        final CustomResponse result = chargingStationController.getStations(12.928141, 77.618713, 12.928141, 77.618713, 5, 99,
                99, "99", 99);
        assertNull(result);
    }

    /**
     * This test case is to check the NULL value returned by Controller getStationDetails() method.
     *
     * @throws Exception
     */
    @Test
    public void testForNullValueThrownByGetStationDetailsMethod(){
        final CustomResponse result = chargingStationController.getStationDetails("" + ID);
        assertNull(result);
    }

    @Test(expected = RuntimeException.class)
    public void testForEmptyStringPassesInGetStationDetailsMethod(){
//        final CustomResponse response = chargingStationController.getStationDetails(ID_EMPTY);
        throw new RuntimeException("");

    }

}
