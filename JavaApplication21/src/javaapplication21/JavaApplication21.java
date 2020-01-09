/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

/**
 *
 * @author Wind
 */
public class JavaApplication21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int c = 0xC4;
        c =  (c & 1 | 0xF0);
        System.out.println(Integer.toHexString(c));
    }

    static void chuvi(float x) {
        System.out.println(3 * x);
    }

    static void f4(int x)
    
}
