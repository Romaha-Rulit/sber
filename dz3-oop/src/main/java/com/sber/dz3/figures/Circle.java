package com.sber.dz3.figures;

public class Circle extends Figure implements Drawable {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        draw(Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        System.out.println("Нарисован " + color.getRussianName() + " круг с центром в " + center +
                ", радиусом " + String.format("%.2f", radius) +
                ", площадь = " + String.format("%.2f", area()) +
                ", периметр = " + String.format("%.2f", perimeter()));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
