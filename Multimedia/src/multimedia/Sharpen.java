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
public class Sharpen {

    int[][] kernel = {
        {0, -1, 0},
        {-1, 5, -1},
        {0, -1, 0},};
    int[][] matrixPixelR = new int[3][3];
    int[][] matrixPixelG = new int[3][3];
    int[][] matrixPixelB = new int[3][3];
    int[][] matrixPixelA = new int[3][3];

    public File Excute(File f) throws IOException {
        BufferedImage img = ImageIO.read(f);
        int height = img.getHeight();
        int width = img.getWidth();
        for (int x = 1; x < width - 1; x++) {
            for (int y = 1; y < height - 1; y++) {
                matrixPixelR[0][0] = new Color(img.getRGB(x - 1, y - 1)).getRed();
                matrixPixelR[0][1] = new Color(img.getRGB(x - 1, y)).getRed();
                matrixPixelR[0][2] = new Color(img.getRGB(x - 1, y + 1)).getRed();
                matrixPixelR[1][0] = new Color(img.getRGB(x, y - 1)).getRed();
                matrixPixelR[1][1] = new Color(img.getRGB(x, y)).getRed();
                matrixPixelR[1][2] = new Color(img.getRGB(x, y + 1)).getRed();
                matrixPixelR[2][0] = new Color(img.getRGB(x + 1, y - 1)).getRed();
                matrixPixelR[2][1] = new Color(img.getRGB(x + 1, y)).getRed();
                matrixPixelR[2][2] = new Color(img.getRGB(x + 1, y + 1)).getRed();
                int currentR = kernel[0][0] * matrixPixelR[0][0]
                        + kernel[0][1] * matrixPixelR[0][1]
                        + kernel[0][2] * matrixPixelR[0][2]
                        + kernel[1][0] * matrixPixelR[1][0]
                        + kernel[1][1] * matrixPixelR[1][1]
                        + kernel[1][2] * matrixPixelR[1][2]
                        + kernel[2][0] * matrixPixelR[2][0]
                        + kernel[2][1] * matrixPixelR[2][1]
                        + kernel[2][2] * matrixPixelR[2][2];
                if (currentR > 255) {
                    currentR = 255;
                } else if (currentR < 0) {
                    currentR = 0;
                }

                matrixPixelG[0][0] = new Color(img.getRGB(x - 1, y - 1)).getGreen();
                matrixPixelG[0][1] = new Color(img.getRGB(x - 1, y)).getGreen();
                matrixPixelG[0][2] = new Color(img.getRGB(x - 1, y + 1)).getGreen();
                matrixPixelG[1][0] = new Color(img.getRGB(x, y - 1)).getGreen();
                matrixPixelG[1][1] = new Color(img.getRGB(x, y)).getGreen();
                matrixPixelG[1][2] = new Color(img.getRGB(x, y + 1)).getGreen();
                matrixPixelG[2][0] = new Color(img.getRGB(x + 1, y - 1)).getGreen();
                matrixPixelG[2][1] = new Color(img.getRGB(x + 1, y)).getGreen();
                matrixPixelG[2][2] = new Color(img.getRGB(x + 1, y + 1)).getGreen();
                int currentG = kernel[0][0] * matrixPixelG[0][0]
                        + kernel[0][1] * matrixPixelG[0][1]
                        + kernel[0][2] * matrixPixelG[0][2]
                        + kernel[1][0] * matrixPixelG[1][0]
                        + kernel[1][1] * matrixPixelG[1][1]
                        + kernel[1][2] * matrixPixelG[1][2]
                        + kernel[2][0] * matrixPixelG[2][0]
                        + kernel[2][1] * matrixPixelG[2][1]
                        + kernel[2][2] * matrixPixelG[2][2];
                if (currentG > 255) {
                    currentG = 255;
                } else if (currentG < 0) {
                    currentG = 0;
                }

                matrixPixelB[0][0] = new Color(img.getRGB(x - 1, y - 1)).getBlue();
                matrixPixelB[0][1] = new Color(img.getRGB(x - 1, y)).getBlue();
                matrixPixelB[0][2] = new Color(img.getRGB(x - 1, y + 1)).getBlue();
                matrixPixelB[1][0] = new Color(img.getRGB(x, y - 1)).getBlue();
                matrixPixelB[1][1] = new Color(img.getRGB(x, y)).getBlue();
                matrixPixelB[1][2] = new Color(img.getRGB(x, y + 1)).getBlue();
                matrixPixelB[2][0] = new Color(img.getRGB(x + 1, y - 1)).getBlue();
                matrixPixelB[2][1] = new Color(img.getRGB(x + 1, y)).getBlue();
                matrixPixelB[2][2] = new Color(img.getRGB(x + 1, y + 1)).getBlue();
                int currentB = kernel[0][0] * matrixPixelB[0][0]
                        + kernel[0][1] * matrixPixelB[0][1]
                        + kernel[0][2] * matrixPixelB[0][2]
                        + kernel[1][0] * matrixPixelB[1][0]
                        + kernel[1][1] * matrixPixelB[1][1]
                        + kernel[1][2] * matrixPixelB[1][2]
                        + kernel[2][0] * matrixPixelB[2][0]
                        + kernel[2][1] * matrixPixelB[2][1]
                        + kernel[2][2] * matrixPixelB[2][2];
                if (currentB > 255) {
                    currentB = 255;
                } else if (currentB < 0) {
                    currentB = 0;
                }
                Color c = new Color(currentR, currentG, currentB);
                img.setRGB(x, y, c.getRGB());

            }
        }
        File f2 = new File("data\\" + f.getName() + "_Sharpened.png");
        ImageIO.write(img, "png", f2);
        return f2;
    }
}
