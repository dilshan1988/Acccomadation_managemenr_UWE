/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.controller;

import com.mycompany.accommadation_management_uwe.LoginUI;
import com.mycompany.accommadation_management_uwe.pojo.User;
import com.mycompany.accommadation_management_uwe.services.UWEAccomException;
import com.mycompany.accommadation_management_uwe.services.UserDataService;
import com.vaadin.ui.Notification;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilshanjayatilake
 */
public class UserController {

    UserDataService uds;

    public UserController() throws FileNotFoundException {

        uds = new UserDataService();
    }

    public boolean userValidation(String username, String password) throws UWEAccomException {

        boolean isValied = false;

        User user_ = uds.getUserByUserName(username);
        if (user_.getUserName().equals(username) && user_.getPassword().equals(password)) {
            isValied = true;
        } else {
            isValied = false;
        }

        return isValied;
    }
}
