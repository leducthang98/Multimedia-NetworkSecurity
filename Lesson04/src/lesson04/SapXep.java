/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson04;

import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JFrame;

/**
 *
 * @author Wind
 */
public class SapXep {

    public static void main(String[] args) {
        int a[] = {4, 2, 5, 1, 6, 3, 7, 10, 9};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                if (a[i] > a[j]) {
//                    int temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
        PhanSo ps1 = new PhanSo(); // NullPointerException
        ps1.tuso = 3;
        ps1.mauso = 5;
        PhanSo ps2 = new PhanSo();
        ps2.tuso = 4;
        ps2.mauso = 5;
        PhanSo psArray[] = {ps1, ps2};
//        
//        for (int i = 0; i < psArray.length; i++) {
//            for (int j = i + 1; j < psArray.length; j++) {
//                int hieuso = psArray[i].tuso * psArray[j].mauso - psArray[j].tuso * psArray[i].mauso;
//                if (hieuso < 0) {
//                    PhanSo temp = psArray[i];
//                    psArray[i] = psArray[j];
//                    psArray[j] = temp;
//                }
//            }
//        }

    }

    class PhanSo extends JFrame {

        int tuso;
        int mauso;

        PhanSo() {

        }

    }
