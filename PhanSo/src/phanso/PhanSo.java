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
public class PhanSo {

    // modify access : public, protected, private 
    private int tu, mau;

    public PhanSo() {
    }

    public PhanSo(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public void hienThi() {
        System.out.println(tu + "/" + mau);
    }

    public int getTu() {
        return tu;
    }

    public int getMau() {
        return mau;
    }

    public void Cong(PhanSo p) {
        this.tu = this.tu * p.mau + this.mau * p.tu;
        this.mau = this.mau * p.mau;
    }

}
