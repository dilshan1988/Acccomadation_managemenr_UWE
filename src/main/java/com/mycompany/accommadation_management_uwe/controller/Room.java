package com.mycompany.accommadation_management_uwe.controller;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "room")

@XmlType(propOrder = {"hallNumber", "roomNumber", "roomStatus", "roomCleaningStatus"})

public class Room {

    private int hallNumber;

    private int roomNumber;

    private RoomStatus roomStatus = RoomStatus.unoccupied;

    private RoomCleanStatus roomCleaningStatus = RoomCleanStatus.clean;

    public int getHallNumber() {
        return 0;
    }

    public int getRoomNumber() {
        return 0;
    }

    public RoomStatus getRoomStatus() {
        return null;
    }

    public RoomCleanStatus getRoomCleanStatus() {
        return null;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;

    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;

    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setRoomCleanStatus(RoomCleanStatus roomCleanStatus) {
        this.roomCleaningStatus = roomCleanStatus;
    }

}
