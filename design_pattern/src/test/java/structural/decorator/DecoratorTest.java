package structural.decorator;

import org.junit.Test;

/**
 * Created by lcj on 15-10-31.
 */
public class DecoratorTest {
    @Test
    public void test() {
        // Create a decorated Window with horizontal and vertical scrollbars
        Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));

        // Print the Window's description
        System.out.println(decoratedWindow.getDescription());
    }

    interface Window {
        void draw(); // Draws the Window

        String getDescription(); // Returns a description of the Window
    }

    // Extension of a simple Window without any scrollbars
    static class SimpleWindow implements Window {
        public void draw() {
            // Draw window
        }

        public String getDescription() {
            return "simple window";
        }
    }


    // abstract decorator class - note that it implements Window
    abstract static class WindowDecorator implements Window {
        protected Window windowToBeDecorated; // the Window being decorated

        public WindowDecorator(Window windowToBeDecorated) {
            this.windowToBeDecorated = windowToBeDecorated;
        }

        public void draw() {
            windowToBeDecorated.draw(); //Delegation
        }

        public String getDescription() {
            return windowToBeDecorated.getDescription(); //Delegation
        }
    }

    // The first concrete decorator which adds vertical scrollbar functionality
    static class VerticalScrollBarDecorator extends WindowDecorator {
        public VerticalScrollBarDecorator(Window windowToBeDecorated) {
            super(windowToBeDecorated);
        }

        @Override
        public void draw() {
            super.draw();
            drawVerticalScrollBar();
        }

        private void drawVerticalScrollBar() {
            // Draw the vertical scrollbar
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", including vertical scrollbars";
        }
    }

    // The second concrete decorator which adds horizontal scrollbar functionality
    static class HorizontalScrollBarDecorator extends WindowDecorator {
        public HorizontalScrollBarDecorator(Window windowToBeDecorated) {
            super(windowToBeDecorated);
        }

        @Override
        public void draw() {
            super.draw();
            drawHorizontalScrollBar();
        }

        private void drawHorizontalScrollBar() {
            // Draw the horizontal scrollbar
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", including horizontal scrollbars";
        }
    }
}