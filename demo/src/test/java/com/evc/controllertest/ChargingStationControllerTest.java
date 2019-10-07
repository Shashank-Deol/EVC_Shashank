package com.evc.controllertest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.evc.controller.ChargingStationController;
import com.evc.model.dto.Station;
import com.evc.model.dto.StationIdResponse;
import com.evc.model.dto.StationInfo;
import com.evc.model.dto.Tariff;
import com.evc.model.dto.TariffDeails;
import com.evc.responsemodel.Stations;
import com.evc.service.ChargingStationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ChargingStationControllerTest {

	@InjectMocks
	private ChargingStationController chargingStationController;

	@Mock
	private ChargingStationServiceImpl chargingstationserviceimpl;

	private static final int id = 102;
	private static final double latitude = 12.928141;
	private static final double longitude = 77.618713;

	private static final String tariffunittest1_Tariff = "pkw";
	private static final double tariffamounttest1_Tariff = 5.0;
	private static final String tariffunittest2_Tariff = "pkw";
	private static final double tariffamounttest2_Tariff = 8.0;
	private static final String nametest_StationInfo = "test";
	private static final String addresstest_StationInfo = "test_address";
	private static final double distance_StationIdResponse = 10.0;
	private static final String imagesource_StationIdResponse = "/test_image.png";
	private static final String features_feature1_StationIdResponse = "Multi Plug Connectors Available";
	private static final String features_feature2_StationIdResponse = "Level 3 Charging";
	private static final String features_feature3_StationIdResponse = "Fast Charging";
	private static final String paymentoptions_option1_StationIdResponse = "credit-card";
	private static final String paymentoptions_option2_StationIdResponse = "debit-card";

	@Test
	public void shouldReturnAllStations() throws Exception {

		Station station1 = new Station(id, latitude, longitude);
		Station station2 = new Station(id, latitude, longitude);

		List<Station> listmock = Arrays.asList(station1, station2);
		Stations mockreceiveallstations = new Stations(listmock);

		Mockito.when(chargingstationserviceimpl.getStations(Mockito.anyDouble(), Mockito.anyDouble(),
				Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(),
				Mockito.anyString(), Mockito.anyInt())).thenReturn(mockreceiveallstations);

		final Stations result = chargingStationController.getStations(12.928141, 77.618713, 12.928141, 77.618713, 5, 99,
				99, "99", 99);
		final Stations expecStations = new Stations();
		expecStations.setFeatures(listmock);
		assertEquals(expecStations, result);
	}

	@Test
	public void shouldReturnDetailsOfStation() throws Exception {
		Tariff tariff1 = new Tariff(tariffunittest1_Tariff,tariffamounttest1_Tariff);
		Tariff tariff2 = new Tariff(tariffunittest2_Tariff,tariffamounttest2_Tariff);		
		
		TariffDeails tariffdetails = new TariffDeails(tariff1,tariff2);
		
		StationInfo stationinfo = new StationInfo(nametest_StationInfo,addresstest_StationInfo);
		
		List<String> features = new ArrayList<String>();
		features.add(features_feature1_StationIdResponse);
		features.add(features_feature2_StationIdResponse);
		features.add(features_feature3_StationIdResponse);
		
		List<String> paymentOptions = new ArrayList<String>();
		paymentOptions.add(paymentoptions_option1_StationIdResponse);
		paymentOptions.add(paymentoptions_option2_StationIdResponse);
		
		StationIdResponse stationidresponse = new StationIdResponse(stationinfo,distance_StationIdResponse,imagesource_StationIdResponse,features,tariffdetails,paymentOptions);
		
		Mockito.when(chargingstationserviceimpl.getStationDetails(Mockito.anyString())).thenReturn(stationidresponse);
		
		final StationIdResponse result = chargingStationController.getStationDetails("102");
		final StationIdResponse expecstationidresponse = new StationIdResponse();
		expecstationidresponse.setDistance(10.0);
		expecstationidresponse.setFeatures(features);
		expecstationidresponse.setImage(imagesource_StationIdResponse);
		expecstationidresponse.setPaymentOptions(paymentOptions);
		expecstationidresponse.setStationInfo(stationinfo);
		expecstationidresponse.setTariffDetails(tariffdetails);
		assertEquals(expecstationidresponse,result);
	}
	/*
	 * @Test public void shouldReturnAllTheStations() throws Exception {
	 * Mockito.when(chargingstationserviceimpl.getStations(Mockito.anyDouble(),
	 * Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble(),
	 * Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString(),
	 * Mockito.anyInt())).thenReturn(mockreceiveallstations); RequestBuilder
	 * requestBuilder =
	 * MockMvcRequestBuilders.get("/stations/102").accept(MediaType.APPLICATION_JSON
	 * ); MvcResult result = mockMvc.perform(requestBuilder).andReturn(); String
	 * expected = ""; // JSONAssert.assertEquals(expected,
	 * result.getResponse().getContentAsString(), false); }
	 */
}
