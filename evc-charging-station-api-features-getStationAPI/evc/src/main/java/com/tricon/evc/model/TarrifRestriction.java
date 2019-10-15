
package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tricon.evc.enums.DayOfWeek;
import com.tricon.evc.enums.Reservation;

import lombok.Data;

/**
 * The Class TarrifRestriction.
 */
@Entity
@Data
@Table(name = "tariffrestriction")
public class TarrifRestriction {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** The time form which tariff can be implemented.*/
  @Column(name = "start_time")
  private String startTime;

  /** The time till which the tariff can be implented. */
  @Column(name = "end_time")
  private String endTime;

  /** The  date  form which tariff can be implemented.. */
  @Column(name = "start_date")
  private String startDate;

  /** The  date till which the tariff can be implented.. */
  @Column(name = "end_date")
  private String endDate;

  /** The Minimum kwh in kW. */
  @Column(name = "min_kwh")
  private float minKwh;

  /** The Maximum kwh in kW. */
  @Column(name = "max_kwh")
  private float maxKwh;

  /** The min power. */
  @Column(name = "min_power")
  private float minPower;

  /** The max power. */
  @Column(name = "max_power")
  private float maxPower;

  /** The min duration. */
  @Column(name = "min_duration")
  private int minDuration;

  /** The max duration. */
  @Column(name = "max_duration")
  private float maxDuration;

  /** The day of week. */
  @Column(name = "day_of_week")
  private DayOfWeek dayOfWeek;

  /** When this field is present, this tariffElement is for a reservation. */
  @Column(name = "reservation")
  private Reservation reservateion;
}
