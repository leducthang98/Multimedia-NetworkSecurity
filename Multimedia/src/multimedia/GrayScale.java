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
public class GrayScale {

    public File Excute(String src) {
        File originalImage = new File(src);
        BufferedImage img = null;
        try {
            img = ImageIO.read(originalImage);
            BufferedImage grayscaleImage = new BufferedImage(
                    img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    Color c = new Color(img.getRGB(i, j));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    int a = c.getAlpha();

                    int gr = (r + g + b) / 3;
                    Color gColor = new Color(gr, gr, gr, a);
                    grayscaleImage.setRGB(i, j, gColor.getRGB());
                }
                System.out.println();
            }
            File f = new File("data\\" + originalImage.getName() + "_GrayScaled.png");
            ImageIO.write(grayscaleImage, "png", f);
            return f;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
