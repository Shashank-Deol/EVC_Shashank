package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * The Class ExceptionalPeriod.
 */
@Entity
@Data
@Table(name = "exceptionalperiod")
public class ExceptionalPeriod {

  /** The id. */
  @Id
  @Column(name = "id")
  private Integer id;

  /** The Begin of the exception. */
  @Column(name = "period_begin")
  private String periodBegin;

  /** The End of the exception. */
  @Column(name = "period_end")
  private String periodEnd;

}
