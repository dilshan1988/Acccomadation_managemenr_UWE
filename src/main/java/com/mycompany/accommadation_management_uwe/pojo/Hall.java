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
"hallName",
"numberOfRooms",
"wardenID"
})

public class Hall {
    
    
@JsonProperty("hallNumber")
private Integer hallNumber;
@JsonProperty("hallName")
private Object hallName;
@JsonProperty("numberOfRooms")
private Integer numberOfRooms;
@JsonProperty("wardenID")
private Integer wardenID;
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

@JsonProperty("hallName")
public Object getHallName() {
return hallName;
}

@JsonProperty("hallName")
public void setHallName(Object hallName) {
this.hallName = hallName;
}

@JsonProperty("numberOfRooms")
public Integer getNumberOfRooms() {
return numberOfRooms;
}

@JsonProperty("numberOfRooms")
public void setNumberOfRooms(Integer numberOfRooms) {
this.numberOfRooms = numberOfRooms;
}

@JsonProperty("wardenID")
public Integer getWardenID() {
return wardenID;
}

@JsonProperty("wardenID")
public void setWardenID(Integer wardenID) {
this.wardenID = wardenID;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

//	private int hallNumber;
//
//	private String hallName;
//
//	private int numberOfRooms;
//
//	private int wardenID;
//
//	public int getHallNumber() {
//		return 0;
//	}
//
//	public String getHallName() {
//		return null;
//	}
//
//	public int getNumberOfRooms() {
//		return 0;
//	}
//
//	public int getWardenID() {
//		return 0;
//	}
//
//	public void setHallNumber(int hallNumber) {
//
//	}
//
//	public void setHallName(String hallName) {
//
//	}
//
//	public void setNumberOfRooms(int numberOfRooms) {
//
//	}
//
//	public void setWardenID(int wardenID) {
//
//	}

}
