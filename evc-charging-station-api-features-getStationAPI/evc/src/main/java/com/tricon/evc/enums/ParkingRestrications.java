
package com.tricon.evc.enums;

/**
 * The Enum ParkingRestrications.
 */
public enum ParkingRestrications {

  /** Reserved parking spot for electric vehicles.. */
  EV_ONLY,

  /** Parking is only allowed while plugged in (charging). */
  PLUGGED,

  /** Reserved parking spot for disabled people with valid ID.. */
  DISABLED,

  /** Parking spot for customers/guests only,
   *  for example in case of a hotel or shop. */
  CUSTOMERS,

  /**Parking spot only suitable for (electric) motorcycles or scooters. */
  MOTORCYCLES;
}
