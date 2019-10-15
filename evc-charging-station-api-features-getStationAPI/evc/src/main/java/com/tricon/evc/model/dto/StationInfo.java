package com.tricon.evc.model.dto;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * Station INfo to be displayed in the Charging Details Page.
 *
 */

@Data
@Builder
public class StationInfo implements Serializable {

  /**The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Charging Station Name.
   */
  private String name;

  /**
   * Charging Station Details.
   */
  private String address;

}
