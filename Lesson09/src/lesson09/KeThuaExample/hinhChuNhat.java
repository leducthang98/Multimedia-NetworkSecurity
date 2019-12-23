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
public class hinhChuNhat extends Shape {

    int CD, CR;

    public hinhChuNhat(int CD, int CR) {
        this.CD = CD;
        this.CR = CR;
        type = "Hinh chu nhat";
        canh = 4;
    }

    @Override
    void tinhChuVi() {
        chuVi = (CD + CR) * 2;
    }

    @Override
    void tinhDienTich() {
        dienTich = CD * CR;
    }

}
