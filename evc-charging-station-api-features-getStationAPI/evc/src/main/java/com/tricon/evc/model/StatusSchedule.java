
package com.tricon.evc.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * The Class StatusSchedule.
 */
@Entity
@Data
@Table(name = "statusschedule")
public class StatusSchedule {
  /** The id. */
  @Id
  @Column(name = "id")
private String id;

  /** The period begin of booking. */
  @Column(name = "period_begin")
  private Date periodBegin;

  /** The period end of booking. */
  @Column(name = "period_end")
private Date periodEnd;

  /** The EVSE which is booked. */
  @Column(name = "evse_id")
private String evseId;



}
