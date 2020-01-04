/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** 
 *
 * @author Wind
 */
public class BinaryImage {

    public File Excute(String src) throws IOException {
        File f = new File(src);
        int threshold = 127;
        BufferedImage img = null;
        img = ImageIO.read(f);
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                Color c = new Color(img.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();

                int gr = (r + g + b) / 3;
                if (gr > threshold) {
                    img.setRGB(i, j, 0xFFFFFFFF);
                } else {
                    img.setRGB(i, j, 0xFF000000);
                }
            }
            System.out.println();
        }
        File f2 = new File("data\\" + f.getName() + "_Binaried.png");
        ImageIO.write(img, "png", f2);
        return f2;
    }
}
