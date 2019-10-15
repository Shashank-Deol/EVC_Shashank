
package com.tricon.evc.model.dto;

import lombok.Data;

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
public class CoOrdinates {

    /**
     * this is.
     */
    private final double latitude;

    /**
     * The logitude.
     */
    private final double logitude;

    /**
     * Instantiates a new co ordinates.
     *
     * @param latitude the latitude.
     * @param logitude the logitude.
     */
    public CoOrdinates(final double latitude, final double logitude) {
        this.latitude = latitude;
        this.logitude = logitude;
    }

}
