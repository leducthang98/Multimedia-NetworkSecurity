/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuabtvn01;

import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class Chuabtvn02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < 10; i++) {
//            System.out.println("input:");
//            int temp = sc.nextInt();
//            if (temp > max) {
//                max = temp;
//            }
//            if (temp < min) {
//                min = temp;
//            }
//        }
        int randomNumber = (int) (Math.random() * 100);

        while (true) {
            System.out.println("Guess:");
            int guess = sc.nextInt();
            if (guess > randomNumber) {
                System.out.println("Too high!");
                
            } else if (guess < randomNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Correct!");
                break;
            }
        }
        
        

    }
}
