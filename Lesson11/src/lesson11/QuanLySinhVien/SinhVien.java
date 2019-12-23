/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11.QuanLySinhVien;

/**
 *
 * @author Wind
 */
public class SinhVien {

    String MSSV, ten;
    int tuoi;
    int[] diem = new int[3];
    int trungBinhMon;

    public SinhVien() {
    }

    public SinhVien(String MSSV, String ten, int tuoi, int[] diem) {
        this.MSSV = MSSV;
        this.ten = ten;
        this.tuoi = tuoi;
        this.diem = diem;
        trungBinhMon = (diem[0] + diem[1] + diem[2]) / 3;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int[] getDiem() {
        return diem;
    }

    public void setDiem(int[] diem) {
        this.diem = diem;
    }

    public void hienThi() {
        System.out.println("Ten: " + getTen() + ", MSSV: " + getMSSV() + ", Age: " + getTuoi() + ", CPA: " + trungBinhMon);
    }

}
