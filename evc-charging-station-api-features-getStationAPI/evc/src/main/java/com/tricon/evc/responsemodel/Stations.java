package com.tricon.evc.responsemodel;

import java.util.ArrayList;
import java.util.List;

import com.tricon.evc.model.dto.Station;

import lombok.Builder;
import lombok.Data;
/**
 * return type object required by mapbox.
 */
@Data
@Builder
public class Stations {

  /** The type defined by mapbox. */
  private String type;

  /** The list of station objects defined by mapbox. */
  private List<Station> features = new ArrayList<Station>();

}
