package com.mycompany.accommadation_management_uwe.pojo;

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
    "hallNumber",
    "roomNumber",
    "roomStatus",
    "RoomCleanStatus"
})

public class Room {

    @JsonProperty("hallNumber")
    private Integer hallNumber;
    @JsonProperty("roomNumber")
    private Integer roomNumber;
    @JsonProperty("roomStatus")
    private Object roomStatus;
    @JsonProperty("RoomCleanStatus")
    private Object roomCleanStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hallNumber")
    public Integer getHallNumber() {
        return hallNumber;
    }

    @JsonProperty("hallNumber")
    public void setHallNumber(Integer hallNumber) {
        this.hallNumber = hallNumber;
    }

    @JsonProperty("roomNumber")
    public Integer getRoomNumber() {
        return roomNumber;
    }

    @JsonProperty("roomNumber")
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @JsonProperty("roomStatus")
    public Object getRoomStatus() {
        return roomStatus;
    }

    @JsonProperty("roomStatus")
    public void setRoomStatus(Object roomStatus) {
        this.roomStatus = roomStatus;
    }

    @JsonProperty("RoomCleanStatus")
    public Object getRoomCleanStatus() {
        return roomCleanStatus;
    }

    @JsonProperty("RoomCleanStatus")
    public void setRoomCleanStatus(Object roomCleanStatus) {
        this.roomCleanStatus = roomCleanStatus;
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
