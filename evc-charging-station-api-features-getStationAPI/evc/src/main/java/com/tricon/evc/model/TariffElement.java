
package com.tricon.evc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
/**
 * The Class TariffElement.
 */
@Entity

/**
 * Instantiates a new tariff element.
 */
@Data
@Table(name = "tariffelement")
public class TariffElement {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** The price component list. */
  @OneToMany
  @JoinColumn(name = "id", referencedColumnName = "id")
  private List<PriceComponent> priceComponentList;

  /** The tarrif restriction. */
  @OneToOne
  @JoinColumn(name = "tarrifrestriction_id", referencedColumnName = "id")
  private TarrifRestriction tarrifRestriction;

}
