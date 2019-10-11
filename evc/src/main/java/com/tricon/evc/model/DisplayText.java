package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "displaytext")
public class DisplayText {

  @Id
  @Column(name = "id")
  private String displayTextId;
  
  @Column(name = "language")
  private String displayTextLanguage;
  
  @Column(name = "text")
  private String text;
}
