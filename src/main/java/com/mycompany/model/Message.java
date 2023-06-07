/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Samir
 */
public class Message {
    int id_message;
    String message;
    String autor_message;
    String date_message;

    public Message(){
        
    }

    public Message(int id_message, String message, String autor_message, String date_message) {
        this.id_message = id_message;
        this.message = message;
        this.autor_message = autor_message;
        this.date_message = date_message;
    }
    
    
    
    public Message(String message, String autor_message, String date_message) {
        this.message = message;
        this.autor_message = autor_message;
        this.date_message = date_message;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAutor_message() {
        return autor_message;
    }

    public void setAutor_message(String autor_message) {
        this.autor_message = autor_message;
    }

    public String getDate_message() {
        return date_message;
    }

    public void setDate_message(String date_message) {
        this.date_message = date_message;
    }

    @Override
    public String toString() {
        return "Message{" + "ID Message: " + id_message + ", Message: " + message + ", Autor Message: " + autor_message + ", Date Message: " + date_message + '}';
    }
    
    
    
}
