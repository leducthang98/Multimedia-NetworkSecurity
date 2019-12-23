/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson09;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wind
 */
public class ThreadExample extends Thread {

    int id;
    int timeSleep;

    public ThreadExample(int id, int timeSleep) {
        this.id = id;
        this.timeSleep = timeSleep;
    }

    public void run() {
        while (true) {
            System.out.println("Nhap vao 1 so");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num == -1) {
                this.stop();
            }
        }
    }

}
