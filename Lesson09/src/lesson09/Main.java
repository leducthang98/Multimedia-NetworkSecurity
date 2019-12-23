/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson09;

/**
 *
 * @author Wind
 */
public class Main {
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample(1,500);
        t1.start();
    }
}
