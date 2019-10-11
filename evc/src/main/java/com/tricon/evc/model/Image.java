package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tricon.evc.enums.ImageCatagory;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "image")
public class Image {

  @Id
  @Column(name = "id")
  private String id;
  
  
  @Column(name = "image_evse_uid")
  private String evseUid;
 
  
  @Column(name = "image_station_id")
  private String stationId;
  
  @Column(name = "url")
  private String url;
  
  @Column(name = "thumbnail")
  private String thumbnail;
  
  @Column(name = "category")
  private ImageCatagory category;
  
  @Column(name = "type")
  private String type;
  
  @Column(name = "width")
  private int width;
  
  @Column(name = "height")
  private int height;
}
