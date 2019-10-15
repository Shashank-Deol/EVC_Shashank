
package com.tricon.evc.model;

import java.util.Date;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tricon.evc.enums.ParkingRestrications;

import lombok.Data;

/**
 * Evse.
 */
@Entity
@Data
@Table(name = "evse")
public class Evse {

  /** The uid. */
  @Id
  @Column(name = "uid")
  private String uid;

  /** The evse id. */
  @Column(name = "evse_id")
  private String evseId;

  /** The charging station. */
  @ManyToOne
  @JoinColumn(name = "evse_station_id")
  private ChargingStation chargingStation;

  /** The status. */
  @Column(name = "status")
  private String status;

  /** The list of  capabilities. */
  @OneToMany
  @JoinColumn(name = "evse_uid")
  private List<Capabilities> capabilities;

  /** The list of  connectors EVSE contain. */
  @OneToMany
  @JoinColumn(name = "evse_id")
  private List<Connector> connectors;

  /** The session details provided by the . */
  @Column(name = "session")
  private String session;

  /** the floor in whcih the evse present. */
  @Column(name = "floor_level")
  private String floorLevel;

  /**A number/string printed on the outside of the EVSE for visual
   * identification. */
  @Column(name = "physical_reference")
  private String physicalReference;

  /** The geo location. */
  @OneToOne
  @JoinColumn(name = "evse_geolocation_id", referencedColumnName = "id")
  private GeoLocation geoLocation;

  /** The display text. */
  @OneToOne
  @JoinColumn(name = "evse_displaytext_id", referencedColumnName = "id")
  private DisplayText displayText;

  /** The restrictions that apply to the parking spot. */
  @Column(name = "prarking_restrictions")
  private ParkingRestrications parkingRestrictions;

  /** The last updated. */
  @Column(name = "last_updated")
  private Date lastUpdated;

  /** The list of scedules for the evse. */
  @OneToMany
  @JoinColumn(name = "evse_id")
  private List<StatusSchedule> schedules;

  /** The company. */
  @OneToOne
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  private Company company;

//  @OneToMany
//  @JoinColumn(name = "evse_uid")
//  private List<EvseCapabilites> evseCapabilitesList;

  /** The image list of evse. */
  @OneToMany
  @JoinColumn(name = "image_evse_id")
  private List<Image> imageList;

}
