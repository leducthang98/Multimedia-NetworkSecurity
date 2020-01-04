package multimedia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Compare {

    int totalPixelDiff = 1;
    BufferedImage imgA = null;
    BufferedImage imgB = null;
    long difference = 0;
    long percentage = 0;

    public Compare() {
    }
    int widthA, widthB, heightA, heightB;

    public int[] Compares(File fileA, File fileB) {
        try {
            imgA = ImageIO.read(fileA);
            imgB = ImageIO.read(fileB);
        } catch (IOException e) {
            System.out.println(e);
        }

        widthA = imgA.getWidth();
        widthB = imgB.getWidth();
        heightA = imgA.getHeight();
        heightB = imgB.getHeight();
        if ((widthA != widthB) || (heightA != heightB)) {
            System.out.println("Error: Images dimensions"
                    + " mismatch");
        } else {
            for (int y = 0; y < heightA; y++) {
                for (int x = 0; x < widthA; x++) {
                    int rgbA = imgA.getRGB(x, y);
                    int rgbB = imgB.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA) & 0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB) & 0xff;
                    if (redB != redA || greenA != greenB || blueA != blueB) {
                        int differenceRed = Math.abs(redA - redB);
                        int differenceGreen = Math.abs(greenA - greenB);
                        int differenceBlue = Math.abs(blueA - blueB);
                        int avg = (differenceRed + differenceGreen + differenceBlue) / 3;

                        difference += avg;
                        totalPixelDiff++;
                    }
                }
            }
        }
        long percent = (long) (difference * 100) / (totalPixelDiff * 256);
        System.out.println("compare: " + difference + ":" + totalPixelDiff);
        System.out.println("percent: " + percent);
        int returnStatement[] = new int[2];
        returnStatement[0] = totalPixelDiff;
        returnStatement[1] = (int) percent;
        return returnStatement;
    }

    public static void main(String[] args) {

    }
}
