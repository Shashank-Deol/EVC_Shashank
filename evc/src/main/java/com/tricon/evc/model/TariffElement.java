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

import com.tricon.evc.enums.ChargingStationType;
import com.tricon.evc.enums.Facilities;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "tariffelement")
public class TariffElement {

  @Id
  @Column(name = "id")
  private String id;
  
  
  @OneToMany
  @JoinColumn(name = "id",referencedColumnName = "id")
  private List<PriceComponent> priceComponentList;
  
  @OneToOne
  @JoinColumn(name = "tarrifrestriction_id",referencedColumnName = "id")
  private TarrifRestriction tarrifRestriction;
  
}
