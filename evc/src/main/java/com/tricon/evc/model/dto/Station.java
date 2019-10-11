package com.tricon.evc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Station {
	
	String type;
	int id;
	Properties properties;
	Geometry geometry;
}
