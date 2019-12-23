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
public class Square extends Shape {

    int canh = 4;int doDaiCanh;
    

    public Square() {
        type = "Hinh vuong";
        canh = 4;
    }

    public Square(int doDaiCanh) {
        System.out.println("Hinh vuong duoc khoi tao");
        this.doDaiCanh = doDaiCanh;
        type = "Hinh vuong";
        canh = 4;
    }

    @Override
    void tinhChuVi() {
        chuVi = doDaiCanh * 4;
    }

    @Override
    void tinhDienTich() {
        dienTich = doDaiCanh * doDaiCanh;
    }
    

}

// TAO LOP SHAPE hienthi(), 
//tinhChuVi(),tinhDienTich(), String ten

//TAMGIAC 3 canh , chieu cao , TRON Ban Kinh, VUONG Canh, CHUNHAT CD CR
