package Arrays_2;

public class Rotate_Matrix {
//............OPTIMAL SOLUTION...........
    static int[][] rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length - 1; i++) {

            for (int j = i + 1; j < matrix.length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        return matrix;
    }

    // //.......BRUTE FORCE APPROACH..........
    // static int[][] rotate(int [][] matrix){
    // int n = matrix.length;

    // int rotated[][] = new int[n][n];
    //  for (int i = 0; i < n; i++) {
    //      for (int j = 0; j < n; j++) {
    //          rotated[j][n - i - 1] = matrix[i][j];
    //      }
    //  }
    // return rotated;
    // }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        int rotated[][] = rotate(arr);

        System.out.println("Rotated Array");

        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }
}
