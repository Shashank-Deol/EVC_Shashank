package com.evc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evc.model.dto.StationIdResponse;
import com.evc.responsemodel.Stations;
import com.evc.service.ChargingStationServiceImpl;

@RestController
public class ChargingStationController {

//	"http://172.16.17.30:8066/stations?startingLatitude="+15.2345+"&startingLongitude="+23.3432+"&radius=5&chargerType=1timeStamp=2008-09-15T15:53:00+05:00"

	@Autowired
	ChargingStationServiceImpl serviceObject;

	static final Logger LOGGER = Logger.getLogger(ChargingStationController.class.getName());

	@RequestMapping(value = "/stations", method = RequestMethod.GET)
	public Stations getStations(@RequestParam(value = "startingLatitude") double startingLatitude,
			@RequestParam(value = "startingLongitude") double startingLongitude,
			@RequestParam(value = "endingLatitude", defaultValue = "0") double endingLatitude,
			@RequestParam(value = "endingLongitude", defaultValue = "0") double endingLongitude,
			@RequestParam(value = "radius", defaultValue = "5") int radius,
			@RequestParam(value = "chargerType", defaultValue = "99") int chargerType,
			@RequestParam(value = "companyId", defaultValue = "99") int companyId,
			@RequestParam(value = "timeStamp", defaultValue = "99") String timeStamp,
			@RequestParam(value = "timeRequierd", defaultValue = "99") int timeRequired

	) {

		LOGGER.info("Entering into the getStations Class in the Contorller");

		return serviceObject.getStations(startingLatitude, startingLongitude, endingLatitude, endingLongitude, radius,
				chargerType, companyId, timeStamp, timeRequired);

	}

	@RequestMapping(value = "/stations/{id}", method = RequestMethod.GET)
	public StationIdResponse getStationDetails(@PathVariable String id) {
		return serviceObject.getStationDetails(id);
	}

}
