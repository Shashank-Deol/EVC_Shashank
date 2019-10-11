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
import com.tricon.evc.enums.TarrifType;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "tariff")
public class Tariff {

  @Id
  @Column(name = "id")
  private String id;
  
  @Column(name = "currency")
  private String currency;
  
  @Column(name = "type")
  private TarrifType type;
  
  
  @OneToMany
  @JoinColumn(name = "tariffelement_id")
  private List<TariffElement> tariffElementList;
  
  /**
   * one connector has many tariff.
   */
  @ManyToOne
  @JoinColumn(name = "connector_id")
  private Connector connector;
  
  
  @Column(name = "tarrif_alt_url")
  private String tarrifAltUrl;
  
  @OneToOne
  @JoinColumn(name = "price_id",referencedColumnName = "id")
  private Price price;
  
  @Column(name = "start_datetime")
  private Date startDateTime;
  
  @OneToOne
  @JoinColumn(name = "tarrif_energymix_id" , referencedColumnName = "id")
  private EnergyMix energyMix;
  
  @Column(name = "end_datetime")
  private Date endDateTime;
}
