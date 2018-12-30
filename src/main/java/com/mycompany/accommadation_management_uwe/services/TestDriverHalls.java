/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.services;

import com.mycompany.accommadation_management_uwe.pojo.Hall;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilshanjayatilake
 */
public class TestDriverHalls {

    public static void main(String[] args) {
        try {
            for(int i=1 ; i<=10; i++){
            HallDataService hallD = new HallDataService();
            Hall hall1 = new Hall();
            hall1.setHallNumber(i);
            hall1.setHallName("hall 0"+i);
            hall1.setNumberOfRooms(200+i);
            hall1.setWardenID(5);
            
            hallD.addHall(hall1);
            }
            //hallD.deleteHall(5);
            
//            System.out.println(">> " + (hallD.getHall(3)).getHallName());
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(TestDriverHalls.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UWEAccomException ex) {
            Logger.getLogger(TestDriverHalls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
