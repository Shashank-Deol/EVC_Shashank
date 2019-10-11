package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "regularhours")
public class RegularHours {
  @Id
  @Column(name = "id")
  private String id;
  @Column(name = "weekday")
  private int weekday;
  @Column(name = "period_begin")
  private String periodBegin;

}