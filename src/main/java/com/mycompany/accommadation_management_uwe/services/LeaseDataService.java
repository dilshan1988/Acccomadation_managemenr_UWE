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
import com.mycompany.accommadation_management_uwe.pojo.Lease;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeaseDataService {

    FileWriter writer = null;
    BufferedReader br = null;
    FileWriter writerEx = null;
    BufferedReader brEx = null;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    LeaseDataWrapper leaseDataServiceWrapper = new LeaseDataWrapper();
    LeaseDataWrapper leaseDataServiceWrapperEx = new LeaseDataWrapper();
    String strJson;
    HallDataService hds = new HallDataService();
    RoomDataService rds = new RoomDataService();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

//    String strJson = gson.toJson(leaseDataServiceWrapper);
    public LeaseDataService() throws IOException {

        br = new BufferedReader(new FileReader("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/data/ActiveLease.json"));
        leaseDataServiceWrapper = gson.fromJson(br, LeaseDataWrapper.class);
        brEx = new BufferedReader(new FileReader("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/data/ExpieredLease.json"));
        leaseDataServiceWrapperEx = gson.fromJson(brEx, LeaseDataWrapper.class);

//            writer.write(strJson);
    }

    public boolean addLease(Lease lease) throws UWEAccomException {

        if (lease != null) {
            if (!leaseDataServiceWrapper.getLeases().isEmpty()) {

                for (Lease h : leaseDataServiceWrapper.getLeases()) {
                    if (lease.getLeaseNumber() == h.getLeaseNumber()) {
                        throw (new UWEAccomException("data_exception", "Lease already exist!"));
                    }
                }
                if (lease.getHallNumber() == null) {
                    throw (new UWEAccomException("data_exception", "Hall numer canot be empity."));
                } else if (lease.getRoomNumber() == null) {
                    throw (new UWEAccomException("data_exception", "Room number canot be empity."));
                } else if (lease.getRent() == null) {
                    throw (new UWEAccomException("data_exception", "Rent canot be empity."));
                } else if (lease.getStartDate() == null) {
                    throw (new UWEAccomException("data_exception", "Start date canot be empity."));
                } else if (lease.getEndDate().equals("")) {
                    throw (new UWEAccomException("data_exception", "End date canot be empity."));
                } else if (lease.getStudentNumber() == null || lease.getStudentNumber().equals("") || lease.getStudentNumber().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Student number canot be empity."));
                } else if (lease.getLeaseNumber() == null) {
                    throw (new UWEAccomException("data_exception", "Lease number canot be empity."));
                } else {

                    try {
                        if (validation(lease)) {
                            leaseDataServiceWrapper.getLeases().add(lease);
                            strJson = gson.toJson(leaseDataServiceWrapper);
                            return write(strJson);
                        } else {
                            throw (new UWEAccomException("data_exception", "Active Lease exsist."));
                        }
                    } catch (UWEAccomException e) {
                        throw (new UWEAccomException("data_exception", "Creating lease failed. " + e.getMessage()));
                    }
                }

            } else {
                if (lease.getHallNumber() == null) {
                    throw (new UWEAccomException("data_exception", "Hall numer canot be empity."));
                } else if (lease.getRoomNumber() == null) {
                    throw (new UWEAccomException("data_exception", "Room number canot be empity."));
                } else if (lease.getRent() == null) {
                    throw (new UWEAccomException("data_exception", "Rent canot be empity."));
                } else if (lease.getStartDate() == null) {
                    throw (new UWEAccomException("data_exception", "Start date canot be empity."));
                } else if (lease.getEndDate().equals("")) {
                    throw (new UWEAccomException("data_exception", "End date canot be empity."));
                } else if (lease.getStudentNumber() == null || lease.getStudentNumber().equals("") || lease.getStudentNumber().equals(" ")) {
                    throw (new UWEAccomException("data_exception", "Student number canot be empity."));
                } else if (lease.getLeaseNumber() == null) {
                    throw (new UWEAccomException("data_exception", "Lease number canot be empity."));
                } else {

                    //getLeaseByRoom(lease.getRoomNumber(), lease.getHallNumber());
                    leaseDataServiceWrapper.getLeases().add(lease);
                    strJson = gson.toJson(leaseDataServiceWrapper);
                    return write(strJson);

                }
            }
        } else {
            throw (new UWEAccomException("data_exception", "Hall canot be empity."));
        }

    }

    public boolean update_Lease(int leaseNumber, Lease lease) throws UWEAccomException, ParseException {

        boolean isExist = false;
        if (lease != null) {
            if (!leaseDataServiceWrapper.getLeases().isEmpty()) {

                for (Lease l : leaseDataServiceWrapper.getLeases()) {
                    if (l.getLeaseNumber() == leaseNumber) {
                        isExist = true;
                        if (lease.getHallNumber() == null) {
                            throw (new UWEAccomException("data_exception", "Hall numer canot be empity."));
                        } else if (lease.getRoomNumber() == null) {
                            throw (new UWEAccomException("data_exception", "Room number canot be empity."));
                        } else if (lease.getRent() == null) {
                            throw (new UWEAccomException("data_exception", "Rent canot be empity."));
                        } else if (lease.getStartDate() == null) {
                            throw (new UWEAccomException("data_exception", "Start date canot be empity."));
                        } else if (lease.getEndDate().equals("")) {
                            throw (new UWEAccomException("data_exception", "End date canot be empity."));
                        } else if (lease.getStudentNumber().equals("") || lease.getStudentNumber().equals(" ")) {
                            throw (new UWEAccomException("data_exception", "Student number canot be empity."));
                        } else if (lease.getLeaseNumber() == null) {
                            throw (new UWEAccomException("data_exception", "Lease number canot be empity."));
                        } else {

                            for (Lease ls : leaseDataServiceWrapper.getLeases()) {

                                Date exStartDate = formatter.parse(ls.getStartDate().toString());

                                if (leaseNumber == ls.getLeaseNumber() && leaseNumber != lease.getLeaseNumber()) {
                                    throw (new UWEAccomException("data_exception", "Lease already number exist."));
                                } else if (overlap((Date) formatter.parse(ls.getStartDate().toString()), formatter.parse(ls.getEndDate().toString()), (Date) formatter.parse(lease.getStartDate().toString()), (Date) formatter.parse(lease.getEndDate().toString()))) {
                                    if (ls.getRoomNumber() == lease.getRoomNumber() && ls.getHallNumber() == lease.getHallNumber()) {
                                        throw (new UWEAccomException("data_exception", "Active lease exist."));
                                    }
                                }
                            }

                            l.setEndDate((Date) lease.getEndDate());
                            l.setHallNumber(lease.getHallNumber());
                            l.setLeaseNumber(lease.getLeaseNumber());
                            l.setRent(lease.getRent());
                            l.setRoomNumber(lease.getRoomNumber());
                            l.setStartDate((Date) lease.getStartDate());
                            l.setSudentNumber(lease.getStudentNumber());

                            break;
                        }
                    }
                }
                if (isExist) {

                    //hallDataServiceWrapper.getHalls().add(hall);
                    strJson = gson.toJson(leaseDataServiceWrapper);
                    return write(strJson);

                } else {
                    throw (new UWEAccomException("data_exception", "Hall does not exist."));
                }

            } else {
                throw (new UWEAccomException("data_exception", "No lease avilable for update."));
            }
        } else {
            throw (new UWEAccomException("data_exception", "Lease canot be empity."));
        }

    }

    public boolean updateLease(int leaseNumber, Lease lease) throws UWEAccomException, ParseException {
        boolean isUpdated = false;
        Lease lease_ = getLease(leaseNumber);
        if (lease.getHallNumber() == null) {
            throw (new UWEAccomException("data_exception", "Hall numer canot be empity."));
        } else if (lease.getRoomNumber() == null) {
            throw (new UWEAccomException("data_exception", "Room number canot be empity."));
        } else if (lease.getRent() == null) {
            throw (new UWEAccomException("data_exception", "Rent canot be empity."));
        } else if (lease.getStartDate() == null) {
            throw (new UWEAccomException("data_exception", "Start date canot be empity."));
        } else if (lease.getEndDate().equals("")) {
            throw (new UWEAccomException("data_exception", "End date canot be empity."));
        } else if (lease.getStudentNumber().equals("") || lease.getStudentNumber().equals(" ")) {
            throw (new UWEAccomException("data_exception", "Student number canot be empity."));
        } else if (lease.getLeaseNumber() == null) {
            throw (new UWEAccomException("data_exception", "Lease number canot be empity."));
        } else if (lease_.getRoomNumber() != lease.getRoomNumber() && lease_.getHallNumber() != lease.getHallNumber()) {

            throw (new UWEAccomException("rule_exception", "Cancel the exsisting lease and create a new lease."));
        } else {
            for (Lease ls : leaseDataServiceWrapper.getLeases()) {

                if (lease.getLeaseNumber() == ls.getLeaseNumber()) {
                    lease_.setEndDate(formatter.format(((Date) formatter.parse(lease.getEndDate().toString()))));
                    lease_.setHallNumber(lease.getHallNumber());
                    lease_.setLeaseNumber(lease.getLeaseNumber());
                    lease_.setRent(lease.getRent());
                    lease_.setRoomNumber(lease.getRoomNumber());
                    lease_.setStartDate(formatter.format(((Date) formatter.parse(lease.getStartDate().toString()))));
                    lease_.setSudentNumber(lease.getStudentNumber());
                    leaseDataServiceWrapper.getLeases().remove(ls);
                    break;

                }
            }

            leaseDataServiceWrapper.getLeases().add(lease_);
            strJson = gson.toJson(leaseDataServiceWrapper);
            isUpdated = write(strJson);

        }
        return isUpdated;
    }

    private boolean overlap(Date start1, Date end1, Date start2, Date end2) {
        return start1.getTime() <= end2.getTime() && start2.getTime() <= end1.getTime();
    }

    public List<Lease> getLeasess() {

//         leaseDataServiceWrapper = gson.fromJson(br, HallDataWrapper.class);
        return leaseDataServiceWrapper.getLeases();

    }

    public boolean deleteLease(int id) throws UWEAccomException {
        for (Lease ls : leaseDataServiceWrapper.getLeases()) {
            if (ls.getLeaseNumber()== id) {
                leaseDataServiceWrapper.getLeases().remove(ls);
                strJson = gson.toJson(leaseDataServiceWrapper);
                return write(strJson);
            }
        }
        throw (new UWEAccomException("data_exception", "Lease does not exist."));
    }

    public Lease getLease(int id) throws UWEAccomException {
        for (Lease ls : leaseDataServiceWrapper.getLeases()) {
            if (id == ls.getLeaseNumber()) {
                return ls;
            }
        }

        throw (new UWEAccomException("data_exception", "Lease does not exist."));
    }

    public Lease getLeaseByRoom(int roomNumber, int hallNumber) throws UWEAccomException {
        for (Lease ls : leaseDataServiceWrapper.getLeases()) {
            if (roomNumber == ls.getRoomNumber() && hallNumber == ls.getHallNumber()) {
                return ls;
            }
        }

        throw (new UWEAccomException("data_exception", "Lease does not exist."));
    }

    private boolean write(String strJson) {
        try {
            writer = new FileWriter("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/data/ActiveLease.json");
            writer.write(strJson);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(LeaseDataService.class.getName()).log(Level.SEVERE, null, ex);
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

    private boolean writeEx(String strJson) {
        try {
            writer = new FileWriter("/Users/dilshanjayatilake/NetBeansProjects/Accommadation_Management_UWE/src/main/java/com/mycompany/accommadation_management_uwe/data/ExpieredLease.json");
            writer.write(strJson);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(LeaseDataService.class.getName()).log(Level.SEVERE, null, ex);
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

    private boolean validation(Lease lease) throws UWEAccomException {
        boolean validity = false;
        try {
            Lease tempLease = getLeaseByRoom(lease.getRoomNumber(), lease.getHallNumber());
            if (!overlap((Date) lease.getStartDate(), (Date) tempLease.getEndDate(), (Date) lease.getStartDate(), (Date) lease.getEndDate())) {
                rds.getRoom(lease.getRoomNumber(), lease.getHallNumber());
                validity = true;
            } else {

                validity = false;

            }

        } catch (UWEAccomException ex) {
            try {
                rds.getRoom(lease.getRoomNumber(), lease.getHallNumber());
                validity = true;

            } catch (UWEAccomException ex1) {
                validity = false;
                throw new UWEAccomException("data_exeption", ex1.getMessage());
            }
        }
        return validity;
    }

}
