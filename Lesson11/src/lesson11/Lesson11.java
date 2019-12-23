/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Wind
 */
public class Lesson11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File f = new File("sv\\23123.txt");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        raf.close();
        System.out.println(f.delete());
        System.out.println(f.exists());
//        FileWriter fw = new FileWriter(f2, false);
//        String data = "Le Duc Thang";
//        fw.write(data); // viet du lieu vao file
//        fw.flush(); // xoa cache cua FW
//        fw.close();
//        FileReader fr = new FileReader(f2);
//        BufferedReader br = new BufferedReader(fr);
//        String line = "";
//        while (line != null) {
//            line = br.readLine();
//            if (line == null) {
//                break;
//            } else {
//                System.out.println(line);
//            }
//
//        }
    }

}
