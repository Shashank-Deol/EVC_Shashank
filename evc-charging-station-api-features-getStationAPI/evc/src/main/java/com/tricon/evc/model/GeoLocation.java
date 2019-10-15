
package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * The Class GeoLocation.
 */
@Entity
@Data
@Table(name = "geolocation")

public class GeoLocation {

  /** The geo location id. */
  @Id
  @Column(name = "id")
  private String geoLocationId;

  /**  latitude . */
  @Column(name = "latitude")
  private String latitude;

  /**  longitude. */
  @Column(name = "longitude")
  private String longitude;

}
