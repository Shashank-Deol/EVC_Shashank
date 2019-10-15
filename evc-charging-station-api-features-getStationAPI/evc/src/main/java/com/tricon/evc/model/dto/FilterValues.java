
package com.tricon.evc.model.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * The Class FilterValues.
 */
@Data
@Builder
public class FilterValues {

  /** The starting latitude. */
  private double startingLatitude;

  /** The starting longitude. */
  private double startingLongitude;

  /** The ending latitude (for journey). */
  private double endingLatitude;

  /** The ending latitude (for journey). */
  private double endingLongitude;

  /** The radius in which the charging stations are shown. */
  private int radius;

  /** The charger type preferd by the user. */
  private int chargerType;

  /** The list of company id's user prefer . */
  private List<String> companyIdList;

  /** The time at which the stations are searched. */
  private String timeStamp;

  /** The slot time. */
  private int timeRequired;
}
