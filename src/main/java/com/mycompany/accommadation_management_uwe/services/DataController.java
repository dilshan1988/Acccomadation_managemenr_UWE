/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.services;

import com.mycompany.accommadation_management_uwe.controller.Room;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author dilshanjayatilake
 */
public class DataController {

    public DataController(Room room) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Room.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.marshal(room, new File("/Users/dilshanjayatilake/NetBeansProjects/UWEAccommadation/src/com/uweaccommadation/data/room.xml"));
            jaxbMarshaller.marshal(room, System.out);
            

        } catch (JAXBException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
