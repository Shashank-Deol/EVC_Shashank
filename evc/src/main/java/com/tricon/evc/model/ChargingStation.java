
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


@Entity
@Data
@Table(name = "station")
public class ChargingStation {

  public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

@Id
  @Column(name = "id")
  private String id;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private ChargingStationType type;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "address")
  private String address;
  
  
  @Column(name = "city")
  private String city;
  
  @Column(name = "postal_code")
  private String postalCode;
  
  @Column(name = "state")
  private String state;
  
  @Column(name = "country")
  private String country;
  
  @OneToOne
  @JoinColumn(name="station_additionalgeolocation_id", referencedColumnName = "id")
  private AdditionalGeoLocation additionalGeoLocation;
  
  @OneToMany
  @JoinColumn(name = "station_id")
  private List<Evse> evseList;
  
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="station_geolocation_id", referencedColumnName = "id")
  private GeoLocation geoLocation;
  
  @OneToOne
  @JoinColumn(name="station_displaytext_id", referencedColumnName = "id")
  private DisplayText dispalyText;
  
  @OneToOne
  @JoinColumn(name="businessdetail_id", referencedColumnName = "id")
  private BusinessDetails businessDetails;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "facilities")
  private Facilities facilities;
  
  @Column(name = "time_zone")
  private Date timeZone;

  @OneToOne
  @JoinColumn(name="hours_id", referencedColumnName = "id")
  private Hours hours;  

  @Column(name = "charging_when_closed")
  private boolean chargingWhenClosed;
  
  @OneToOne
  @JoinColumn(name="energymix_id", referencedColumnName = "id")
  private EnergyMix energyMix;
  

  @Column(name = "last_updated")
  private Date lastUpdate;
  
  @OneToMany
  @JoinColumn(name = "station_id")
  private List<Image> imageList; 

}
