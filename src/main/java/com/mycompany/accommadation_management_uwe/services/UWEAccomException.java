/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.services;

/**
 *
 * @author dilshanjayatilake
 */
public class UWEAccomException extends Exception{
    private String exceptionName;
    private String message;

    public UWEAccomException() {
    }

    public UWEAccomException(String exceptionName, String message) {   
        this.exceptionName = exceptionName;
        this.message = message;
    }
    
    

    public String getExceptionName() {
        return exceptionName;
    }

    public String getMessage() {
        return message;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
