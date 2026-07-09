package com.sber.dz2;

public class Circle {
    private double radius;
    private String color;

    public Circle(String color, double radius) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "радиус: " + radius + "\n" +
                "цвет: " + color + "\n" +
                "периметр: " + perimeter();
    }
}
