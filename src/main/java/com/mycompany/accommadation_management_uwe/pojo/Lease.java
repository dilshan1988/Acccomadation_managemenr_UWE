package com.mycompany.accommadation_management_uwe.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Lease {

    @JsonProperty("leaseNumber")
    private Integer leaseNumber;
    @JsonProperty("startDate")
    private Object startDate;
    @JsonProperty("endDate")
    private Object endDate;
    @JsonProperty("rent")
    private Object rent;
    @JsonProperty("hallNumber")
    private Integer hallNumber;
    @JsonProperty("roomNumber")
    private Integer roomNumber;
    @JsonProperty("sudentNumber")
    private Object sudentNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("leaseNumber")
    public Integer getLeaseNumber() {
        return leaseNumber;
    }

    @JsonProperty("leaseNumber")
    public void setLeaseNumber(Integer leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    @JsonProperty("startDate")
    public Object getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public Object getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("rent")
    public Object getRent() {
        return rent;
    }

    @JsonProperty("rent")
    public void setRent(Object rent) {
        this.rent = rent;
    }

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

    @JsonProperty("sudentNumber")
    public Object getStudentNumber() {
        return sudentNumber;
    }

    @JsonProperty("sudentNumber")
    public void setSudentNumber(Object sudentNumber) {
        this.sudentNumber = sudentNumber;
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
