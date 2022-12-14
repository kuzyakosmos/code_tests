package leetcode;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));

        }
        System.out.println();
        setMatrixZeroes.setZeroes(matrix);
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }

    public void setZeroes(int[][] matrix) {
        int[] zeroColumns = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            boolean zeroRow = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setZeroColumnNumber(zeroColumns, j);
                    zeroRow = true;
                }
            }
            if (zeroRow) setZeroRow(matrix[i]);
        }
        System.out.println(Arrays.toString(zeroColumns));
        for (int column = 0; column < matrix[0].length; column++) {
            if (zeroColumns[column] == 1) {
                System.out.println("Обнуление колонки " + column);
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][column] = 0;
                }
            }
        }
    }

    void setZeroColumnNumber(int[] zeroColumns, int column) {
        zeroColumns[column] = 1;
    }

    void setZeroRow(int[] row) {
        Arrays.fill(row, 0);
    }
}
