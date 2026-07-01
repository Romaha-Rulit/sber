class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}

abstract class Figure {
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

enum Color {
    BLACK("черный"),
    RED("красный"),
    GREEN("зеленый"),
    BLUE("синий"),
    YELLOW("желтый"),
    PURPLE("фиолетовый"),
    ORANGE("оранжевый");

    private final String russianName;

    Color(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}

interface Drawable {
    void draw();
    void draw(Color color);
}

class Circle extends Figure implements Drawable {
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

class Rectangle extends Figure implements Drawable {
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

class Square extends Rectangle {
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

class Triangle extends Figure implements Drawable {
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

class FigureUtil {
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

        System.out.println("Прямоугольник: площадь = " + String.format("%.2f", FigureUtil.area(rectangle)) +
                ", периметр = " + String.format("%.2f", FigureUtil.perimeter(rectangle)));

        System.out.println("Квадрат: площадь = " + String.format("%.2f", FigureUtil.area(square)) +
                ", периметр = " + String.format("%.2f", FigureUtil.perimeter(square)));

        System.out.println("Треугольник: площадь = " + String.format("%.2f", FigureUtil.area(triangle)) +
                ", периметр = " + String.format("%.2f", FigureUtil.perimeter(triangle)));

        System.out.println("\n4. ДЕМОНСТРАЦИЯ РИСОВАНИЯ ЧЕРЕЗ FigureUtil:");
        System.out.println("------------------------------------");

        FigureUtil.draw(circle);
        FigureUtil.draw(rectangle, Color.ORANGE);
        FigureUtil.draw(square, Color.YELLOW);
        FigureUtil.draw(triangle, Color.RED);

        System.out.println("\n5. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА:");
        System.out.println("------------------------------------");

        Figure[] figures = {
                circle,
                rectangle,
                square,
                triangle
        };

        for (Figure figure : figures) {
            System.out.println("Фигура: " + figure.getClass().getSimpleName());
            System.out.println("  Площадь: " + String.format("%.2f", FigureUtil.area(figure)));
            System.out.println("  Периметр: " + String.format("%.2f", FigureUtil.perimeter(figure)));
            FigureUtil.draw(figure, Color.BLUE);
            System.out.println();
        }

        System.out.println("\n6. ДЕМОНСТРАЦИЯ TO STRING:");
        System.out.println("------------------------------------");

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);
        System.out.println(triangle);
    }
}