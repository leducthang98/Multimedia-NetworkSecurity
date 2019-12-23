/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6;

/**
 *
 * @author Wind
 */
public class Lesson6 {

    public static void main(String[] args) {
        PhanSo p = new PhanSo();
//        p.tuso = 5;
        p.mauso = 8;
        p.ten = "A";
//        PhanSo p2 = new PhanSo(3, 4);
        PhanSo p2 = new PhanSo(p);
        p2.hienThi();
        System.out.println("gia tri double: " + p2.giaTri());

        PhanSo x = new PhanSo(3, 4, "X");
        PhanSo y = new PhanSo(5, 8, "Y");
        PhanSo kq = x.cong(y);
        x.hienThi();
        y.hienThi();
        System.out.println("loai x" + x.loai);
        System.out.println("loai y" + y.loai);
        PhanSo.loai = "thaydoi";
        System.out.println("loai x" + x.loai);
        System.out.println("loai y" + y.loai);
        
        kq.hienThi();
        kq.rutGon();
        kq.hienThi();

        // public private protected
        // static 
    }
}
