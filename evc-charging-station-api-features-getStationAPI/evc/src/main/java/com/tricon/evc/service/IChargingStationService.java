/*
 * 
 */
package com.tricon.evc.service;

import java.io.Serializable;

import com.tricon.evc.model.dto.FilterValues;
import com.tricon.evc.responsemodel.CustomResponse;

/**
 * The Interface IChargingStationService.
 */
public interface IChargingStationService extends Serializable {


  /**
   * @param filterValues
   * @return
   */
   CustomResponse getStations(FilterValues filterValues);
  /**
   * this function returns the description of the given station id.
   *
   * @param id the id
   * @return the station details
   */
   CustomResponse getStationDetails(String id);

}
