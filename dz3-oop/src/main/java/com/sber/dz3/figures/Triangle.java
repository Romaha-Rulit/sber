package com.sber.dz3.figures;

public class Triangle extends Figure implements Drawable {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Point center, double sideA, double sideB, double sideC) {
        super(center);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void draw() {
        draw(Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        System.out.println("Нарисован " + color.getRussianName() + " треугольник с центром в " + center +
                ", стороны = " + String.format("%.2f", sideA) +
                ", " + String.format("%.2f", sideB) +
                ", " + String.format("%.2f", sideC) +
                ", площадь = " + String.format("%.2f", area()) +
                ", периметр = " + String.format("%.2f", perimeter()));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "center=" + center +
                ", sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}
