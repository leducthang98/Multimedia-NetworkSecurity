/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Wind
 */
public class RandomORG {

    JFrame f;
    JPanel pnMain;
    JButton btnSubmit;
    JTextField txtMax, txtMin;
    JLabel lbResult, BGLabel;
    ImageIcon backGround;

    public RandomORG() {
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

        backGround = new ImageIcon("C:\\Users\\Wind\\Downloads\\Compressed\\OOP\\OOP\\src\\Image\\itachi.png");
        backGround = new ImageIcon(backGround.getImage().getScaledInstance(f.getWidth(), f.getHeight(), BufferedImage.SCALE_DEFAULT));
        BGLabel = new JLabel();
        BGLabel.setBounds(0, 0, f.getWidth(), f.getHeight());
        BGLabel.setIcon(backGround);
        btnSubmit = new JButton("Random");
        int height = f.getHeight() / 4;

        btnSubmit.setBounds(f.getWidth() / 3 - 100, height, 300, 50);
        btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 30));

        txtMax = new JTextField(50);
        txtMax.setSize(300, 50);
        txtMax.setBounds(f.getWidth() / 3 - 100, height + 100, 300, 50);
        txtMax.setToolTipText("Max value");
        txtMax.setFont(new Font("Courier New", Font.BOLD, 30));

        txtMin = new JTextField(50);
        txtMin.setBounds(f.getWidth() / 3 - 100, height + 200, 300, 50);
        txtMax.setSize(300, 50);
        txtMin.setToolTipText("Min value");
        txtMin.setFont(new Font("Courier New", Font.BOLD, 30));

        lbResult = new JLabel("0");
        lbResult.setBounds(f.getWidth() / 3 + 40, height + 300, 300, 50);
        lbResult.setFont(new Font("Courier New", Font.BOLD, 30));

    }

    private void addComponent() {

        pnMain.add(btnSubmit);
        pnMain.add(txtMax);
        pnMain.add(txtMin);
        pnMain.add(lbResult);
        pnMain.add(BGLabel);
    }

    private void addEvent() {
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int min = 0, max = 0;
                try {
                    min = Integer.valueOf(txtMin.getText());
                    max = Integer.valueOf(txtMax.getText());
                    int random = max - (int) (Math.random() * (max - min));
                    String ramdomDangString = String.valueOf(random);
                    lbResult.setText(ramdomDangString);
                } catch (Exception e) {
                    lbResult.setText(e.toString());
                }

//                txtMax.setText("");
//                txtMin.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new RandomORG();
    }
}
