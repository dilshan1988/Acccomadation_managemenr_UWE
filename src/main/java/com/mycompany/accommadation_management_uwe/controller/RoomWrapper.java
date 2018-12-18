/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.controller;

/**
 *
 * @author dilshanjayatilake
 */

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rooms")
public class RoomWrapper {
    private List<Room> rooms;

    @XmlElement(name = "person")
    public List<Room> getPersons() {
        return rooms;
    }

    public void setPersons(List<Room> rooms) {
        this.rooms = rooms;
    }
}
