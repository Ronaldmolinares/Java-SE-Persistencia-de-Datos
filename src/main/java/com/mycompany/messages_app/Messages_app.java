/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messages_app;

import java.sql.Connection;

/**
 *
 * @author Samir
 */
public class Messages_app {
    
    public static void main(String[] args) {
        Conexion connection = new Conexion();
        try {
            Connection cnx = connection.get_connection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
