package com.tricon.evc.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * Tariff Details to be displayed in the Charging Station Details Page.
 * @author yeshwanth.l
 *
 */
@Data
@Builder
public class TariffDeails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Member Details.
	 */
	private Tariff memberTariff;
	
	/**
	 * Non Member Details.
	 */
	private Tariff nonMemberTariff;
	
}
