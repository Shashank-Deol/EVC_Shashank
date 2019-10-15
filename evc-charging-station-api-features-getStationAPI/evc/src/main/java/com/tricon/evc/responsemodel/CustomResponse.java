package com.tricon.evc.responsemodel;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

/**
 * this is used to send the response.
 */
@Data
@Builder
public class CustomResponse {

  /** The information about the data . */
  private Map<String, Object> metadata;

  /** The object which contains the data to sent. */
  private Object data;

}
