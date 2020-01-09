/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Wind
 */
public class GreenImage {

    public File Excute(String src) throws IOException {
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(src);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int g = (p >> 8) & 0xff;
                p = (a << 24) | (0 << 16) | (g << 8) | 0;
                img.setRGB(x, y, p);
            }
        }
        File f2 = new File("data\\" + f.getName() + "_Green.png");
        ImageIO.write(img, "png", f2);
        return f2;
    }
}
