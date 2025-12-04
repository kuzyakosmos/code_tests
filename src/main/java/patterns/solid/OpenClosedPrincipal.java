package patterns.solid;

public class OpenClosedPrincipal {

    interface Shape {
        Double area();
    }

    static class Rectangle implements Shape {

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        private final double length;
        private final double width;

        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }

        @Override
        public Double area() {
            return length * width;
        }
    }

    static class Circle implements Shape {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public Double area() {
            return Math.sqrt(radius) * Math.PI;
        }
    }

    //плохо
    class AreaCalculator {
        Double calculateArea(Object shape) {
            if (shape instanceof Rectangle) {
                return ((Rectangle) shape).getLength() * ((Rectangle) shape).getWidth();
            } else if (shape instanceof Circle) {
                return Math.sqrt(((Circle) shape).getRadius()) * Math.PI;
            } else return null;
        }


    }

    // хорошо
    class AreaCalculatorGood {
        Double calculateArea(Shape shape) {
            return shape.area();
        }
    }

}
