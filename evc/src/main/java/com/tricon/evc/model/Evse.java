
package com.tricon.evc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tricon.evc.enums.ParkingRestrications;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "evse")
public class Evse {
	Evse()
	{
		
	}

  @Id
  @Column(name = "uid")
  private String uid;
  
  @Column(name = "evse_id")
  private String evseId;
  
  @ManyToOne
  @JoinColumn(name = "evse_station_id")
  private ChargingStation chargingStation;
  
  @Column(name = "status")
  private String status;
  
  @OneToMany
  @JoinColumn(name = "evse_uid")
  private List<Capabilities> capabilities;
  
  @OneToMany
  @JoinColumn(name = "evse_id")
  private List<Connector> connectors;
  
  
  @Column(name = "session")
  private String session;
  
  @Column(name = "floor_level")
  private String floorLevel;
  
  @Column(name = "physical_reference")
  private String physicalReference;
  
  @OneToOne
  @JoinColumn(name = "evse_geolocation_id",referencedColumnName = "id")
  private GeoLocation geoLocation;
  
  @OneToOne
  @JoinColumn(name = "evse_displaytext_id",referencedColumnName = "id")
  private DisplayText displayText;
  
  @Column(name = "prarking_restrictions")
  private ParkingRestrications parkingRestrictions;
  
  @Column(name = "last_updated")
  private Date lastUpdated;
  
  @OneToOne
  @JoinColumn(name = "company_id",referencedColumnName = "id")
  private Company company;
//  
//  @OneToMany
//  @JoinColumn(name = "evse_uid")
//  private List<EvseCapabilites> evseCapabilitesList; 
  
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "image_evse_id")
  private List<Image> imageList; 
  

}
