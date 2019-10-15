
package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Capabilites.
 */
@Entity
@Data
@Table(name = "evse_capabilities_xref")
public class Capabilities {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** The evse id for which the capability is defined. */
  @Column(name = "evse_uid")
  private String uid;

  /** The capability Value. */
  @Column(name = "capablity")
  private com.tricon.evc.enums.Capabilities capabilities;

}
