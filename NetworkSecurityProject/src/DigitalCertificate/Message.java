/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalCertificate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Message {

    private List<byte[]> list;

    //The constructor of Message class builds the list that will be written to the file. The list consists of the message and the signature.
    public Message(String data, String keyFile) throws InvalidKeyException, Exception {
        list = new ArrayList<byte[]>();
        list.add(data.getBytes());
        list.add(sign(data, keyFile));
    }

    //signs the data using the private key that is stored in keyFile path
    public byte[] sign(String data, String keyFile) throws InvalidKeyException, Exception {
        Signature dsa = Signature.getInstance("SHA1withRSA");
        dsa.initSign(getPrivate(keyFile));
        dsa.update(data.getBytes());
        return dsa.sign();
    }

    //retrieve the Private Key from a file
    public PrivateKey getPrivate(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec); // change spec into RSA version
    }

    //write the List of byte[] to a file
    public void writeToFile(String filename) throws FileNotFoundException, IOException {
        File f = new File(filename);
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(list);
        out.close();
        System.out.println("Your file is ready.");
    }

    public static void main(String[] args) throws InvalidKeyException, IOException, Exception {
        String data = JOptionPane.showInputDialog("Type your message here");
        new Message(data, "privateKey.txt").writeToFile("hashedData.txt");
    }
}
