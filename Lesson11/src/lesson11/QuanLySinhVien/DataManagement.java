/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11.QuanLySinhVien;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wind
 */
public class DataManagement {

    File data = new File("sv");

    public boolean addSinhVien(SinhVien s) {
        String temp = s.getTen() + "\r\n" + s.getTuoi() + "\r\n" + s.getDiem()[0] + " " + s.getDiem()[1] + " " + s.getDiem()[2];
        File info = new File(data.getPath() + "\\" + s.getMSSV() + ".txt");
        try {
            if (info.exists()) {
                return false;
            } else {
                info.createNewFile();
                FileWriter fr = new FileWriter(info, false);
                fr.write(temp);
                fr.flush();
                fr.close();
                return true;
            }

        } catch (IOException ex) {
            System.out.println("??? :D ???");
            return false;
        }

    }

    public ArrayList<SinhVien> getSinhVien() throws FileNotFoundException, IOException {
        ArrayList<SinhVien> listSV = new ArrayList<>();
        for (File sv : data.listFiles()) {
            FileReader fr = new FileReader(sv);
            BufferedReader br = new BufferedReader(fr);
            //Ten
            String ten = br.readLine();
            //Tuoi
            int tuoi = Integer.valueOf(br.readLine());
            //Diem
            String diem = br.readLine();
            int[] diemToArr = new int[3];
            int temp = 0; // 8 8 7
            for (String s : diem.split(" ")) {
                diemToArr[temp] = Integer.parseInt(s);
                temp++;
            }
            SinhVien cache = new SinhVien(sv.getName(), ten, tuoi, diemToArr);
            //add to ListSV
            listSV.add(cache);
            br.close();
        }
        return listSV;
    }

    public boolean suaSinhVien(String MSSV, SinhVien s) {
        String temp = s.getTen() + "\r\n" + s.getTuoi() + "\r\n" + s.getDiem()[0] + " " + s.getDiem()[1] + " " + s.getDiem()[2];
        File info = new File(data.getPath() + "\\" + MSSV + ".txt");
        try {
            FileWriter fr = new FileWriter(info, false);
            fr.write(temp);
            fr.flush();
            fr.close();
            return true;

        } catch (IOException ex) {
            System.out.println("??? :D ???");
            return false;
        }

    }

    public boolean xoaSinhVien(String mssv) {
        boolean result;
        File f = new File(data.getPath() + "\\" + mssv + ".txt");
        result = f.delete();
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DataManagement dataMgn = new DataManagement();
        while (true) {
            System.out.println("1.Them");
            System.out.println("2.Sua");
            System.out.println("3.Xoa");
            System.out.println("4.HienThi");
            int input = Integer.valueOf(sc.nextLine());
            switch (input) {
                case 1:
                    System.out.println("Ten: ");
                    String ten = sc.nextLine();
                    System.out.println("MSSV: ");
                    String MSSV = sc.nextLine();
                    System.out.println("Tuoi: ");
                    int tuoi = Integer.valueOf(sc.nextLine());
                    int[] diem = new int[3];
                    System.out.println("Nhap diem: ");
                    diem[0] = sc.nextInt();
                    diem[1] = sc.nextInt();
                    diem[2] = sc.nextInt();
                    sc.nextLine();
                    dataMgn.addSinhVien(new SinhVien(MSSV, ten, tuoi, diem));
                    break;
                case 2:
                    System.out.println("Nhap MSSV cua sv muon sua: ");
                    String edit = sc.nextLine();
                    System.out.println("Dien thong tin moi: ");
                    System.out.println("Ten: ");
                    String tenEdit = sc.nextLine();
                    System.out.println("Tuoi: ");
                    int tuoiEdit = Integer.valueOf(sc.nextLine());
                    int[] diemEdit = new int[3];
                    System.out.println("Nhap diem: ");
                    diemEdit[0] = sc.nextInt();
                    diemEdit[1] = sc.nextInt();
                    diemEdit[2] = sc.nextInt();
                    sc.nextLine();
                    dataMgn.suaSinhVien(edit, new SinhVien(edit, tenEdit, tuoiEdit, diemEdit));
                    break;
                case 3:
                    System.out.println("Nhap MSSV cua sv muon xoa: ");
                    String temp = sc.nextLine();
                    if (dataMgn.xoaSinhVien(temp)) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("Xoa that bai");
                    }
                    break;
                case 4:
                    ArrayList<SinhVien> data = dataMgn.getSinhVien();
                    for (int i = 0; i < data.size(); i++) {
                        for (int j = i + 1; j < data.size(); j++) {
                            if (data.get(i).trungBinhMon < data.get(j).trungBinhMon) {
                                SinhVien sv = data.get(i); // int temp = a[i]
                                data.set(i, data.get(j));  // a[i] = a[j]
                                data.set(j, sv);           //a[j] = temp
                            }
                        }
                    }
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).hienThi();
                    }
                    break;
            }
        }
    }
}
