package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  EnergyMix.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "energymix")
public class EnergyMix {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** True if 100% from regenerative sources.
   *  (CO2 and nuclear waste is zero). */
  @Column(name = "is_green_energy")
  private boolean isGreenEnergy;

  /**  the person who supplies ebery. */
  @Column(name = "supplier")
  private String supplier;

  /** Name of the energy suppliers product/tariff
   *  plan used at this location. */
  @Column(name = "energy_product_name")
  private String energyProductName;

}
