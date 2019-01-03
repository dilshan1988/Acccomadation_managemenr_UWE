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
    "workOrderID",
    "hallNumber",
    "roomNumber",
    "description",
    "status"
})

public class WorkOrder {

    @JsonProperty("workOrderID")
    private int workOrderID;
    @JsonProperty("hallNumber")
    private int hallNumber;
    @JsonProperty("roomNumber")
    private int roomNumber;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("status")
    private Object status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("workOrderID")
    public int getWorkOrderID() {
        return workOrderID;
    }

    @JsonProperty("workOrderID")
    public void setWorkOrderID(int workOrderID) {
        this.workOrderID = workOrderID;
    }

    @JsonProperty("hallNumber")
    public int getHallNumber() {
        return hallNumber;
    }

    @JsonProperty("hallNumber")
    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    @JsonProperty("roomNumber")
    public int getRoomNumber() {
        return roomNumber;
    }

    @JsonProperty("roomNumber")
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("status")
    public Object getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Object status) {
        this.status = status;
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
