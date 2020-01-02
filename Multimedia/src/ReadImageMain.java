
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.*;
import javax.imageio.ImageIO;

public class ReadImageMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Image Source
        File originalImage = new File("image.png");

        BufferedImage img = null;
        try {
            img = ImageIO.read(originalImage);

            //Image for grayscalling
            BufferedImage grayscaleImage = new BufferedImage(
                    img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);

            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    //Get RGB Color on each pixel
                    Color c = new Color(img.getRGB(i, j));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    int a = c.getAlpha();

                    // SImple graysacaling = (r+g+b/ 3
                    int gr = (r + g + b) / 3;
                    System.out.print(gr+" ");
                    //Create graycolor
                    Color gColor = new Color(gr, gr, gr, a);
                    grayscaleImage.setRGB(i, j, gColor.getRGB());

                }
                System.out.println();
            }
            ImageIO.write(grayscaleImage, "png", new File("grayscale.png"));

        } catch (IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
