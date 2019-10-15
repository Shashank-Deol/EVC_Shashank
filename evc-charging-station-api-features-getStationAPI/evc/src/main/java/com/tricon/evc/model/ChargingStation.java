
package com.tricon.evc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tricon.evc.enums.ChargingStationType;
import com.tricon.evc.enums.Facilities;

import lombok.Data;
/**
 *  ChargingStation.
 */
@Entity
@Data
@Table(name = "station")
public class ChargingStation {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** The type of charging station. */
  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private ChargingStationType type;

  /** The name of the charging station. */
  @Column(name = "name")
  private String name;

  /** The address of the charging station. */
  @Column(name = "address")
  private String address;

  /** The city in which the charging station. */
  @Column(name = "city")
  private String city;

  /** The postal code of the city . */
  @Column(name = "postal_code")
  private String postalCode;

  /** The state. */
  @Column(name = "state")
  private String state;

  /** The country in which the charging station is present. */
  @Column(name = "country")
  private String country;

  /** The additional geo location . */
  @OneToOne
  @JoinColumn(
      name = "station_additionalgeolocation_id",
      referencedColumnName = "id")
  private AdditionalGeoLocation additionalGeoLocation;

  /** The list of EVSE present in charging station. */
  @OneToMany
  @JoinColumn(name = "evse_station_id")
  private List<Evse> evseList;

  /** The location of the charging station. */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "station_geolocation_id", referencedColumnName = "id")
  private GeoLocation geoLocation;

  /** The description of the charging station. */
  @OneToOne
  @JoinColumn(name = "station_displaytext_id", referencedColumnName = "id")
  private DisplayText dispalyText;

  /** The business details of the charging station. */
  @OneToOne
  @JoinColumn(name = "businessdetail_id", referencedColumnName = "id")
  private BusinessDetails businessDetails;

  /** The Optional list of facilities this
   * charge location directly belongs to.. */
  @Enumerated(EnumType.STRING)
  @Column(name = "facilities")
  private Facilities facilities;

  /** The time zone. */
  @Column(name = "time_zone")
  private Date timeZone;

  /** The The times when the
   * EVSEs at the location can be accessed for
      charging.. */
  @OneToOne
  @JoinColumn(name = "hours_id", referencedColumnName = "id")
  private Hours hours;

  /** The charging when closed. */
  @Column(name = "charging_when_closed")
  private boolean chargingWhenClosed;

  /** The Details on the energy supplied at this location. */
  @OneToOne
  @JoinColumn(name = "energymix_id", referencedColumnName = "id")
  private EnergyMix energyMix;

  /** The last update time. */
  @Column(name = "last_updated")
  private Date lastUpdate;

//  @OneToMany
//  @JoinColumn(name = "station_id")
//  private List<Image> imageList;
  /**
   * payment details.
   */
  @OneToOne
  @JoinColumn(name = "minimised_tariff_id", referencedColumnName = "id")
  private MinimizedTarrif tarrifDetails;

}
