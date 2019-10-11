package com.tricon.evc.model;
//package com.evc.model;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//
//import lombok.Builder;
//import lombok.Data;
//
//@Entity
//@Data
//@Builder
//@Table(name = "evse_capabilites_xref")
//public class EvseCapabilites {
//  
//  @Id
//  @Column(name = "id")
//  private String id;
//
//  
//  @ManyToOne
//  @JoinColumn(name = "evse_uid", referencedColumnName = "uid")
//  private Evse evse;
//  
//  @Enumerated(EnumType.STRING)
//  @Column(name = "capabilities")
//  private com.evc.enums.EvseCapabilites capabilities;
//  
//
//  
//}
