
package com.tricon.evc.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * DisplayText.
 */
@Entity
@Data
@Table(name = "displaytext")
public class DisplayText {

  /** The display text id. */
  @Id
  @Column(name = "id")
  private String displayTextId;

  /** The display text language. */
  @Column(name = "language")
  private String displayTextLanguage;

  /**  data . */
  @Column(name = "text")
  private String text;
}
