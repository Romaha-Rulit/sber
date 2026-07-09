package com.sber.dz3.figures;

public abstract class Figure {
    protected Point center;

    public Figure(Point center) {
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public abstract double area();
    public abstract double perimeter();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " с центром в " + center;
    }
}
