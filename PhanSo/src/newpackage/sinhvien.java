/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Wind
 */
public class sinhvien {

    String ten, gioiTinh;
    int tuoi, MSSV;
    boolean isDelete = false;

    public sinhvien() {
    }

    public sinhvien(String ten, String gioiTinh, int tuoi, int MSSV) {
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.MSSV = MSSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public void hienThi() {
        System.out.println("MSSV :" + this.MSSV + ", Ho ten: " + this.ten + ", Gioi tinh: " + this.gioiTinh + ", Tuoi: " + this.tuoi
        );
    }

}
