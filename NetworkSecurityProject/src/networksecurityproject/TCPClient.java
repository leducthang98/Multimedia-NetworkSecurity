/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choo@se Tools | Templates
 * and open the template in the editor.
 */
package networksecurityproject;

import java.net.*;
import java.io.*;

public class TCPClient {
//

    public static void main(String[] args) throws Exception {
        try {
            Socket socket = new Socket("127.0.0.1", 8889);
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage = "", serverMessage = "";
            System.out.println("Type -help to show command");
            while (!clientMessage.equals("-exit")) {
                System.out.print("-> ");
                clientMessage = br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();
                serverMessage = inStream.readUTF();
                System.out.println(serverMessage);
            }
            outStream.close();
            outStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
