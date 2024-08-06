package structural.bridge;

import org.junit.Test;

/**
 * Created by lcj on 15-10-31.
 */
public class BridgeTest {
    @Test
    public void test() {
        Shape[] shapes = new Shape[]{new CircleShape(1, 2, 3, new DrawingAPI1()), new CircleShape(5, 7, 11, new DrawingAPI2())};
        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }


    interface DrawingAPI {
        void drawCircle(double x, double y, double radius);
    }


    static class DrawingAPI1 implements DrawingAPI {
        public void drawCircle(double x, double y, double radius) {
            System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
        }
    }


    static class DrawingAPI2 implements DrawingAPI {
        public void drawCircle(double x, double y, double radius) {
            System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
        }
    }

    abstract static class Shape {
        protected DrawingAPI drawingAPI;

        protected Shape(DrawingAPI drawingAPI) {
            this.drawingAPI = drawingAPI;
        }

        public abstract void draw();

        public abstract void resizeByPercentage(double pct);
    }

    /**
     * "Refined Abstraction"
     */
    static class CircleShape extends Shape {
        private final double x;
        private final double y;
        private double radius;

        public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
            super(drawingAPI);
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public void draw() {
            drawingAPI.drawCircle(x, y, radius);
        }

        public void resizeByPercentage(double pct) {
            radius *= (1.0 + pct / 100.0);
        }
    }
}
