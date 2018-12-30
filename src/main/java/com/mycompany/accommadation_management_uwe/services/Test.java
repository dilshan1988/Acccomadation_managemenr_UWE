/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.accommadation_management_uwe.pojo.Hall;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author dilshanjayatilake
 */
public class Test {

    public static void main(String[] args) {
        Hall hall1 = new Hall();
        hall1.setHallNumber(3);
        hall1.setHallName("hall 01");
        hall1.setNumberOfRooms(10);
        hall1.setWardenID(2);

        Hall hall2 = new Hall();
        hall2.setHallNumber(2);
        hall2.setHallName("hall 02");
        hall2.setNumberOfRooms(20);
        hall2.setWardenID(2);

        HallDataWrapper hallDataService = new HallDataWrapper();

        hallDataService.setHalls(Arrays.asList(hall1, hall2));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strJson = gson.toJson(hallDataService);

        FileWriter writer = null;
        BufferedReader br = null;
        try {
            writer = new FileWriter("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/services/javagen.json");
            writer.write(strJson);
            br = new BufferedReader(new FileReader("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/services/javagen.json"));
            hallDataService = gson.fromJson(br, HallDataWrapper.class);
            
            for(Hall h : hallDataService.getHalls()){
                System.out.println(">>");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
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
