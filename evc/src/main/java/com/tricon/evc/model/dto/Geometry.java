package com.tricon.evc.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Geometry {

	String type;
	List<Double> coordinates;

}
