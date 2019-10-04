package com.evc.service;

import com.evc.responsemodel.CustomResponse;
import com.evc.responsemodel.Stations;

public interface IChargingStationService {

	Stations getStations(double startingLatitude, double startingLongitude, double endingLatitude,	double endingLongitude, int radius, int chargerType, int companyId, String timeStamp, int timeRequired);

	CustomResponse getStationById(int id);





}