/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.model.Message;
import com.mycompany.dao.MessageDAO;
import java.util.Scanner;

/**
 *
 * @author Samir
 */
public class MessagesService {
    
    MessageDAO msgdao = new MessageDAO();
    
    public void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String message = sc.nextLine();
        
        System.out.println("Nombre del autor: ");
        String name = sc.nextLine();
        
        Message register = new Message();
        register.setMessage(message);
        register.setAutor_message(name);
        
        //Enviamos el objeto creado a la capa DAO
        msgdao.createMessageDB(register);
        
        System.out.println("Operacion exitosa");
    }
    
    public void ListMessage(){
        
    }
    
    public void deleteMessage(){
        
    }
    
    public void editMessage(){
        
    }
}
