package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.ImageIcon;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "businessdetails")
public class BusinessDetails {

  @Id
  @Column(name = "id")
  private String BusinessDetailId;
  /**
   * this is the name of business
   */
  @Column(name = "name")
  private String name;
  
  @Column(name = "websiteName")
  private String website;
  
  @Column(name = "logo")
  private ImageIcon logo;
  
}
