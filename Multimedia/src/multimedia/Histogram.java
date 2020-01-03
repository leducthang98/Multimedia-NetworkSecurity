/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Wind
 */
public class Histogram {

    public File Excute(String src) throws IOException {
        File originalImage = new File(src);
        BufferedImage img = null;
        img = ImageIO.read(originalImage);
        BufferedImage nImg = new BufferedImage(img.getWidth(), img.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();
        WritableRaster er = nImg.getRaster();
        int totpix = wr.getWidth() * wr.getHeight();
        int[] histogram = new int[256];

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                histogram[wr.getSample(x, y, 0)]++;
            }
        }

        int[] chistogram = new int[256];
        chistogram[0] = histogram[0];
        for (int i = 1; i < 256; i++) {
            chistogram[i] = chistogram[i - 1] + histogram[i];
        }

        float[] arr = new float[256];
        for (int i = 0; i < 256; i++) {
            arr[i] = (float) ((chistogram[i] * 255.0) / (float) totpix);
        }

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                int nVal = (int) arr[wr.getSample(x, y, 0)];
                er.setSample(x, y, 0, nVal);
            }
        }
        nImg.setData(er);
        File f = new File("data\\" + originalImage.getName() + "_Histogram.png");
        ImageIO.write(nImg, "png", f);
        return f;
    }
}
