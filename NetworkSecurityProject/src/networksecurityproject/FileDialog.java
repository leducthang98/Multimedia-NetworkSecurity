/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksecurityproject;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Wind
 */
public class FileDialog extends JFrame {

    public String choosePath = "";
    public String chooseFileName = "";

    public FileDialog(String user) {
        JFileChooser chooser = new JFileChooser("G:\\DataDigitalSignatureProject\\" + user);
        int a = chooser.showOpenDialog(this);
        if (a == JFileChooser.APPROVE_OPTION) {
            choosePath = (chooser.getSelectedFile().getPath());
            chooseFileName = (chooser.getSelectedFile().getName());
        }

    }

}
