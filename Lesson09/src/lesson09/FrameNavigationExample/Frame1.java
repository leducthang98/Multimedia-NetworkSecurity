/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson09.FrameNavigationExample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Wind
 */
public class Frame1 {

    public Frame1() {
        JFrame f1 = new JFrame("Frame1");
        f1.setSize(300, 200);
        JButton btn1 = new JButton("Click");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f1.setVisible(false);
                Frame2 f2 = new Frame2();
                f2.show();
            }
        });
        f1.add(btn1);
        f1.setVisible(true);
    }

    public static void main(String[] args) {
        Frame1 f1 = new Frame1();
    }
}
