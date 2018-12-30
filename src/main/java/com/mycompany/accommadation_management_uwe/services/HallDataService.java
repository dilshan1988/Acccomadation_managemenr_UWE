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
import com.mycompany.accommadation_management_uwe.pojo.Hall;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HallDataService {

    FileWriter writer = null;
    BufferedReader br = null;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    HallDataWrapper hallDataServiceWrapper = new HallDataWrapper();
    String strJson;

//    String strJson = gson.toJson(hallDataServiceWrapper);
    public HallDataService() throws IOException {

        br = new BufferedReader(new FileReader("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/data/Hall.json"));
        hallDataServiceWrapper = gson.fromJson(br, HallDataWrapper.class);
//            writer.write(strJson);
    }

    public boolean addHall(Hall hall) throws UWEAccomException {

        if (hall != null) {
            if (!hallDataServiceWrapper.getHalls().isEmpty()) {

                for (Hall h : hallDataServiceWrapper.getHalls()) {
                    if (hall.getHallNumber() == h.getHallNumber()) {
                        throw (new UWEAccomException("data_exception", "Hall number exist!"));
                    }
                }
                if (hall.getHallName().equals("") || hall.getHallName().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Hall name canot be empity."));
                } else if (hall.getHallNumber().equals("") || hall.getHallNumber().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Hall number canot be empity."));
                } else if (hall.getNumberOfRooms().equals("") || hall.getNumberOfRooms().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Number of rooms canot be empity."));
                } else {
                    hallDataServiceWrapper.getHalls().add(hall);
                    strJson = gson.toJson(hallDataServiceWrapper);
                    return write(strJson);
                }

            } else {
                if (hall.getHallName().equals("") || hall.getHallName().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Hall name canot be empity."));
                } else if (hall.getHallNumber().equals("") || hall.getHallNumber().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Hall number canot be empity."));
                } else if (hall.getNumberOfRooms().equals("") || hall.getNumberOfRooms().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Number of rooms canot be empity."));
                } else {
                    hallDataServiceWrapper.getHalls().add(hall);
                    strJson = gson.toJson(hallDataServiceWrapper);
                    return write(strJson);
                }
            }
        } else {
            throw (new UWEAccomException("data_exception", "Hall canot be empity."));
        }

    }

    public boolean updateHall(int id, Hall hall) throws UWEAccomException {

        boolean isExist = false;
        if (hall != null) {
            if (!hallDataServiceWrapper.getHalls().isEmpty()) {

                for (Hall h : hallDataServiceWrapper.getHalls()) {
                    if (h.getHallNumber() == id) {
                        isExist = true;
                        if (hall.getHallName().equals("") || hall.getHallName().equals(" ")) {
                            throw (new UWEAccomException("data_exception", "Hall name canot be empity."));
                        } else if (hall.getHallNumber().equals("") || hall.getHallNumber().equals(" ")) {
                            throw (new UWEAccomException("data_exception", "Hall number canot be empity."));
                        } else if (hall.getNumberOfRooms().equals("") || hall.getNumberOfRooms().equals(" ")) {
                            throw (new UWEAccomException("data_exception", "Number of rooms canot be empity."));
                        } else {

                            for (Hall hl : hallDataServiceWrapper.getHalls()) {
                                if (id == hl.getHallNumber()) {
                                    throw (new UWEAccomException("data_exception", "Hall number exist."));
                                }
                            }

                            h.setHallNumber(hall.getHallNumber());
                            h.setHallName(hall.getHallName());
                            h.setNumberOfRooms(hall.getNumberOfRooms());
                            h.setWardenID(hall.getWardenID());
                            break;
                        }
                    }
                }
                if (isExist) {

                    //hallDataServiceWrapper.getHalls().add(hall);
                    strJson = gson.toJson(hallDataServiceWrapper);
                    return write(strJson);

                } else {
                    throw (new UWEAccomException("data_exception", "Hall does not exist."));
                }

            } else {
                if (hall.getHallName().equals("") || hall.getHallName().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Hall name canot be empity."));
                } else if (hall.getHallNumber().equals("") || hall.getHallNumber().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Hall number canot be empity."));
                } else if (hall.getNumberOfRooms().equals("") || hall.getNumberOfRooms().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Number of rooms canot be empity."));
                } else {
                    hallDataServiceWrapper.getHalls().add(hall);
                    strJson = gson.toJson(hallDataServiceWrapper);
                    return write(strJson);
                }
            }
        } else {
            throw (new UWEAccomException("data_exception", "Hall canot be empity."));
        }

    }

    public List<Hall> getHalls() {

//         hallDataServiceWrapper = gson.fromJson(br, HallDataWrapper.class);
        return hallDataServiceWrapper.getHalls();

    }

    public boolean deleteHall(int id) throws UWEAccomException {
        for (Hall h : getHalls()) {
            if (h.getHallNumber() == id) {
                getHalls().remove(h);
                strJson = gson.toJson(hallDataServiceWrapper);
                return write(strJson);

            }
        }
        throw (new UWEAccomException("data_exception", "Hall does not exist."));
    }
    
    public Hall getHall(int id) throws UWEAccomException{
        for(Hall h : getHalls()){
            if(id == h.getHallNumber()){
                return h;
            }
        }
        
        throw (new UWEAccomException("data_exception", "Hall does not exist."));
    }

    private boolean write(String strJson) {
        try {
            writer = new FileWriter("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/data/Hall.json");
            writer.write(strJson);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(HallDataService.class.getName()).log(Level.SEVERE, null, ex);
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
