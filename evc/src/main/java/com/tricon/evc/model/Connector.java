
package com.tricon.evc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "connector")
public class Connector {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name="standard")
    private String standard;
    @Column(name="format")
    private String format;
    @Column(name="power_type")
    private String powerType;	
    @Column(name="voltage")
    private Integer voltage;
    @Column(name="amperage")
    private Integer amperage;
    @Column(name="tariff_id")
    private String tariffId;
    @Column(name="max_electric_power")
    int maxElectricPower;
    @Column(name="terms_and_conditions")
    String termsAndConditions;
    @Column(name="last_updated")
    private String lastUpdated;
    @Column(name="evse_id")
    String evseId;
    
}
