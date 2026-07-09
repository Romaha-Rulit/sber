package com.sber.dz3.figures;

public class FigureUtil {
    private FigureUtil() {}

    public static double area(Figure figure) {
        return figure.area();
    }

    public static double perimeter(Figure figure) {
        return figure.perimeter();
    }

    public static void draw(Figure figure) {
        if (figure instanceof Drawable) {
            ((Drawable) figure).draw();
        } else {
            System.out.println("Фигура не поддерживает рисование");
        }
    }

    public static void draw(Figure figure, Color color) {
        if (figure instanceof Drawable) {
            ((Drawable) figure).draw(color);
        } else {
            System.out.println("Фигура не поддерживает рисование");
        }
    }
}
