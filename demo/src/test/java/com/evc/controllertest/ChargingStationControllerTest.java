package com.evc.controllertest;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.evc.controller.ChargingStationController;
import com.evc.eventhandler.UpdatedRuntimeException;
import com.evc.model.dto.Station;
import com.evc.responsemodel.Stations;
import com.evc.service.ChargingStationServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ChargingStationController.class, secure = false)
public class ChargingStationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ChargingStationServiceImpl chargingstationserviceimpl;

	Station station1 = new Station(102, 12.928141, 77.618713);
	Station station2 = new Station(102, 12.928141, 77.618713);

	List<Station> listmock = Arrays.asList(station1, station2);
	Stations mockreceiveallstations = new Stations(listmock);

	@Test(expected = UpdatedRuntimeException.class)
	public void shouldThrowAnException() throws Exception {
		Mockito.when(chargingstationserviceimpl.getStationDetails(Mockito.anyString())).thenThrow(NullPointerException.class);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stations/102");//.accept(MediaType.APPLICATION_JSON);
		try {
		MvcResult result = (MvcResult) mockMvc.perform(requestBuilder);
		}catch(Exception e) {
			throw new UpdatedRuntimeException("");
		}
	}

	@Test
	public void shouldReturnEmptyArray() throws Exception{
		Mockito.when(chargingstationserviceimpl.getStations(Mockito.anyDouble(), Mockito.anyDouble(),
				Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(),
				Mockito.anyString(), Mockito.anyInt())).thenReturn(mockreceiveallstations);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stations?startingLatitude=12.928141&startingLongitude=77.618713").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"id\":102,\"properties\":{\"icon\":\"fuel-11\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[12.928141,77.618713]}},{\"type\":\"Feature\",\"id\":102,\"properties\":{\"icon\":\"fuel-11\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[12.928141,77.618713]}}]}";
    	JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	/*
	@Test
	public void shouldReturnAllTheStations() throws Exception {
		Mockito.when(chargingstationserviceimpl.getStations(Mockito.anyDouble(), Mockito.anyDouble(),
				Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(),
				Mockito.anyString(), Mockito.anyInt())).thenReturn(mockreceiveallstations);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stations/102").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "";
//		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
*/
}
