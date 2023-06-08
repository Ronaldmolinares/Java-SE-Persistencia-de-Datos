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
    Scanner sc = new Scanner(System.in);
    
    public void createMessage(){
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
    
    public void ListMessage() {
        msgdao.readMessageDB();
        for (Message messages : msgdao.getMessageList()) {
            System.out.println(messages.toString());
        }
    }
    
    public void deleteMessage(){
        System.out.println("Ingrese el ID del mensaje a eliminar: ");
        for (Message messages : msgdao.getMessageList()) {
            System.out.println(messages.toString2());
        }
        int id_delete = sc.nextInt();
        msgdao.deleteMessageDB(id_delete);
    }
    
    public void editMessage(){
        System.out.println("Escribe el nuevo mensaje...");
        String new_message = sc.nextLine();
        System.out.println("indica el ID del mensjae a editar");
        int id_message = Integer.parseInt(sc.nextLine());
    
        Message updateM = new Message();
        updateM.setId_message(id_message);
        updateM.setMessage(new_message);
        
        msgdao.editMessageDB(updateM);
    }
}
