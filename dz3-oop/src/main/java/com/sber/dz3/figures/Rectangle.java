package com.sber.dz3.figures;

public class Rectangle extends Figure implements Drawable {
    private double width;
    private double height;

    public Rectangle(Point center, double width, double height) {
        super(center);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        draw(Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        System.out.println("Нарисован " + color.getRussianName() + " прямоугольник с центром в " + center +
                ", ширина = " + String.format("%.2f", width) +
                ", высота = " + String.format("%.2f", height) +
                ", площадь = " + String.format("%.2f", area()) +
                ", периметр = " + String.format("%.2f", perimeter()));
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "center=" + center +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
