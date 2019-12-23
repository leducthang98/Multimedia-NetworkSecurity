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
public class Chuabtvn01 {

    public static void main(String[] args) {
//        System.out.println("Input");
//        Scanner sc = new Scanner(System.in);
//        int day = sc.nextInt();

//        switch (day) {
//            case 2:
//                System.out.println("thu hai");
//                break;
//            case 3:
//                System.out.println("thu ba");
//                break;
//            case 4:
//                System.out.println("thu tu");
//                break;
//            case 5:
//                System.out.println("thu nam");
//                break;
//            case 6:
//                System.out.println("thu sau");
//                break;
//            case 7:
//                System.out.println("thu bay");
//                break;
//            default:
//                System.out.println("chu nhat");
//                break;
//        }
//        int a = 5;
//        a = a + 1;
//        a++;
//        // FOR LOOPS
//        int i;
//        i = 3;
//        while (i < 2) {
//            System.out.print(i);
//            i = i + 1;
//        }
//        
//        do {            
//            System.out.println(i);
//        } while (i<2);
//        int b = 10;
//        for (int j = 0; j < b; j++) {
//            if (j % 2 == 0) {
//                System.out.print(j + "");
//            }
//        }
//        int x = 0;
//        while (x < b) {
//            if (x % 2 == 0) {
//                System.out.println(x);
//            }
//            x++;
//        }
//        for (int j = 0; j < b; j = j + 2) {
//            System.out.println(j);
//        }
//        while (x < b) {
//            System.out.println(x);
//            x = x + 2;
//        }
//        int input = 20;
//        int count = 0;
//        for (int i = 1; i < input; i++) {
//
//            if (input % i == 0) {
//                System.out.print(i + " ");
//                count++;
//            }
//
//        }
//        System.out.println("so uoc:" + count);
//        if (count == 2) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
//        //nhap va0 1 s0 , in ra tat ca snt nh0 h0 s0 d0
        int input = 80;
        for (int i = 0; i < input; i++) {
            //check i co phai snt ko
            int uoc = 0;
            for (int j = 0; j < i; j++) {
                if (i % j == 0) {
                    uoc++;
                }
            }
            if (uoc == 2) {
                System.out.println(i);
            }
            // done
        }

    }

}
