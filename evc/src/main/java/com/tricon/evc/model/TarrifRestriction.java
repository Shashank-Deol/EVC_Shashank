package com.tricon.evc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tricon.evc.enums.DayOfWeek;
import com.tricon.evc.enums.Reservation;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name ="tariffrestriction")
public class TarrifRestriction {

  @Id
  @Column(name ="id")
  private String id;

  @Column(name="start_time")
  private String startTime;
  
  @Column(name="end_time")
  private String endTime;
  
  @Column(name="start_date")
  private String startDate;
  
  @Column(name="end_date")
  private String endDate;
  
  @Column(name="min_kwh")
  private float minKwh;
  
  @Column(name="max_kwh")
  private float maxKwh;
  
  @Column(name="min_power")
  private float minPower;
  
  @Column(name="max_power")
  private float maxPower;
  @Column(name="min_duration")
  private int minDuration;
  
  @Column(name="max_duration")
  private float maxDuration;
  
  @Column(name = "day_of_week")
  private DayOfWeek dayOfWeek;
  
  @Column(name = "reservation")
  private Reservation reservateion;
}
