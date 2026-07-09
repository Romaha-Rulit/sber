package com.sber.dz3;

import com.sber.dz3.figures.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== КОНСОЛЬНЫЙ PAINT ===\n");

        Circle circle = new Circle(new Point(0, 0), 5);
        Rectangle rectangle = new Rectangle(new Point(3, 4), 6, 4);
        Square square = new Square(new Point(-2, 1), 4);
        Triangle triangle = new Triangle(new Point(1, 2), 3, 4, 5);

        System.out.println("1. ДЕМОНСТРАЦИЯ РАЗНЫХ ФИГУР:");
        System.out.println("------------------------------------");
        circle.draw();
        rectangle.draw();
        square.draw();
        triangle.draw();

        System.out.println("\n2. ДЕМОНСТРАЦИЯ РАЗНЫХ ЦВЕТОВ:");
        System.out.println("------------------------------------");
        circle.draw(Color.RED);
        rectangle.draw(Color.BLUE);
        square.draw(Color.GREEN);
        triangle.draw(Color.PURPLE);

        System.out.println("\n3. ДЕМОНСТРАЦИЯ FigureUtil:");
        System.out.println("------------------------------------");
        System.out.println("Круг: площадь = " + String.format("%.2f", FigureUtil.area(circle)) +
                ", периметр = " + String.format("%.2f", FigureUtil.perimeter(circle)));
        FigureUtil.draw(circle);
        FigureUtil.draw(rectangle, Color.ORANGE);
    }
}
