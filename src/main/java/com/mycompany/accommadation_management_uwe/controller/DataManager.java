/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdd2-jayatilak
 */
public class DataManager {
    //XStream xstream = new XStream();
    
    
    public static void main(String[] args) {
        XStream xstream = new XStream(new StaxDriver());
        XStreamTranslator ex = new XStreamTranslator();
        Hall h1=new Hall();
        h1.setHallName("HALL 01");
        h1.setHallNumber(0);
        h1.setNumberOfRooms(10);
        h1.setWardenID(123);
        ex.toXMLString(h1);
        String xml = xstream.toXML(h1);
        System.out.println(">> " + xml);
        
    }
    
    private void writeData(){
        
        
    }
    
}
