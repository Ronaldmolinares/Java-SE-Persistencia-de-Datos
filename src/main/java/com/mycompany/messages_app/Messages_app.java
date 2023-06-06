package com.mycompany.messages_app;

import com.mycompany.dao.MessageDAO;
import com.mycompany.model.Message;
import com.mycompany.service.MessagesService;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Samir
 */
public class Messages_app {

    public void run() {
        Scanner sc = new Scanner(System.in);
        MessagesService messageservice = new MessagesService();
        int option = 0;

        do {
            System.out.println("------------------------");
            System.out.println(" Aplicacion de Mensajes ");
            System.out.println(" 1. Crear mensaje");
            System.out.println(" 2. Listar Mensajes");
            System.out.println(" 3. Editar Mensajes");
            System.out.println(" 4. Eliminar Mensajes");
            System.out.println(" 5. Salir");
            System.out.println(" Seleccione una opción: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                   messageservice.createMessage();
                    break;
                case 2:
                   messageservice.ListMessage();
                    break;
                case 3:
                   messageservice.editMessage();
                    break;
                case 4:
                   messageservice.deleteMessage();
                    break;
                default:
                    System.out.println("You have selected an invalid option!");
                    break;
            }

        } while (option != 5);

//        ConnectionBD connection = new ConnectionBD();
//        try {
//            Connection cnx = connection.get_connection();
//       } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    public static void main(String[] args) {
        new Messages_app().run();

    }

}
