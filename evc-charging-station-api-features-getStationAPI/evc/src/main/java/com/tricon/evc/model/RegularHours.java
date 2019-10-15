package com.tricon.evc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * The Class RegularHours.
 */
@Entity
@Data

@Table(name = "regularhours")
public class RegularHours {

    /**
     * The id.
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * The Number of day in the week, from Monday (1) till Sunday (7).
     */
    @Column(name = "weekday")
    private int weekday;

    /**
     * The Begin of the regular period given in hours and minutes.
     * Must be in 24h format
     * with leading zeros..
     */
    @Column(name = "period_begin")
    private String periodBegin;

}