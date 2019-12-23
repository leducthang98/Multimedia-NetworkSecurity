/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson09.FrameNavigationExample;

import javax.swing.JFrame;

/**
 *
 * @author Wind
 */
public class Frame2 {

    JFrame f2;

    void show() {
        f2.setVisible(true);
    }

    public Frame2() {
        f2 = new JFrame("Frame2");
        f2.setSize(400, 400);
    }

}
