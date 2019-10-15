
package com.tricon.evc.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *  Connector.
 */
@Entity
@Data
@Table(name = "connector")
public class Connector {

  /** The id. */
  @Id
  @Column(name = "id")
  private String connectorId;

  /** The standard of the installed connector. */
  @Column(name = "standard")
  private String standard;

  /** The format (socket/cable) of the installed connector. */
  @Column(name = "format")
  private String format;

  /** The power type. */
  @Column(name = "power_type")
  private String powerType;

  /** The voltage of the connector. */
  @Column(name = "voltage")
  private Integer voltage;

  /** The amperage of connector. */
  @Column(name = "amperage")
  private Integer amperage;

  /** The if of tariff for this connector. */
  @Column(name = "tariff_id")
  private String tariffId;

  /** The max electric power. */
  @Column(name = "max_electric_power")
  private int maxElectricPower;

  /** The terms and conditions of the connector. */
  @Column(name = "terms_and_conditions")
  private String termsAndConditions;

  /** The last updated. */
  @Column(name = "last_updated")
  private String lastUpdated;

  /** The evse id it belongs to . */
  @Column(name = "evse_id")
  private String evseId;

}
