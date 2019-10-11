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

@Table(name = "company")
public class Company {

  @Id
  @Column(name = "id")
  private String id;
  
  @Column(name = "name")
  private String name;
  

}
