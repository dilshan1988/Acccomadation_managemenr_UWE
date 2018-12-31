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
import com.mycompany.accommadation_management_uwe.pojo.Lease;

@Generated("org.jsonschema2pojo")
public class LeaseDataWrapper {
   @SerializedName("Lease")
 @Expose
 private List<Lease> leases = new ArrayList<Lease>(); 
   /**
 *
 * @return The Halls
 */
 public List<Lease> getLeases() {
  return leases;
 }
/**
 *
 * @param leases
 * The Halls
 */
 public void setLeases(List<Lease> leases) {
  this.leases = leases;
 }
}
