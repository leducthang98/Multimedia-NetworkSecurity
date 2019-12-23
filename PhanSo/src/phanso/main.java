/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanso;

import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo Sum = new PhanSo(0, 1);
        while (true) {
            System.out.println("Nhap phan so: ");
            String input = sc.nextLine();
            if (input.equals("-1")) {
                break;
            }
            String[] value = new String[2];
            value[0] = "";
            value[1] = "";
            int temp = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '/') {
                    temp++;
                    continue;
                }
                value[temp] += input.charAt(i);
            }
            int tu = Integer.parseInt(value[0]);
            int mau = Integer.parseInt(value[1]);
            PhanSo p = new PhanSo(tu, mau);
            Sum.Cong(p);
        }
        Sum.hienThi();
    }
}
