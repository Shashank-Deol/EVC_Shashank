
package com.evc.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "standard",
    "format",
    "power_type",
    "voltage",
    "amperage",
    "tariff_id",
    "last_updated"
})
public class Connector {

    @JsonProperty("id")
    private String id;
    @JsonProperty("standard")
    private String standard;
    @JsonProperty("format")
    private String format;
    @JsonProperty("power_type")
    private String powerType;
    @JsonProperty("voltage")
    private Integer voltage;
    @JsonProperty("amperage")
    private Integer amperage;
    @JsonProperty("tariff_id")
    private String tariffId;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("standard")
    public String getStandard() {
        return standard;
    }

    @JsonProperty("standard")
    public void setStandard(String standard) {
        this.standard = standard;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("power_type")
    public String getPowerType() {
        return powerType;
    }

    @JsonProperty("power_type")
    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    @JsonProperty("voltage")
    public Integer getVoltage() {
        return voltage;
    }

    @JsonProperty("voltage")
    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    @JsonProperty("amperage")
    public Integer getAmperage() {
        return amperage;
    }

    @JsonProperty("amperage")
    public void setAmperage(Integer amperage) {
        this.amperage = amperage;
    }

    @JsonProperty("tariff_id")
    public String getTariffId() {
        return tariffId;
    }

    @JsonProperty("tariff_id")
    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

    @JsonProperty("last_updated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last_updated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
