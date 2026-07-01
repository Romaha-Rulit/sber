// 1. Абстракция (интерфейс)
interface Shape {
    double area();
}

// 2. Конкретные фигуры
class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Triangle implements Shape {
    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// 3. Калькулятор (закрыт для изменений, открыт для расширения)
class ShapeAreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}

// Использование в main
public class Example2 {
    public static void main(String[] args) {
        ShapeAreaCalculator calculator = new ShapeAreaCalculator();

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4);

        System.out.println("Circle area: " + calculator.calculateArea(circle));
        System.out.println("Rectangle area: " + calculator.calculateArea(rectangle));
        System.out.println("Triangle area: " + calculator.calculateArea(triangle));
    }
}