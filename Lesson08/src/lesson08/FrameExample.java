/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson08;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Wind
 */
public class FrameExample {

    JFrame f;
    JPanel pnMain;
    JButton button1;
    JTextField txt1;
    JLabel lb1;

    public FrameExample() {
        initContainer();
        initComponent();
        addComponent();
        addEvent();
        f.setVisible(true);
    }

    private void initContainer() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        f = new JFrame();
        f.setSize(screen.width, screen.height);
        f.setLayout(null);
        pnMain = new JPanel();
        pnMain.setLayout(null);
        pnMain.setBackground(Color.gray);
        pnMain.setBounds(0, 0, f.getWidth(), f.getHeight());
        f.add(pnMain);

    }

    private void initComponent() {
        button1 = new JButton("Click me");
        button1.setBounds(100, 200, 300, 50);

        txt1 = new JTextField();
        txt1.setBounds(200, 350, 300, 50);

        lb1 = new JLabel("Number");
        lb1.setBounds(300, 400, 300, 50);
    }

    private void addComponent() {
        pnMain.add(button1);
        pnMain.add(txt1);
        pnMain.add(lb1);

    }

    private void addEvent() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String value = txt1.getText();
                lb1.setText(value);
            }
        });

    }

}
