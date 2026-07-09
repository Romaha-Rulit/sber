package com.sber.dz3.figures;

public class Square extends Rectangle {
    public Square(Point center, double side) {
        super(center, side, side);
    }

    public double getSide() {
        return getWidth();
    }

    @Override
    public void draw() {
        draw(Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        System.out.println("Нарисован " + color.getRussianName() + " квадрат с центром в " + center +
                ", сторона = " + String.format("%.2f", getSide()) +
                ", площадь = " + String.format("%.2f", area()) +
                ", периметр = " + String.format("%.2f", perimeter()));
    }

    @Override
    public String toString() {
        return "Square{" +
                "center=" + center +
                ", side=" + getSide() +
                '}';
    }
}
