/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanso;

/**
 *
 * @author Wind
 */
public class SinhVien {

    String ten;
    int mssv, tuoi;
    String GioiTinh;
    boolean isDeleted = false;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public SinhVien() {
    }

    public SinhVien(String ten, int mssv, int tuoi, String GioiTinh) {
        this.ten = ten;
        this.mssv = mssv;
        this.tuoi = tuoi;
        this.GioiTinh = GioiTinh;
    }

    public void hienThi() {
        System.out.println("MSSV :" + this.mssv + ", Ho ten: " + this.ten + ", Gioi tinh: " + this.GioiTinh + ", Tuoi: " + this.tuoi
        );
    }
}
