/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson05;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Wind
 */
public class SampleJFrame extends JFrame{

    public SampleJFrame() throws HeadlessException {
        setTitle("demo");
        setSize(1000, 1000);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.fill3DRect(100, 100, 300, 300, true);
        Image image = new ImageIcon("http://genknews.genkcdn.vn/thumb_w/660/2019/11/20/vsmart-live-tgdd-2-15742208848651668073505.jpg").getImage();
        g.drawImage(image, 500, 500, this);
    }

    
    
    public static void main(String[] args) {
      new SampleJFrame().setVisible(true);
    }
}
