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
    "roomNumber",
    "description",
    "hallNumber"
})

public class LoggedIssue {

    @JsonProperty("roomNumber")
    private int roomNumber;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("hallNumber")
    private int hallNumber;
    @JsonProperty("issueID")
    private int issueID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("hallNumber")
    public int getHallNumber() {
        return hallNumber;
    }

    @JsonProperty("hallNumber")
    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }
    
    @JsonProperty("issueID")
    public int getIssueID() {
        return issueID;
    }

    @JsonProperty("issueID")
    public void setIssueID(int issueID) {
        this.issueID = issueID;
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
