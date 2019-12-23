/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksecurityproject;

import java.net.*;
import java.io.*;

public class MultithreadedSocketServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8889);
        int counter = 0;
        System.out.println("Server Started ....");
        while (true) {
            counter++;
            Socket serverClient = server.accept();  //server accept the client connection request
            System.out.println(" >> " + "Client No:" + counter + " started!");
            ServerClientThread sct = new ServerClientThread(serverClient, counter); //send  the request to a separate thread 
            sct.start();
        }

    }
}
