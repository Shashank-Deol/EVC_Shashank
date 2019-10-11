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
@Table(name = "evse_capabilities_xref")
public class Capabilities {

  @Id
  @Column(name = "id")
  private String id;
  @Column(name = "evse_uid")
  private String uid;
  @Column(name = "capablity")
  com.tricon.evc.enums.Capabilities capabilities;

  
}
