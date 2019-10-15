
package com.tricon.evc.enums;

/**
 * The Enum Capabilities.
 */
public enum Capabilities {

  /** The EVSE supports charging profiles. */
  CHARGING_PROFILE_CAPABLE,

  /** The EVSE supports charging preferences. */
  CHARGING_PREFERENCES_CAPABLE,

  /**Charging at this EVSE can be payed with a credit card. */
  CREDIT_CARD_PAYABLE,

  /** Charging at this EVSE can be payed with a debit card. */
  DEBIT_CARD_PAYABLE,

  /** The EVSE can remotely be started/stopped. */
  REMOTE_START_STOP_CAPABLE,

  /** TThe EVSE can be reserved. */
  RESERVABLE,

  /**Charging at this EVSE can be authorized with a RFID token. */
  RFID_READER,

  /** This EVSE supports token groups. */
  TOKEN_GROUP_CAPABLE,

  /**Connectors have mechanical lock that can be
   *  requested by the eMSP to be unlocked. */
  UNLOCK_CAPABLE;

}
