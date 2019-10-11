package com.tricon.evc.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@Table(name = "additionalgeolocation")
public class AdditionalGeoLocation {

  @Id
  @Column(name = "id" )
  private String addtionalGeoLocationId;
  
  @Column(name = "latitude")
  private String latitude;
  
  @Column(name = "longitude")
  private String longitude;
  
  @OneToOne
  @JoinColumn(name="displaytext_id", referencedColumnName = "id")
  private DisplayText displayText;
}
