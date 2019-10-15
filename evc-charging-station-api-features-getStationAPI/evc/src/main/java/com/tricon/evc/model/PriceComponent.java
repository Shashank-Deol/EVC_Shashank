
package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tricon.evc.enums.PriceComponentType;

import lombok.Data;

/**
 * The Class PriceComponent.
 */
@Entity
@Data
@Table(name = "pricecomponent")
public class PriceComponent {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** The Type of tariff dimension. */
  @Column(name = "type")
  private PriceComponentType type;

  /** The price per unit (excluding VAT) for. */
  @Column(name = "price")
  private String price;

  /** The applicable VAT percentage for this tariff dimension.
   *  If omitted, no VAT is applicable,
   *   that is different from 0% VAT,
   *    which would be a value of 0.0 here.. */
  @Column(name = "vat")
  private String vat;

  /** The Minimum amount to be billed.
   * This unit will be billed in this step_size blocks.. */
  @Column(name = "step_size")
  private int stepSize;

  /** The tarrif element. */
  @ManyToOne
  @JoinColumn(name = "tariffelement_id", referencedColumnName = "id")
  private TariffElement tarrifElement;
}
