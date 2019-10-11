package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "price")
public class Price {

  @Id
  @Column(name = "id")
  private String id;
  
  @Column(name = "min_excl_vat")
  private float minimumExculdingVat;
  
  @Column(name = "min_inc_vat")
  private float minimumIncludeingVat;
  
  @Column(name = "max_excl_vat")
  private float maximumExcludingVat;
  
  @Column(name = "max_incl_vat")
  private float maximunIncludeingVat;
}
