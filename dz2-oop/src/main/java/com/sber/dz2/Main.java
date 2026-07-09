package com.sber.dz2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация DZ2 ===\n");

        // Книга
        Author author = new Author("Лев Толстой", "Мужской", "tolstoy@example.com");
        Book book = new Book("Война и мир", author, 1869);
        System.out.println(book);
        System.out.println();

        // Круг
        Circle circle = new Circle("синий", 5.0);
        System.out.println("Площадь круга: " + circle.area());
        System.out.println("Периметр круга: " + circle.perimeter());
        System.out.println(circle);
        System.out.println();

        // Матрица
        double[][] data1 = {{1, 2}, {4, 5}};
        double[][] data2 = {{7, 8}, {10, 11}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        System.out.println("Матрица 1:");
        matrix1.print();
        System.out.println("Матрица 1 + Матрица 2:");
        matrix1.plus(matrix2).print();
        System.out.println();

        // Телефон
        Phone phone = new Phone("892100000", "Iphone 17 pro", 450);
        phone.receiveCall("Рома");
        System.out.println(phone);
        System.out.println();

        // Пицца
        PizzaOrder order = new PizzaOrder(
                "Аль-Капчоне",
                PizzaOrder.Size.BIG,
                true,
                "Ярославская 101"
        );
        order.order();
    }
}
