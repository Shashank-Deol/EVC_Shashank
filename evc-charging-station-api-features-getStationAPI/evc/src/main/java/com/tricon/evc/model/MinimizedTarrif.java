package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * this is used for details related to tarrif.
 *
 */
@Entity(name = "minimised_tariff")
@Data
public class MinimizedTarrif {

  /**
   * id.
   */
  @Id
  @Column(name = "id")
  private String id;

  /**
   * minimun cost for registerd users.
   */
  @Column(name = "minimum_cost_for_members")
  private float minimunCostForUsers;

  /**
   * maximum cost for unregesterd user.
   */
  @Column(name = "maximum_cost_for_membersl")
  private float maximumCostForUsers;
  /**
   * minimun cost for registerd users.
   */
  @Column(name = "minimum_cost_for_non_members")
  private float minimunCostForNonUsers;

  /**
   * maximum cost for unregesterd user.
   */
  @Column(name = "maximum_cost_for_non_members")
  private float maximumCostForNonUsers;

  /**
   * payment type details.
   */

  @Column(name = "payment_type")
  private String paymentDetails;

}
