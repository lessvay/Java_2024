//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            ComplexNumber[][] DoubleMatrix = {
                    { new ComplexNumber(5), new ComplexNumber(4) },
                    { new ComplexNumber(6), new ComplexNumber(5) }
            };
            ComplexMatrix matrix1 = new ComplexMatrix(DoubleMatrix);

            ComplexMatrix matrix2 = new ComplexMatrix(new ComplexNumber[][] {
                    { new ComplexNumber(5, 5), new ComplexNumber(4, 8) },
                    { new ComplexNumber(6, 3), new ComplexNumber(5, 5) },
                    { new ComplexNumber(7, 5), new ComplexNumber(5, 9) },
                    { new ComplexNumber(8, 1), new ComplexNumber(7,3) }
            });

            ComplexMatrix matrix3 = new ComplexMatrix(3, 3);
            ComplexMatrix matrix4 = new ComplexMatrix(new ComplexNumber[][] {
                    { new ComplexNumber(2, 1), new ComplexNumber(1, 0), new ComplexNumber(1, 1) },
                    { new ComplexNumber(1, 0), new ComplexNumber(5, 5), new ComplexNumber(2, 3) }
            });

            ComplexMatrix matrix5 = new ComplexMatrix(new ComplexNumber[][] {
                    { new ComplexNumber(2, 8), new ComplexNumber(1, 6), new ComplexNumber(1, 9) },
                    { new ComplexNumber(1, 0), new ComplexNumber(7, 5), new ComplexNumber(1, 3) }
            });

            // Попытка вычислить детерминант для matrix1
            ComplexNumber determinant = matrix1.determinant();
            System.out.println("Матрица ");
            matrix1.PrintMatrix();
            System.out.println("Детерминант: ");
            determinant.PrintComplexNumber();
            System.out.println("\nСумма matrix4 и matrix5:");
            ComplexMatrix sum=matrix4.subtract(matrix5);
            sum.PrintMatrix();
            System.out.println("\nПроизведение: matrix2 и matrix5");
            ComplexMatrix mul=matrix2.multiply(matrix5);
            mul.PrintMatrix();
            ComplexMatrix matrix2Transpose=matrix2.Transpose();
            System.out.println("\nTраспонированная матрица matrix2");
            matrix2Transpose.PrintMatrix();

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

