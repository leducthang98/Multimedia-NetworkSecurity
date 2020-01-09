/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RedImage {

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
                int r = (p >> 16) & 0xff;
                p = (a << 24) | (r << 16) | (0 << 8) | 0;
                img.setRGB(x, y, p);
            }
        }
        File f2 = new File("data\\" + f.getName() + "_Red.png");
        ImageIO.write(img, "png", f2);
        return f2;
    }
}
