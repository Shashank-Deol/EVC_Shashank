
package com.tricon.evc.enums;

/**
 * The Enum PriceComponentType.
 */
public enum PriceComponentType {

  /** defined in kWh, default step_size is 1 Wh. */
  ENERGY,

  /** flat fee, no unit. */
  FLAT,

  /** time not charging: defined in hours, default step_size is 1 second.*/
  PARKING_TIME,

  /** time charging: defined in hours, default step_size is 1 second. */
  TIME,

}
