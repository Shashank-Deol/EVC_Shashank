package com.tricon.evc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "energymix")
public class EnergyMix {
  
  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "is_green_energy")
  private boolean isGreenEnergy;

  @Column(name = "supplier")
  private String supplier;

  @Column(name = "energy_product_name")
  private String  energyProductName;
  


}
