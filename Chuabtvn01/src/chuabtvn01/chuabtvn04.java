/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuabtvn01;

/**
 *
 * @author Wind
 */
public class chuabtvn04 {

    public static boolean checkTangDan(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] carr = {'a', 'b', 'c', 'd', 'z', 'g'};
        System.out.println((char) carr[0]);
        int[] arr1 = {1, 2, 3, 4, 6};
        System.out.println(checkTangDan(arr1));
    }
}
