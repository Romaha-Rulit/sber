public class Matrix {
    double[][] matrix;
    int row;
    int col;

    public Matrix(int row, int col){
        this.col=col;
        this.row=row;
        this.matrix=new double[row][col];
    }

    public Matrix(double[][] matrix){
        this.row=matrix.length;
        this.col=matrix[0].length;
        this.matrix=new double[row][col];
        for (int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                this.matrix[i][j]=matrix[i][j];
            }
        }
    }

    public void setValue(int i, int j, double value){
        if (i>=0 && i<row && j>=0 && j<col) {
            matrix[i][j] = value;
        }else{
            System.out.println("выход за границы");
        }
    }

    public void print(){
        for (int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public Matrix Plus(Matrix other){
        Matrix result = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix Umnoz_chislo(double number){
        Matrix result = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result.matrix[i][j] = this.matrix[i][j] * number;
            }
        }
        return result;
    }

    public Matrix Umnoz_Matrix(Matrix other) {
        Matrix result = new Matrix(this.row, other.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < other.col; j++) {
                double sum = 0;
                for (int k = 0; k < this.col; k++) {
                    sum += this.matrix[i][k] * other.matrix[k][j];
                }
                result.matrix[i][j] = sum;
            }
        }
        return result;
    }
}
