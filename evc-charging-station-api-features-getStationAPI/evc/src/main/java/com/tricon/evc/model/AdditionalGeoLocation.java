
package com.tricon.evc.model;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class AdditionalGeoLocation.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "additionalgeolocation")
public class AdditionalGeoLocation {

  /** The addtional geo location id. */
  @Id
  @Column(name = "id")
  private String addtionalGeoLocationId;

  /** The latitude of the station. */
  @Column(name = "latitude")
  private String latitude;

  /** The longitude of the station. */
  @Column(name = "longitude")
  private String longitude;

  /** The  text to be displayed. */
  @OneToOne
  @JoinColumn(name = "displaytext_id", referencedColumnName = "id")
  private DisplayText displayText;
}
