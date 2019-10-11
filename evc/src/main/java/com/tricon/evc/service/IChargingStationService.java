package com.tricon.evc.service;

import com.tricon.evc.responsemodel.*;

public interface IChargingStationService {

  /**
   * this funtion returns the list of all the charging stations 
   * @param id
   * @return
   */
  public CustomResponse getStations(double startingLatitude, double startingLongitude, double endingLatitude,
                                    double endingLongitude, int radius, int chargerType, int companyId, String timeStamp, int timeRequired);
  
  /**
   * this function returns the description of the given staion id
   * @param id
   * @return
   */
  public CustomResponse getStationDetails(String id);
  

}
