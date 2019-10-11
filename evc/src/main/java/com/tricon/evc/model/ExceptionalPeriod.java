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
@Table(name = "exceptionalperiod")
public class ExceptionalPeriod {

  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "period_begin")
  private String periodBegin;
  @Column(name = "period_end")
  private String periodEnd;
  


}
