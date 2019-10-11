package com.tricon.evc.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "statusschedule")
public class StatusSchedule {
  @Id
  @Column(name = "id")
private String id;

  @Column(name = "period_begin")
  private Timestamp periodBegin;

  @Column(name = "period_end")
private String periodEnd;

  @Column(name = "fk_evse_statusschedule_id")
private String evseStatusScheduleId;



}
