/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.services;

import com.mycompany.accommadation_management_uwe.pojo.Lease;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilshanjayatilake
 */
public class TestDriverLease {

    public static void main(String[] args) {
        try {
            LeaseDataService lease = new LeaseDataService();
            Lease ls = new Lease();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//            for (int i = 0; i <= 10; i++) {
//                Lease ls = new Lease();
//                ls.setLeaseNumber(i);
//                ls.setHallNumber(2 + i);
//                ls.setRoomNumber(1 + i);
//                ls.setRent((Double) 450.00);
//                ls.setEndDate(formatter.format(formatter.parse("01-DEC-2019")));
//                ls.setStartDate(formatter.format(formatter.parse("01-JAN-2019")));
//                ls.setSudentNumber(100);
//                lease.addLease(ls);
//
//            }

//            ls.setLeaseNumber(0);
//            ls.setHallNumber(2);
//            ls.setRoomNumber(1);
//            ls.setRent((Double) 490.00);
//            ls.setEndDate(formatter.format(formatter.parse("01-DEC-2019")));
//            ls.setStartDate(formatter.format(formatter.parse("01-JAN-2019")));
//            ls.setSudentNumber(100);
//            
//            lease.updateLease(0, ls);
            lease.deleteLease(8);
        } catch (IOException ex) {
            Logger.getLogger(TestDriverLease.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (ParseException ex) {
//            Logger.getLogger(TestDriverLease.class.getName()).log(Level.SEVERE, null, ex);
//        } 
        catch (UWEAccomException ex) {
            Logger.getLogger(TestDriverLease.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
