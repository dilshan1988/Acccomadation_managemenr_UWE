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

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mycompany.accommadation_management_uwe.pojo.Hall;

@Generated("org.jsonschema2pojo")
public class HallDataWrapper {
   @SerializedName("Halls")
 @Expose
 private List<Hall> halls = new ArrayList<Hall>(); 
   /**
 *
 * @return The Halls
 */
 public List<Hall> getHalls() {
  return halls;
 }
/**
 *
 * @param todos
 * The Halls
 */
 public void setHalls(List<Hall> todos) {
  this.halls = todos;
 }
}
