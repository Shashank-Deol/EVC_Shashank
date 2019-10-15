
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

import com.tricon.evc.enums.TarrifType;

import lombok.Data;

/**
 * The Class Tariff.
 */
@Entity

/**
 * Instantiates a new tariff.
 */
@Data
@Table(name = "tariff")
public class Tariff {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** The currency type. */
  @Column(name = "currency")
  private String currency;

  /** The tarrif type. */
  @Column(name = "type")
  private TarrifType type;

  /** The list of tarrif elements. */
  @OneToMany
  @JoinColumn(name = "tariffelement_id")
  private List<TariffElement> tariffElementList;

  /**
   * one connector has many tariff.
   */
  @ManyToOne
  @JoinColumn(name = "connector_id")
  private Connector connector;

  /** Alternative URL to tariff info. */
  @Column(name = "tarrif_alt_url")
  private String tarrifAltUrl;

  /** The price. */
  @OneToOne
  @JoinColumn(name = "price_id", referencedColumnName = "id")
  private Price price;

  /** The When this field is set, a Charging Session with this
   *  tariff will minimum cost this amount.. */
  @Column(name = "start_datetime")
  private Date startDateTime;

  /** The Details on the energy supplied with this tariff.. */
  @OneToOne
  @JoinColumn(name = "tarrif_energymix_id", referencedColumnName = "id")
  private EnergyMix energyMix;

  /** The time after which this tariff is no longer valid. */
  @Column(name = "end_datetime")
  private Date endDateTime;
}
