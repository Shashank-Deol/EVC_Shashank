package com.tricon.evc.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * station class defined by mapbox.
 */
@Builder
@Data
public class Station {

  /** The station type defined by mapbox. */
  private String type;

  /** The id of the station. */
  private int id;

  /** The properties. */
  private Properties properties;

  /** This object contains the coOrdinates. */
  private Geometry geometry;
}
