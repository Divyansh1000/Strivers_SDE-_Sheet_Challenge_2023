package Arrays;

import java.util.*;

public class Set_Matrix_Zeros {
    // ...............OPTIMAL APPROACH................
    private static ArrayList<ArrayList<Integer>> setZerosViaOptimalAppraoch(ArrayList<ArrayList<Integer>> matrix) {
        int row = matrix.size();
        int col = matrix.get(0).size();

        int col0 = 1;
        // step 1: Traverse the matrix and mark 1st row & col accordingly:
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark i-th row:
                    matrix.get(i).set(0, 0);

                    // mark j-th column:
                    if (j != 0) {
                        matrix.get(0).set(j, 0);
                    } else
                        col0 = 0;
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix.get(i).get(j) != 0) {
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0)
                        matrix.get(i).set(j, 0);
                }
            }
        }

        // step 3: Finally mark the 1st col & then 1st row:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < col; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < row; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }

    // ................BETTER APPROACH ...........
    static ArrayList<ArrayList<Integer>> setZerosViaBetterApproach(ArrayList<ArrayList<Integer>> matrix) {
        int row = matrix.size();
        int col = matrix.get(0).size();

        int[] rowArray = new int[row];
        int[] colArray = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith and jth index of row and col with 1
                    rowArray[i] = 1;
                    colArray[j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowArray[i] == 1 || colArray[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    // ................BRUTE FORCE APPROACH...........

    // set all non-zero elements as -1 in the row i:
    static void markRow(ArrayList<ArrayList<Integer>> matrix, int i) {
        int col = matrix.get(0).size();

        for (int j = 0; j < col; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    // set all non-zero elements as -1 in the col j:
    static void markCol(ArrayList<ArrayList<Integer>> matrix, int j) {
        int row = matrix.size();

        for (int i = 0; i < row; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
    static ArrayList<ArrayList<Integer>> setZerosViaBruteForce(ArrayList<ArrayList<Integer>> matrix) {

        int row = matrix.size();
        int col = matrix.get(0).size();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == -1)
                    matrix.get(i).set(j, 0);
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        // ArrayList<ArrayList<Integer>> updateMatrixBFA =
        // setZerosViaBruteForce(matrix);
        // ArrayList<ArrayList<Integer>> updateMatrixViaBA =
        // setZerosViaBetterApproach(matrix);
        ArrayList<ArrayList<Integer>> updateMatrixViaOA = setZerosViaOptimalAppraoch(matrix);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : updateMatrixViaOA) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

}
