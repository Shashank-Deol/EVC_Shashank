package com.evc.responsemodel;

import java.util.Map;

public class CustomResponse {

	private Map<String,Object> metadata;
	
	private Object data;
	
	@Override
	public String toString() {
		return "CustomResponse [metadata=" + metadata + ", data=" + data + "]";
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


}
