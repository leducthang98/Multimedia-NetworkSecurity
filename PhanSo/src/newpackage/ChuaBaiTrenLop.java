/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class ChuaBaiTrenLop {

    static Scanner sc = new Scanner(System.in);
    static sinhvien[] SV = new sinhvien[100];
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("------------");
            System.out.println("1:HienThi");
            System.out.println("2:Them");
            System.out.println("3:Sua");
            System.out.println("4:Xoa");

            switch (sc.nextInt()) {
                case 1:
                    hienThi();
                    break;
                case 2:
                    them();
                    break;
                case 3:
                    sua();
                    break;
                case 4:
                    xoa();
                    break;

            }

        }
    }

    private static void hienThi() {
        if (count == 0) {
            System.out.println("Chua co sinh vien !");
        } else {
            for (int i = 0; i < count; i++) {
                if (!SV[i].isDelete) {
                    SV[i].hienThi();
                }
            }
        }
    }

    private static void them() {
        sc.nextLine();
        System.out.println("Ten: ");
        String ten = sc.nextLine();
        System.out.println("Tuoi");
        int tuoi = sc.nextInt();
        sc.nextLine();
        System.out.println("MSSV");
        int MSSV = sc.nextInt();
        sc.nextLine();
        System.out.println("Gioi tinh: ");
        String gioiTinh = sc.nextLine();

        SV[count] = new sinhvien(ten, gioiTinh, tuoi, MSSV);
        count++;
    }

    private static void sua() {
        sc.nextLine();
        System.out.println("Nhap MSSV cua SV muon sua");
        int MSSV = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (MSSV == SV[i].getMSSV()) {
                System.out.println("Ban muon sua ten thanh gi?");
                String newName = sc.nextLine();
                SV[i].setTen(newName);
                System.out.println("DONE");
            }
        }
    }

    private static void xoa() {
        sc.nextLine();
        System.out.println("Nhap MSSV cua SV muon xoa");
        int MSSV = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (MSSV == SV[i].getMSSV()) {
                SV[i].isDelete = true;
            }
        }
    }
}
