/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson04;

import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class Lesson04 {

//    public static void Hello(){
//        System.out.println("Hello world");
//    }
//    
    public static void main(String[] args) {
        //
        System.out.println("input");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        inraSNTNhoHonSoDaCho(input);

    }

    public static void inraSNTNhoHonSoDaCho(int input) {
        for (int i = 2; i < input; i++) {
            boolean isSNT = checkSNT(i);
            if (isSNT) {
                System.out.println(i);
            }
        }
    }

    public static boolean checkSNT(int i) {
        int count = 0;
        boolean returnStatement;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                count++;
            }
        }
        if (count == 2) {
            returnStatement = true;
        } else {
            returnStatement = false;
        }

        return returnStatement;
    }

}
