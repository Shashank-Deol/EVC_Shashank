package com.tricon.evc.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Geometry defined by mapbox.
 *
 */
@Data
@Builder
public class Geometry {

  /** The type of geometry given by mapbox. */
  private String type;

  /** The coordinates arrat. */
  //private double[] coOrdinates = new double[2];
  List<Double> coOrdinates;

}
