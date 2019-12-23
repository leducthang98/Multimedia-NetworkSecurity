/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuabtvn01;

/**
 *
 * @author Wind
 */
public class A {

    public A() {
        System.out.print("C");
    }

    void show() {
        System.out.print("B");
    }

}

class B extends A {

    public B() {
        System.out.print("A");
    }

    @Override
    void show() {
        super.show();
        System.out.print("B");
    }

}

class C extends B {

    public C() {
    }

    @Override
    void show() {
        System.out.print("C");
    }
}

class D extends A {

    public D() {
        System.out.print("D");
    }

    @Override
    void show() {
        System.out.print("A");
    }

}

class F {

    public static A getA(int x) {
        if (x % 7 >= 5) {
            return new B();
        }
        A obj = new C();
        if (x % 4 == 2) {
            return obj;
        }
        if (x % 5 <= 1) {
            obj = new D();
            return obj;
        }
        return new A();
    }

    public static void main(String[] args) {
        A obj = new D();
        for (int i = 17; i < 17 + 17; i++) {
            obj.show();
            obj = F.getA(i + 1);
        }

    }

}
