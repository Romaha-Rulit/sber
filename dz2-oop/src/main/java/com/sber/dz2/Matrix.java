package com.sber.dz2;

public class Matrix {
    private double[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
    }

    public Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public void setValue(int i, int j, double value) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            matrix[i][j] = value;
        } else {
            throw new IndexOutOfBoundsException("Выход за границы матрицы");
        }
    }

    public double getValue(int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            return matrix[i][j];
        }
        throw new IndexOutOfBoundsException("Выход за границы матрицы");
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public Matrix plus(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix multiplyByScalar(double number) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] * number;
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException(
                "Количество столбцов первой матрицы должно равняться количеству строк второй"
            );
        }
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.matrix[i][k] * other.matrix[k][j];
                }
                result.matrix[i][j] = sum;
            }
        }
        return result;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
