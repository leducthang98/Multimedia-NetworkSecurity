
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.ImageObserver;
import java.awt.image.Kernel;

public class BufferedImageSharpen {

    static BufferedImage image;
    static boolean imageLoaded = false;

    public static void main(String[] args) {

        // The ImageObserver implementation to observe loading of the image
        ImageObserver myImageObserver = new ImageObserver() {

            @Override
            public boolean imageUpdate(Image image, int flags, int x, int y, int width, int height) {

                if ((flags & ALLBITS) != 0) {

                    imageLoaded = true;

                    System.out.println("Image loading finished!");

                    return false;

                }

                return true;

            }
        };

        // The image URL - change to where your image file is located!
        String imageURL = "NA.png";

        /**
         *
         * This call returns immediately and pixels are loaded in the background
         *
         * We use an ImageObserver to be notified when the loading of the image
         *
         * is complete
         *
         */
        Image sourceImage = Toolkit.getDefaultToolkit().getImage(imageURL);

        sourceImage.getWidth(myImageObserver);

        // We wait until the image is fully loaded
        while (!imageLoaded) {

            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
            }

        }

        // Create a buffered image from the source image with a format that's compatible with the screen
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

        GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();

        GraphicsConfiguration graphicsConfiguration = graphicsDevice.getDefaultConfiguration();

        // If the source image has no alpha info use Transparency.OPAQUE instead
        image = graphicsConfiguration.createCompatibleImage(sourceImage.getWidth(null), sourceImage.getHeight(null), Transparency.BITMASK);

        // Copy image to buffered image
        Graphics graphics = image.createGraphics();

        // Paint the image onto the buffered image
        graphics.drawImage(sourceImage, 0, 0, null);

        graphics.dispose();

        // A 3x3 kernel that sharpens an image
        Kernel kernel = new Kernel(3, 3,
                new float[]{
                    -1, -1, -1,
                    -1, 9, -1,
                    -1, -1, -1});

        BufferedImageOp op = new ConvolveOp(kernel);

        image = op.filter(image, null);

        // Create frame with specific title
        Frame frame = new Frame("Example Frame");

        // Add a component with a custom paint method
        frame.add(new CustomPaintComponent());

        // Display the frame
        int frameWidth = 300;

        int frameHeight = 300;

        frame.setSize(frameWidth, frameHeight);

        frame.setVisible(true);

    }

    /**
     * To draw on the screen, it is first necessary to subclass a Component and
     * override its paint() method. The paint() method is automatically called
     * by the windowing system whenever component's area needs to be repainted.
     */
    static class CustomPaintComponent extends Component {

        @Override
        public void paint(Graphics g) {

// Retrieve the graphics context; this object is used to paint
// shapes
            Graphics2D g2d = (Graphics2D) g;

            /**
             * Draw an Image object The coordinate system of a graphics context
             * is such that the origin is at the northwest corner and x-axis
             * increases toward the right while the y-axis increases toward the
             * bottom.
             */
            int x = 0;
            int y = 0;
            g2d.drawImage(image, x, y, this);
        }
    }
}
