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
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author Wind
 */
public class NoiseFilter {

    public File Excute(String src) throws IOException {
        File file = new File(src);
        BufferedImage img = null;
        int r[] = new int[9];
        int g[] = new int[9];
        int b[] = new int[9];
        int rgb;
        Color pixel[] = new Color[9];

        try {
            img = ImageIO.read(file);
        } catch (IOException ex) {
        }
        int w = img.getWidth();
        int h = img.getHeight();
        for (int i = 1; i < w - 1; i++) {
            for (int j = 1; j < h - 1; j++) {
                pixel[0] = new Color(img.getRGB(i - 1, j - 1));
                pixel[1] = new Color(img.getRGB(i - 1, j));
                pixel[2] = new Color(img.getRGB(i - 1, j + 1));
                pixel[3] = new Color(img.getRGB(i, j + 1));
                pixel[4] = new Color(img.getRGB(i + 1, j + 1));
                pixel[5] = new Color(img.getRGB(i + 1, j));
                pixel[6] = new Color(img.getRGB(i + 1, j - 1));
                pixel[7] = new Color(img.getRGB(i, j - 1));
                pixel[8] = new Color(img.getRGB(i, j));
                for (int k = 0; k < 9; k++) {
                    r[k] = pixel[k].getRed();
                    b[k] = pixel[k].getBlue();
                    g[k] = pixel[k].getGreen();
                }
                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);
                img.setRGB(i, j, new Color(r[4], g[4], b[4]).getRGB());
            }

        }
        File f2 = new File("data\\" + file.getName() + "_NoiseFiltered.png");
        ImageIO.write(img, "png", f2);
        return f2;
    }
}
