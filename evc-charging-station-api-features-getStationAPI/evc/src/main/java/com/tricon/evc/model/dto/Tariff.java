package com.tricon.evc.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * Tariff Amount.
 */

@Data
@Builder
public class Tariff implements Serializable {

  /**
   * Default Version.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Unit Details.
   */
  private String unit;

  /**
   * Amount Per Units.
   */
  private double amount;

}
