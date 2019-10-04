package com.evc.model.dto;

import java.io.Serializable;

/**
 * Tariff Details to be displayed in the Charging Station Details Page.
 * @author yeshwanth.l
 *
 */
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

	/**
	 * Get Member Tariff.
	 * @return
	 */
	public Tariff getMembers() {
		return memberTariff;
	}

	/**
	 * Set Member Tariff.
	 * @param members
	 */
	public void setMembers(Tariff members) {
		this.memberTariff = members;
	}

	/**
	 * Get NOn Member Tariff.
	 * @return
	 */
	public Tariff getNonMembers() {
		return nonMemberTariff;
	}

	/**
	 * Set Tariff Details.
	 * @param nonMembers
	 */
	public void setNonMembers(Tariff nonMembers) {
		this.nonMemberTariff = nonMembers;
	}
	
	
	
}
