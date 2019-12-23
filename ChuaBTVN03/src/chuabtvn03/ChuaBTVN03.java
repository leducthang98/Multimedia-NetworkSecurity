/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuabtvn03;

import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class ChuaBTVN03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.println("x: ");
        x = sc.nextInt();
        int[] arr = new int[x];
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < x; i++) {
            if (arr[i] % 2 == 1) {
                System.out.print(arr[i] + " ");
            }
        }
        //b
        int max = arr[0];
        for (int i = 0; i < x; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int min = arr[0];
        for (int i = 0; i < x; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        for (int i = 0; i < x; i++) {
            if (arr[i] == min) {
                arr[i] = -1;
            }
        }

        System.out.println("nhap vao x :");
        int input = sc.nextInt();
        int minSub = Math.abs(arr[0] - input);
        for (int i = 0; i < x; i++) {
            int temp = Math.abs(arr[i] - input);
            if (temp < minSub) {
                minSub = temp;
            }
        }
        int result = minSub + input;
        boolean check = true;
        for (int i = 0; i < arr.length / 2; i++) {
            
            if (arr[i] != arr[arr.length - 1 - i]) {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println("mang doi xung");
        } else {
            System.out.println("mang khong doi xung");
        }
        
    }

}
