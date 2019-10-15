
package com.tricon.evc.enums;

/**
 * The Enum ChargingStationType.
 */
public enum ChargingStationType {

  /**Parking in public space. */
  ON_STREET,

  /** Multistorey car park. */
  PARKING_GARAGE,

  /**Multistorey car park, mainly underground. */
  UNDERGROUND_GARAGE,

  /** A cleared area that is intended for parking vehicles,
   *  i.e. at super markets, bars, etc. */
  PARKING_LOT,

  /** None of the given possibilities.*/
  OTHER,

  /** Parking location type is not known by the operator (default). */
  UNKNOWN;
}
