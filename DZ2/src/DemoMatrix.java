public class DemoMatrix {
    static void main() {
        double[][] data1 = {
                {1.0, 2.0},
                {4.0, 5.0}
        };

        double[][] data2 = {
                {7.0, 8.0},
                {10.0, 11.0}
        };

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        System.out.println("Матрица 1:");
        matrix1.print();

        System.out.println("\nМатрица 2:");
        matrix2.print();

        System.out.println("\nИзменение элемента ");
        matrix1.setValue(0, 0, 99);
        matrix1.print();

        System.out.println("\nСложение матриц:");
        Matrix sum = matrix1.Plus(matrix2);
            sum.print();

        System.out.println("\nУмножение matrix1 на 2:");
        Matrix multiplied = matrix1.Umnoz_chislo(2);
        multiplied.print();

        Matrix product = matrix1.Umnoz_Matrix(matrix2);
        product.print();
    }
}
