/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.services;

import com.mycompany.accommadation_management_uwe.pojo.Room;
import com.mycompany.accommadation_management_uwe.pojo.RoomCleanStatus;
import com.mycompany.accommadation_management_uwe.pojo.RoomStatus;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilshanjayatilake
 */
public class TestDriverRooms {

    public static void main(String[] args) {
        try {
            RoomDataService rds = new RoomDataService();
//            for (int i = 0; i <= 10; i++) {
//                Room room = new Room();
//                room.setHallNumber(i + 1);
//                room.setRoomNumber(i);
//                room.setRoomCleanStatus(RoomCleanStatus.clean);
//                room.setRoomStatus(RoomStatus.unoccupied);
//                rds.addRoom(room);
//            }
//            Room room = new Room();
//            room.setHallNumber(0);
//            room.setRoomNumber(1);
//            room.setRoomCleanStatus(RoomCleanStatus.dirty);
//            room.setRoomStatus(RoomStatus.unoccupied);
//            rds.updateRoom(0, 1, room);

//            rds.deleteRoom(1, 0);
            rds.getRooms();

        } catch (IOException ex) {
            Logger.getLogger(TestDriverRooms.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (UWEAccomException ex) {
//            Logger.getLogger(TestDriverRooms.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}
