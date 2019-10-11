package com.tricon.evc.responsemodel;

import java.util.ArrayList;

import java.util.List;

import com.tricon.evc.model.dto.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class Stations {

	String type;
	List<Station> features = new ArrayList<Station>();
	
	
}
