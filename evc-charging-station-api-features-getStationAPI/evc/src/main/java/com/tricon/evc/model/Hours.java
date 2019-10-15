package com.tricon.evc.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
/**
 * hours.
 *
 */
@Data
@Entity
@Table(name = "hours")
public class Hours {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** the boolean value which says that the station open 24/7 or not. */
  @Column(name = "twentyfourseven")
  private boolean twentyFourSeven;

  /** The regular hours of station open. */
  @OneToOne
  @JoinColumn(name = "regularhours_id", referencedColumnName = "id")
  private RegularHours regularHours;

  /** The exceptional period in which the station is not open. */
  @OneToOne
  @JoinColumn(name = "exceptionalperiod_id", referencedColumnName = "id")
  private ExceptionalPeriod exceptionalPeriod;

  /** Exceptions for specified calendar dates, time-range based. Periods the
   * station is not operating/accessible. Overwriting regularHours and
   * exceptionalOpenings. Should not overlap exceptionalOpenings.. */
  @Column(name = "exceptional_closing")
  private String exceptionalClosing;

}
