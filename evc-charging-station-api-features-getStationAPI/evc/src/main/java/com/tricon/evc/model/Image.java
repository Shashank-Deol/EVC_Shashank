package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.tricon.evc.enums.ImageCatagory;
import lombok.Data;
/**
 * The Class Image.
 */
@Entity
@Data
@Table(name = "image")
public class Image {

  /** The id. */
  @Id
  @Column(name = "id")
  private String id;

  /** The evse uid to which the image belongs to . */
  @Column(name = "image_evse_uid")
  private String evseUid;

  /** The station id to which image belongs to. */
  @Column(name = "image_station_id")
  private String stationId;

  /** The url of the image. */
  @Column(name = "url")
  private String url;

  /** URL from where a thumbnail of the image can be
   * fetched through a webbrowser. */
  @Column(name = "thumbnail")
  private String thumbnail;

  /** Describes what the image is used for. */
  @Column(name = "category")
  private ImageCatagory category;

  /** Image type like: gif, jpeg, png, svg. */
  @Column(name = "type")
  private String type;

  /** The Width of the full scale image. */
  @Column(name = "width")
  private int width;

  /** The Height of the full scale image. */
  @Column(name = "height")
  private int height;
}
