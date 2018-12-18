/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accommadation_management_uwe.UI;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author dilshanjayatilake
 */
public class Login extends VerticalLayout{
    Label l_userName = new  Label("User Name");
    Label l_password = new  Label("Password");
    TextField t_userName = new TextField("UserName");
    TextField t_password = new PasswordField("Password");
    Button b_button = new Button("Login");

    public Login() {
        this.addComponent(t_userName);
        this.addComponent(t_password);
        this.addComponent(b_button);
        
    }
    
    
}
