/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.messages_app.ConnectionBD;
import com.mycompany.model.Message;
//paquete para conectarse con la base de datos
import java.sql.Connection;
//
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Samir
 */
public class MessageDAO {

    public void createMessageDB(Message message) {
        //Conectamos con nuestra base de datos
        ConnectionBD db_connect = new ConnectionBD();

        try(Connection con = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try{
                //Consulta para insertar los datos
                String query = "INSERT INTO messages (message, autor_message) VALUES (?, ?)";
                ps = con.prepareStatement(query);
                //Preparamos los parametros que seran enviados a la base de datos
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAutor_message());
                ps.executeUpdate();
                System.out.println("");
                
            } catch (SQLException ex) {
                System.out.println("ex");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void readMessageDB() {

    }

    public void deleteMessageDB(int id_message) {

    }

    public void editMessageDB(Message message) {

    }

}
