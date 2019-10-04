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
"fk_evsc_uid",
"fk_location_id",
"url",
"thumbnail",
"category",
"type",
"width",
"height"
})
public class Image {

@JsonProperty("id")
private String id;
@JsonProperty("fk_evsc_uid")
private String fkEvscUid;
@JsonProperty("fk_location_id")
private String fkLocationId;
@JsonProperty("url")
private String url;
@JsonProperty("thumbnail")
private String thumbnail;
@JsonProperty("category")
private String category;
@JsonProperty("type")
private String type;
@JsonProperty("width")
private Integer width;
@JsonProperty("height")
private Integer height;
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

@JsonProperty("fk_evsc_uid")
public String getFkEvscUid() {
return fkEvscUid;
}

@JsonProperty("fk_evsc_uid")
public void setFkEvscUid(String fkEvscUid) {
this.fkEvscUid = fkEvscUid;
}

@JsonProperty("fk_location_id")
public String getFkLocationId() {
return fkLocationId;
}

@JsonProperty("fk_location_id")
public void setFkLocationId(String fkLocationId) {
this.fkLocationId = fkLocationId;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonProperty("thumbnail")
public String getThumbnail() {
return thumbnail;
}

@JsonProperty("thumbnail")
public void setThumbnail(String thumbnail) {
this.thumbnail = thumbnail;
}

@JsonProperty("category")
public String getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(String category) {
this.category = category;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("width")
public Integer getWidth() {
return width;
}

@JsonProperty("width")
public void setWidth(Integer width) {
this.width = width;
}

@JsonProperty("height")
public Integer getHeight() {
return height;
}

@JsonProperty("height")
public void setHeight(Integer height) {
this.height = height;
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
