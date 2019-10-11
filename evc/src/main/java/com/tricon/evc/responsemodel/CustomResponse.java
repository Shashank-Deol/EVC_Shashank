package com.tricon.evc.responsemodel;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponse {

	private Map<String,Object> metadata;
	
	private Object data;


}
