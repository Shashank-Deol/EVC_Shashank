
package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * The Class Price.
 */
@Entity
@Data
@Table(name = "price")
public class Price {

  /** The id. */
  @Id
  @Column(name = "id")
  private String priceId;

  /** The minimum exculding vat. */
  @Column(name = "min_excl_vat")
  private float minimumExculdingVat;

  /** The minimum includeing vat. */
  @Column(name = "min_inc_vat")
  private float minimumIncludingVat;

  /** The maximum excluding vat. */
  @Column(name = "max_excl_vat")
  private float maximumExcludingVat;

  /** The maximun includeing vat. */
  @Column(name = "max_incl_vat")
  private float maximunIncludingVat;
}
