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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.mycompany.accommadation_management_uwe.pojo.Hall;
import com.mycompany.accommadation_management_uwe.pojo.Room;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomDataService {

    FileWriter writer = null;
    BufferedReader br = null;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    RoomDataWrapper roomDataServiceWrapper = new RoomDataWrapper();
    String strJson;
    List<Room> resultRooms;
    HallDataService hds = new HallDataService();

//    String strJson = gson.toJson(roomDataServiceWrapper);
    public RoomDataService() throws IOException {

        br = new BufferedReader(new FileReader("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/data/Room.json"));
        roomDataServiceWrapper = gson.fromJson(br, RoomDataWrapper.class);
//            writer.write(strJson);
    }

    public boolean addRoom(Room room) throws UWEAccomException {

        if (room != null) {
            if (!roomDataServiceWrapper.getRooms().isEmpty()) {
                if (!room.getHallNumber().equals(null) && !room.getRoomNumber().equals(null)) {
                    for (Room r : getRoomListByHall(room.getHallNumber())) {

                        if (room.getRoomNumber() == r.getRoomNumber()) {
                            throw (new UWEAccomException("data_exception", "Room number exist!"));
                        }
                    }
                    if (room.getHallNumber().equals("") || room.getHallNumber().equals(" ")) {
                        throw (new UWEAccomException("data_exception", "Hall name cannot be empity."));
                    } else if (room.getRoomCleanStatus().equals(null)) {
                        throw (new UWEAccomException("data_exception", "Room clean - status cannot be empity."));
                    } else if (room.getRoomStatus().equals(null)) {
                        throw (new UWEAccomException("data_exception", "Room status canot be empity."));
                    } else if(!hds.getHall(room.getHallNumber()).equals(null)){
                        roomDataServiceWrapper.getRooms().add(room);
                        strJson = gson.toJson(roomDataServiceWrapper);
                        return write(strJson);
                    }else{
                        throw (new UWEAccomException("data_exception", "Hall does not exist."));
                    }
                } else {
                    throw (new UWEAccomException("data_exception", "Room Number and Hall Number cannot be empity"));
                }
            } else {
                if (room.getHallNumber().equals("") || room.getHallNumber().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Hall name cannot be empity."));
                } else if (room.getRoomCleanStatus().equals(null)) {
                    throw (new UWEAccomException("data_exception", "Room clean - status cannot be empity."));
                } else if (room.getRoomStatus().equals(null)) {
                    throw (new UWEAccomException("data_exception", "Room status canot be empity."));
                } else {
                    roomDataServiceWrapper.getRooms().add(room);
                    strJson = gson.toJson(roomDataServiceWrapper);
                    return write(strJson);
                }
            }
        } else {
            throw (new UWEAccomException("data_exception", "Hall or Room number cannot be empity."));
        }

    }

    public List<Room> getRoomListByHall(int hallNumber) {

        resultRooms = new ArrayList<>();

        for (Room r : roomDataServiceWrapper.getRooms()) {
            if (r.getHallNumber() == hallNumber) {
                resultRooms.add(r);
            }
        }

        return resultRooms;
    }

    public boolean updateRoom(int roomNumber, int hallNumber, Room room) throws UWEAccomException {

        boolean isExist = false;
        if (room != null) {

            for (Room r : getRoomListByHall(hallNumber)) {
                if (r.getRoomNumber() == roomNumber) {
                    isExist = true;
                    r.setHallNumber(room.getHallNumber());
                    r.setRoomNumber(room.getRoomNumber());
                    r.setRoomCleanStatus(room.getRoomCleanStatus());
                    r.setRoomStatus(room.getRoomStatus());
                }
            }

            if (isExist) {

                //hallDataServiceWrapper.getRooms().add(hall);
                strJson = gson.toJson(roomDataServiceWrapper);
                return write(strJson);

            } else {
                throw (new UWEAccomException("data_exception", "Room does not exist."));
            }

        } else {
            throw (new UWEAccomException("data_exception", "Room cannot be empity."));
        }

    }

    public List<Room> getRooms() {

//         roomDataServiceWrapper = gson.fromJson(br, HallDataWrapper.class);
        return roomDataServiceWrapper.getRooms();

    }

    public boolean deleteRoom(int roomNumber, int hallNumber) throws UWEAccomException {
        for (Room r : getRoomListByHall(hallNumber)) {
            if (r.getRoomNumber() == roomNumber) {
                getRooms().remove(r);
                strJson = gson.toJson(roomDataServiceWrapper);
                return write(strJson);

            }
        }
        throw (new UWEAccomException("data_exception", "Room does not exist."));
    }

    public Room getRoom(int roomNumber, int hallNumber) throws UWEAccomException {
        for (Room r : getRoomListByHall(hallNumber)) {
            if (roomNumber == r.getRoomNumber()) {
                return r;
            }
        }

        throw (new UWEAccomException("data_exception", "Hall does not exist."));
    }

    private boolean write(String strJson) {
        try {
            writer = new FileWriter("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/data/Room.json");
            writer.write(strJson);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(RoomDataService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
