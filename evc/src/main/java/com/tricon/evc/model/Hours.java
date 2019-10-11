package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "hours")
public class Hours {
  @Id
  @Column(name = "id")
  private String id;
  
  @Column(name = "twentyfourseven")
  private boolean twentyFourSeven;
  
  
  @OneToOne
  @JoinColumn(name = "regularhours_id", referencedColumnName = "id")
  private RegularHours regularHours;
  
  @OneToOne
  @JoinColumn(name = "exceptionalperiod_id", referencedColumnName = "id")
  private ExceptionalPeriod exceptionalPeriod;

  @Column(name = "exceptional_closing")
  private String exceptionalClosing;

  
  
}
