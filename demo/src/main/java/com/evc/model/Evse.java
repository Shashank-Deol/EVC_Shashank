
package com.evc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uid",
    "evse_id",
    "status",
    "status_schedule",
    "capabilities",
    "connectors",
    "physical_reference",
    "floor_level",
    "last_updated"
})
public class Evse {

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("evse_id")
    private String evseId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_schedule")
    private List<Object> statusSchedule = null;
    @JsonProperty("capabilities")
    private List<String> capabilities = null;
    @JsonProperty("connectors")
    private List<Connector> connectors = null;
    @JsonProperty("physical_reference")
    private String physicalReference;
    @JsonProperty("floor_level")
    private String floorLevel;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("evse_id")
    public String getEvseId() {
        return evseId;
    }

    @JsonProperty("evse_id")
    public void setEvseId(String evseId) {
        this.evseId = evseId;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("status_schedule")
    public List<Object> getStatusSchedule() {
        return statusSchedule;
    }

    @JsonProperty("status_schedule")
    public void setStatusSchedule(List<Object> statusSchedule) {
        this.statusSchedule = statusSchedule;
    }

    @JsonProperty("capabilities")
    public List<String> getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("connectors")
    public List<Connector> getConnectors() {
        return connectors;
    }

    @JsonProperty("connectors")
    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }

    @JsonProperty("physical_reference")
    public String getPhysicalReference() {
        return physicalReference;
    }

    @JsonProperty("physical_reference")
    public void setPhysicalReference(String physicalReference) {
        this.physicalReference = physicalReference;
    }

    @JsonProperty("floor_level")
    public String getFloorLevel() {
        return floorLevel;
    }

    @JsonProperty("floor_level")
    public void setFloorLevel(String floorLevel) {
        this.floorLevel = floorLevel;
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
