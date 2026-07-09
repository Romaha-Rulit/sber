package com.sber.dz3.solid;

// OCP: Абстракция (интерфейс)
interface Shape {
    double area();
}

// OCP: Конкретные фигуры
class CircleShape implements Shape {
    private double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class RectangleShape implements Shape {
    private double width;
    private double height;

    public RectangleShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class TriangleShape implements Shape {
    private double base;
    private double height;

    public TriangleShape(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// OCP: Калькулятор (закрыт для изменений, открыт для расширения)
class ShapeAreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}

public class Example2 {
    public static void main(String[] args) {
        System.out.println("=== Пример 2: OCP (Open/Closed Principle) ===\n");
        ShapeAreaCalculator calculator = new ShapeAreaCalculator();

        Shape circle = new CircleShape(5);
        Shape rectangle = new RectangleShape(4, 6);
        Shape triangle = new TriangleShape(3, 4);

        System.out.println("Circle area: " + calculator.calculateArea(circle));
        System.out.println("Rectangle area: " + calculator.calculateArea(rectangle));
        System.out.println("Triangle area: " + calculator.calculateArea(triangle));
    }
}
