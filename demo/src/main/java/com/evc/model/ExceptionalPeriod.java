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
"period_begin",
"period_end"
})
public class ExceptionalPeriod {

@JsonProperty("id")
private Integer id;
@JsonProperty("period_begin")
private String periodBegin;
@JsonProperty("period_end")
private String periodEnd;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("period_begin")
public String getPeriodBegin() {
return periodBegin;
}

@JsonProperty("period_begin")
public void setPeriodBegin(String periodBegin) {
this.periodBegin = periodBegin;
}

@JsonProperty("period_end")
public String getPeriodEnd() {
return periodEnd;
}

@JsonProperty("period_end")
public void setPeriodEnd(String periodEnd) {
this.periodEnd = periodEnd;
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

