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
public class Lesson07 {

    static int count = 0;
    static SinhVien[] svArr = new SinhVien[100];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Ten MSSV Tuoi Gioi Tinh
        // HienThi Getter Setter 
        Scanner sc1 = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------");
            System.out.println("1.Hien thi danh sach sinh vien");
            System.out.println("2.Them sinh vien");
            System.out.println("3.Sua sinh vien");
            System.out.println("4.Xoa sinh vien");
            System.out.println("Chon 1 2 3 4");
            switch (sc1.nextInt()) {
                case 1:
                    hienThiSinhVien();
                    break;
                case 2:
                    themSinhVien();
                    break;
                case 3:
                    suaSinhVien();
                    break;
                case 4:
                    xoaSinhVien();
                    break;

            }
        }
    }

    private static void hienThiSinhVien() {
        if (count == 0) {
            System.out.println("Chua co sinh vien nao !");
        } else {
            for (int i = 0; i < count; i++) {
                if (!svArr[i].isDeleted) {
                    svArr[i].hienThi();
                }
            }
        }
    }

    private static void themSinhVien() {
        System.out.println("Ten:");
        String ten = sc.nextLine();
        System.out.println("MSSV:");
        int MSSV = sc.nextInt();
        sc.nextLine();
        System.out.println("Tuoi:");
        int tuoi = sc.nextInt();
        sc.nextLine();
        System.out.println("Gioi tinh:");
        String gioiTinh = sc.nextLine();
        svArr[count] = new SinhVien(ten, MSSV, tuoi, gioiTinh);
        count++;
    }

    private static void suaSinhVien() {
        System.out.println("Nhap mssv cua sinh vien muon sua:");
        int MSSV = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (svArr[i].mssv == MSSV) {
                System.out.println("Nhap ten moi:");
                String newName = sc.nextLine();
                svArr[i].setTen(newName);
                System.out.println("DONE");
            }
        }
    }

    private static void xoaSinhVien() {
        System.out.println("Nhap mssv cua sinh vien muon xoa:");
        int MSSV = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (svArr[i].mssv == MSSV) {
                svArr[i].isDeleted = true;
                System.out.println("DONE");
            }
        }
    }
}
