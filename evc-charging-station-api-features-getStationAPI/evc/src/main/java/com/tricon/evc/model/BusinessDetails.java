
package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.ImageIcon;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BusinessDetails, which maintains the business details.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "businessdetails")
public class BusinessDetails {

  /** The Business detail id. */
  @Id
  @Column(name = "id")
  private String businessDetailId;

  /** The name of Company. */
  @Column(name = "name")
  private String companyName;

  /** The website url. */
  @Column(name = "websiteName")
  private String website;

  /** The logo of the business. */
  @Column(name = "logo")
  private ImageIcon logo;

}
