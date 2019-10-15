package com.tricon.evc.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * properties defined by mapbox.
 */
@Data
@Builder
public class Properties {

  /** The icon constatnt defined by mapbox. */
  private String icon;

}
