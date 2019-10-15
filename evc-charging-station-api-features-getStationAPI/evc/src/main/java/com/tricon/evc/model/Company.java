
package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Company.
 */
@Entity
@Data
@Table(name = "company")
public class Company {

  /** The company id. */
  @Id
  @Column(name = "id")
  private String companyId;

  /** The company name. */
  @Column(name = "name")
  private String companyName;

}
