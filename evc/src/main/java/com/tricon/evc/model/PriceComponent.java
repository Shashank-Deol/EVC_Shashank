package com.tricon.evc.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tricon.evc.enums.DayOfWeek;
import com.tricon.evc.enums.PriceComponentType;
import com.tricon.evc.enums.Reservation;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name ="pricecomponent")
public class PriceComponent {



  @Id
  @Column(name = "id")
  private String id;
  
  @Column(name = "type")
  private PriceComponentType type;
  
  @Column(name = "price")
  private String price;
  
  @Column(name = "vat")
  private String vat;
  
  @Column(name = "step_size")
  private int stepSize;
  
  @ManyToOne
  @JoinColumn(name ="tariffelement_id",referencedColumnName = "id")
  private TariffElement tarrifElement;
}
