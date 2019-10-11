package com.tricon.evc.model.dto;

import lombok.Data;

@Data
public class CoOrdinates {

Double latitude ;
Double logitude ;

public CoOrdinates(Double latitude,Double logitude)
{
	this.latitude = latitude;
	this.logitude = logitude;
}

}
