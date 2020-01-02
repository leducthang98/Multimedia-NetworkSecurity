/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Multimedia {

    JFrame frame;
    JLabel pn1, pn2, diffirent;
    Dimension screenSize;
    JButton addImgBtn, btnRefresh, btnSharpener, btnScaleGray, btnExcute;
    ImageIcon addIcon, imgPn1, imgPn2;
    String choosePath, chooseFileName;
    int diffirentPercentage = 0;

    public Multimedia() {
        initContainer();
        initComponent();
        addComponent();
        addEvent();
        showGUI();

    }

    private void initContainer() {
        frame = new JFrame("Multimedia");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(204, 233, 206));

    }

    private void initComponent() {

        pn1 = new JLabel();
        pn1.setBackground(new Color(190, 190, 190));
        pn1.setBounds(60, 30, (int) (screenSize.getWidth() / 2) - 100, (int) (screenSize.getHeight() / 1.5));
        pn1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        pn2 = new JLabel();
        pn2.setBackground(new Color(190, 190, 190));
        pn2.setBounds((int) (screenSize.getWidth() / 2) - 100 + 120, 30, (int) (screenSize.getWidth() / 2) - 100, (int) (screenSize.getHeight() / 1.5));
        pn2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addImgBtn = new JButton();
        addImgBtn.setBounds((int) (screenSize.getWidth() / 4), (int) (screenSize.getHeight() / 1.5) / 2, 50, 50);
        addIcon = new ImageIcon("image\\add.png");
        addIcon = new ImageIcon(addIcon.getImage().getScaledInstance(50, 50, BufferedImage.SCALE_DEFAULT));
        addImgBtn.setIcon(addIcon);

        btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(60, (int) (screenSize.getHeight() / 1.5) + 30 + 60, 100, 40);

        btnScaleGray = new JButton("Gray Scale");
        btnScaleGray.setBounds(60 + 40 + btnRefresh.getWidth(), (int) (screenSize.getHeight() / 1.5) + 30 + 60, 100, 40);
        btnSharpener = new JButton("Sharpen");
        btnSharpener.setBounds(60 + 40 * 2 + btnRefresh.getWidth() * 2, (int) (screenSize.getHeight() / 1.5) + 30 + 60, 100, 40);
        btnExcute = new JButton("Excute");
        btnExcute.setBounds(60, (int) (screenSize.getHeight() / 1.5) + 30 + 60 + btnScaleGray.getHeight() + 30, 100, 40);

        diffirent = new JLabel("difference: " + diffirentPercentage + " pixel");
        diffirent.setBounds(60, (int) (screenSize.getHeight() / 1.5) + 30 + 100 + btnScaleGray.getHeight() + 30, 500, 40);
        diffirent.setFont(new Font("Courier New", Font.ITALIC, 20));
    }

    private void addComponent() {
        frame.add(pn1);
        frame.add(pn2);
        frame.add(addImgBtn);
        frame.add(btnRefresh);
        frame.add(btnScaleGray);
        frame.add(btnSharpener);
        frame.add(diffirent);
//        frame.add(btnExcute);
    }

    private void addEvent() {
        addImgBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser("C:\\Users\\Wind\\Documents\\NetBeansProjects\\codese-basic-04\\Multimedia");
                int a = chooser.showOpenDialog(frame);
                if (a == JFileChooser.APPROVE_OPTION) {
                    choosePath = (chooser.getSelectedFile().getAbsolutePath());
                    chooseFileName = (chooser.getSelectedFile().getName());
                    imgPn1 = new ImageIcon(choosePath);
                    imgPn1 = new ImageIcon(imgPn1.getImage().getScaledInstance(pn1.getWidth(), pn1.getHeight(), BufferedImage.SCALE_DEFAULT));
                    pn1.setIcon(imgPn1);
                    addImgBtn.setVisible(false);
                }

            }
        });
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pn1.setIcon(null);
                pn2.setIcon(null);
                addImgBtn.setVisible(true);
                diffirentPercentage = 0;
            }
        });
        btnScaleGray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (pn1.getIcon() != null) {
                    File afterScale = new GrayScale().Excute(choosePath);
                    imgPn2 = new ImageIcon(afterScale.getPath());
                    imgPn2 = new ImageIcon(imgPn2.getImage().getScaledInstance(pn2.getWidth(), pn2.getHeight(), BufferedImage.SCALE_DEFAULT));
                    pn2.setIcon(imgPn2);
                    File Origin = new File(choosePath);
                    diffirentPercentage = new Compare().Compares(Origin, afterScale);
                    diffirent.setText("difference: " + diffirentPercentage + " pixel");
                }
            }
        });
        btnSharpener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (pn1.getIcon() != null) {
                    File origin = new File(choosePath);
                    try {
                        File afterSharpen = new Sharpen().Excute(origin);
                        imgPn2 = new ImageIcon(afterSharpen.getPath());
                        imgPn2 = new ImageIcon(imgPn2.getImage().getScaledInstance(pn2.getWidth(), pn2.getHeight(), BufferedImage.SCALE_DEFAULT));
                        pn2.setIcon(imgPn2);
                        diffirentPercentage = new Compare().Compares(origin, afterSharpen);
                        diffirent.setText("difference: " + diffirentPercentage + " pixel");
                    } catch (IOException ex) {
                        Logger.getLogger(Multimedia.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
    }

    private void showGUI() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Multimedia();
    }

}
