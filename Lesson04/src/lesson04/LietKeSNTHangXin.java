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
public class LietKeSNTHangXin {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        boolean check[] = new boolean[n];
        // true = loai bo 
        // false = giu lai
        check[0] = true;
        check[1] = true;
        // sang Eratos
        for (int i = 2; i < n; i++) {
            if (check[i] == false) {
                System.out.println("So nguyen to: " + i);
                // loai bo nhung so la boi cua i 
                for (int j = i*2; j < n; j=j+i) {
                    check[j] = true;
                }
            }
        }
    }
}
