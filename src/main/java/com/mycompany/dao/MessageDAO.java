/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.messages_app.ConnectionBD;
import com.mycompany.model.Message;
//paquete para conectarse con la base de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Samir
 */
public class MessageDAO {

    ArrayList<Message> messageList = new ArrayList<Message>();
    ConnectionBD db_connect = new ConnectionBD();

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void createMessageDB(Message message) {
        try (Connection con = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                //Consulta para insertar los datos
                String query = "INSERT INTO messages (message, autor_message) VALUES (?, ?)";
                ps = con.prepareStatement(query);
                //Preparamos los parametros que seran enviados a la base de datos
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAutor_message());
                ps.executeUpdate();
                System.out.println("Mensaje creado");

            } catch (SQLException ex) {
                System.out.println("ex");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void readMessageDB() {
        PreparedStatement ps = null;
        //Perimite traer los datos en fila 
        ResultSet rs = null;
        try (Connection con = db_connect.get_connection()) {
            //Para hacer la consulta 
            String query = "SELECT * FROM messages";
            ps = con.prepareStatement(query);
            //obtenemso los datos de la consulta en el objeto rs
            rs = ps.executeQuery();
            //vaciamos la lista para evitar mensajes duplicados
            messageList.clear();
            while (rs.next()) {
                Message messages = new Message(rs.getInt("id_message"), rs.getString("message"), rs.getString("autor_message"), rs.getString("date_message"));
                messageList.add(messages);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar los mensajes");
            System.out.println(e);
        }
    }

    public void deleteMessageDB(int id_message) {
        try (Connection connection = db_connect.get_connection()) {
            PreparedStatement ps;
            ResultSet res;
            String recordAccount = "SELECT COUNT(id_message) FROM messages WHERE id_message= " + id_message + "";
            ps = connection.prepareStatement(recordAccount);
            res = ps.executeQuery();
            if (res.next()) {
                String count = res.getString("count(id_message)");
                int existe = Integer.parseInt(count);
                if (existe > 0) {
                    try {
                        String query = "DELETE FROM messages WHERE id_message = ?";
                        ps = connection.prepareStatement(query);
                        ps.setInt(1, id_message);
                        ps.executeUpdate();
                        System.out.println("Mensaje eliminado");
                        System.out.println("\n");

                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                } else {
                    System.out.println("El ID del mensaje no existe.");
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editMessageDB(Message message) {
        try (Connection con = db_connect.get_connection()) {
            PreparedStatement ps = null;

            ResultSet res;
            String recordAccount = "SELECT COUNT(id_message) FROM messages WHERE id_message= " + message.getId_message() + "";
            ps = con.prepareStatement(recordAccount);
            res = ps.executeQuery();
            if (res.next()) {
                String count = res.getString("count(id_message)");
                int existe = Integer.parseInt(count);
                if (existe > 0) {

                    try {
                        String query = "UPDATE messages SET message = ? WHERE id_message = ?";
                        ps = con.prepareStatement(query);
                        ps.setString(1, message.getMessage());
                        ps.setInt(2, message.getId_message());
                        ps.executeUpdate();
                        System.out.println("Mensaje actualizado con exito.");

                    } catch (SQLException ex) {
                        System.out.println(ex);
                        System.out.println("Error al actualizar el mensaje.");
                    }
                } else {
                    System.out.println("El ID del mensaje no existe.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
