/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keylistenersample;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Wind
 */
public class KeyListenerSample extends JFrame implements KeyListener {
    
    public KeyListenerSample() {
        this.addKeyListener(this);
        setVisible(true);
       
    }
    
    public static void main(String[] args) {
        
        new KeyListenerSample();
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("len tren");
        }
        if (ke.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("xuong duoi");
        }
        if (ke.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("sang trai");
        }
        if (ke.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("sang phai");
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
       }
    
}
