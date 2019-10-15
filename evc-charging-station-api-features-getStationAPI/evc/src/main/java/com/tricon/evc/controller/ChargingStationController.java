/**
 * This package consists of controller .
 */
package com.tricon.evc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tricon.evc.model.dto.FilterValues;
import com.tricon.evc.responsemodel.CustomResponse;
import com.tricon.evc.service.ChargingStationServiceImpl;


/**
 * The Class ChargingStationController.
 */
@RestController
public class ChargingStationController {


  /** The charging station service object. */
  @Autowired
 private ChargingStationServiceImpl chargingStationServiceObject;

  /** The Constant LOGGER. */
  static final Logger LOGGER = Logger.getLogger(
      ChargingStationController.class.getName());

  /**
   * Gets the stations.
   * @param filterValues contains request body .
   * *
   * @return {@link CustomResponse}
   */
  @RequestMapping(value = "/stations", method = RequestMethod.GET)
  public CustomResponse getStations(
      @RequestBody final FilterValues filterValues) {

    LOGGER.info("Entering into the getStations Class in the Contorller");

    return chargingStationServiceObject.getStations(filterValues);

  }

  /**
   * Gets the station details.
   *
   * @param id the id
   * @return the station details
   */
  @RequestMapping(value = "/stations/{id}", method = RequestMethod.GET)
  public CustomResponse getStationDetails(@PathVariable final String id) {
    return chargingStationServiceObject.getStationDetails(id);
  }

}
