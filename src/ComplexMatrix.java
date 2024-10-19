import java.util.Arrays;
public class ComplexMatrix {
    private ComplexNumber[][] matrix;
    private final int rows;
    private final int  cols;

    private void getMinor(ComplexNumber[][] matrix, ComplexNumber[][] tempMatrix, int row, int col, int n) {
        int i = 0, j = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r != row && c != col) {
                    tempMatrix[i][j++] = matrix[r][c];

                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    private ComplexNumber determinantCount(ComplexNumber[][] matrix,int n){
        if (n == 1) {
            return matrix[0][0];
        }
        ComplexNumber result=new ComplexNumber();
        ComplexNumber[][] tempMatrix = new ComplexNumber[n][n];

        for (int p = 0; p < n; p++) {
            getMinor(matrix, tempMatrix, 0, p, n);
            result = result.add(matrix[0][p].mul(determinantCount(tempMatrix, n - 1)).mul(new ComplexNumber(Math.pow(-1, p), 0)));
        }
        return result;

    }
    public ComplexMatrix(int rows, int cols){
        this.rows=rows;
        this.cols=cols;
        this.matrix=new ComplexNumber[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = new ComplexNumber(0, 0);
            }
        }
    }
    public ComplexMatrix(ComplexNumber[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = matrix;
    }

    public void setMatrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }
    public void set(int row,int cols,ComplexNumber value){
        this.matrix[row][cols]=value;
    }
    public ComplexNumber get(int row,int cols){
        return matrix[row][cols];
    }
    public int getRow(){
        return this.rows;
    }
    public int getCols(){
        return this.cols;
    }
    public ComplexMatrix add(ComplexMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }

        ComplexMatrix result = new ComplexMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, this.get(i, j).add(other.get(i, j)));
            }
        }

        return result;
    }
    public ComplexMatrix subtract(ComplexMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }

        ComplexMatrix result = new ComplexMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, this.get(i, j).sub(other.get(i, j)));
            }
        }

        return result;
    }
    public ComplexMatrix multiply(ComplexMatrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы не совпадает с количеством строк второй матрицы");
        }

        ComplexMatrix result = new ComplexMatrix(this.rows, other.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                ComplexNumber sum = new ComplexNumber(0, 0);
                for (int k = 0; k < this.cols; k++) {
                    sum = sum.add(this.get(i, k).mul(other.get(k, j)));
                }
                result.set(i, j, sum);
            }
        }

        return result;
    }
    public ComplexNumber determinant(){
        if (this.rows!=this.cols){
            throw new IllegalArgumentException("Матрица должна быть квадратной");
        }
        ComplexNumber result=new ComplexNumber(0,0);
        result=determinantCount(this.matrix,this.cols);
        return result;


    }
    public ComplexMatrix Transpose(){
        ComplexMatrix result=new ComplexMatrix(this.cols,this.rows);
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.cols;j++){
                result.set(j,i,this.get(i,j));
            }
        }
        return result;
    }

    public void PrintMatrix(){
        for(int i=0;i<this.rows;i++)
        {
            for(int j=0;j<this.cols;j++)
            {
                this.get(i,j).PrintComplexNumber();
                System.out.print("\t\t");
            }
            System.out.println();
        }

    }
}
