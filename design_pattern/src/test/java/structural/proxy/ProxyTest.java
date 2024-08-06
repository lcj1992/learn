package structural.proxy;

import org.junit.Test;

/**
 * Created by lcj on 15-10-31.
 */

public class ProxyTest {
    @Test
    public void test() {
        final Image IMAGE1 = new ProxyImage("HiRes_10MB_Photo1");
        final Image IMAGE2 = new ProxyImage("HiRes_10MB_Photo2");

        IMAGE1.displayImage(); // loading necessary
        IMAGE1.displayImage(); // loading unnecessary
        IMAGE2.displayImage(); // loading necessary
        IMAGE2.displayImage(); // loading unnecessary
        IMAGE1.displayImage(); // loading unnecessary
    }

    interface Image {
        public void displayImage();
    }

    static class RealImage implements Image {

        private String filename = null;


        public RealImage(final String filename) {
            this.filename = filename;
            loadImageFromDisk();
        }

        /**
         * Loads the image from the disk
         */
        private void loadImageFromDisk() {
            System.out.println("Loading   " + filename);
        }

        /**
         * Displays the image
         */
        public void displayImage() {
            System.out.println("Displaying " + filename);
        }

    }

    //on System B
    static class ProxyImage implements Image {

        private RealImage image = null;
        private String filename = null;

        /**
         * Constructor
         *
         * @param filename
         */
        public ProxyImage(final String filename) {
            this.filename = filename;
        }

        /**
         * Displays the image
         */
        public void displayImage() {
            if (image == null) {
                image = new RealImage(filename);
            }
            image.displayImage();
        }

    }
}
