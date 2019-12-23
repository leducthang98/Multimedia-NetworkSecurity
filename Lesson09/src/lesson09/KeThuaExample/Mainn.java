/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson09.KeThuaExample;

/**
 *
 * @author Wind
 */
public class Mainn {

    public static void main(String[] args) {
        Square s1 = new Square(4);
        s1.tinhChuVi();
        s1.tinhDienTich();
        s1.hienThi();

        Shape s2 = new Square(5);
        s2.tinhChuVi();
        s2.tinhDienTich();
        s2.hienThi();
    }
}
