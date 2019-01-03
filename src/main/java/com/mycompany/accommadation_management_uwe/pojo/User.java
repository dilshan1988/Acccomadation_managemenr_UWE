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
    "userID",
    "userName",
    "userLevel",
    "email",
    "contactNumber",
    "address",
    "password"
})

public class User {

    @JsonProperty("userID")
    private Object userID;
    @JsonProperty("userName")
    private Object userName;
    @JsonProperty("userLevel")
    private Integer userLevel;
    @JsonProperty("email")
    private Object email;
    @JsonProperty("contactNumber")
    private Object contactNumber;
    @JsonProperty("address")
    private Object address;
    @JsonProperty("password")
    private Object password;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userID")
    public Object getUserID() {
        return userID;
    }

    @JsonProperty("userID")
    public void setUserID(Object userID) {
        this.userID = userID;
    }

    @JsonProperty("userName")
    public Object getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(Object userName) {
        this.userName = userName;
    }

    @JsonProperty("userLevel")
    public int getUserLevel() {
        return userLevel;
    }

    @JsonProperty("userLevel")
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    @JsonProperty("email")
    public Object getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(Object email) {
        this.email = email;
    }

    @JsonProperty("contactNumber")
    public Object getContactNumber() {
        return contactNumber;
    }

    @JsonProperty("contactNumber")
    public void setContactNumber(Object contactNumber) {
        this.contactNumber = contactNumber;
    }

    @JsonProperty("address")
    public Object getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Object address) {
        this.address = address;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    @JsonProperty("password")
    public Object getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(Object password) {
        this.password = password;
    }

}
