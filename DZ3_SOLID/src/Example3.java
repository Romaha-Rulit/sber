// 1. Общий интерфейс
interface Shape3 {
    int getArea();
}

// 2. Прямоугольник
class Rectangle3 implements Shape3 {
    protected int width;
    protected int height;

    public Rectangle3(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

// 3. Квадрат (самостоятельный класс)
class Square3 implements Shape3 {
    private int side;

    public Square3(int side) {
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

// Использование в main
public class Example3 {
    public static void main(String[] args) {
        // Прямоугольник
        Rectangle3 rect = new Rectangle3(4, 5);
        System.out.println("Rectangle area: " + rect.getArea());

        // Квадрат
        Square3 square = new Square3(4);
        System.out.println("Square area: " + square.getArea());

        // Полиморфное использование
        Shape3 shape1 = new Rectangle3(3, 7);
        Shape3 shape2 = new Square3(5);
        System.out.println("Shape1 area: " + shape1.getArea());
        System.out.println("Shape2 area: " + shape2.getArea());
    }
}