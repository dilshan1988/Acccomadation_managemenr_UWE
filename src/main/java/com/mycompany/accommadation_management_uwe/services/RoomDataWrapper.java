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
import com.mycompany.accommadation_management_uwe.pojo.Room;

@Generated("org.jsonschema2pojo")
public class RoomDataWrapper {
   @SerializedName("Rooms")
 @Expose
 private List<Room> rooms = new ArrayList<Room>(); 
   /**
 *
 * @return The Halls
 */
 public List<Room> getRooms() {
  return rooms;
 }
/**
 *
 * @param todos
 * The Halls
 */
 public void setRooms(List<Room> rooms) {
  this.rooms = rooms;
 }
}
