
package com.tricon.evc.enums;

/**
 * this is the enum file for the tarrif type.
 *
 * @author yeshwanth.l
 */
public enum TarrifType {

  /** This tariff is valid when ad hoc payment is used
   * at the Charge Point. Instead of an RFID token or APP.. */
  AD_HOC_PAYMENT,

  /** This tariff is valid when Charging Preference:
   *  CHEAP is set on the session. */
  PROFILE_CHEAP,

  /** This tariff is valid when Charging Preference:
   * FAST is set on the session. */
  PROFILE_FAST,

  /** This tariff is valid when Charging Preference:
   * GREEN is set on the session. */
  PROFILE_GREEN,

  /** This is the tariff when using an RFID, without any Charging Preference,
   * or when Charging
   * Preference: REGULAR is set on the session.. */
  REGULAR;

}
