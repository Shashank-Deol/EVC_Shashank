
package com.tricon.evc.enums;

/**
 * The Enum EvseCapabilites.
 */
public enum EvseCapabilites {

  /** The EVSE supports charging profiles. */
  CHARGING_PROFILE_CAPABLE,

  /** The EVSE supports charging preferences.. */
  CHARGING_PREFERENCES_CAPABLE,

  /**Charging at this EVSE can be payed with a credit card. */
  CREDIT_CARD_PAYBLE,

  /** Charging at this EVSE can be payed with a debit card. */
  DEBIT_CARD_PAYBLE,

  /** The EVSE can remotely be started/stopped. */
  REMOTE_START_STOP_CAPABLE,

  /** The EVSE can be reserved. */
  RESERVABLE,

  /** Charging at this EVSE can be authorized with a RFID token. */
  RFID_READER;

}
