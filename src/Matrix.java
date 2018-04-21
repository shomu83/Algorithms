public class Matrix {

    //anti-closewise
    public int[][] rotateInPlace(int[][] matrix) throws Exception {

//        1  2  3 4
//        5  6  7  8
//        9 10 11 12
//        13 14 15 16

        int m = matrix.length;
        int n = matrix[0].length;
        if (m != n)
            throw new Exception("Not a square matrix");

        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][m - 1 - i];
                matrix[j][m - 1 - i] = matrix[m - 1 - i][m - 1 - j];
                matrix[m - 1 - i][m - 1 - j] = matrix[m - 1 - j][i];
                matrix[m - 1 - j][i] = temp;
            }
        }

        return matrix;
    }

    //closewise
    public int[][] rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] rotated = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - i - 1] = matrix[i][j];
            }
        }

        return rotated;
    }

    public void print(int[][] matrix) {
        System.out.println();

        for (int i=0; i< matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] matrix = new int[][] {
                {11,22,33,44, 1},
                {33,55,66,77, 2},
                {77,88,99,11, 3},
                {22,44,88,99, 4},
                {11,22,33,44, 5},
        };

        Matrix matrixObj = new Matrix();
        int [][] rotated = matrixObj.rotate(matrix);
        matrixObj.print(rotated);
        rotated = matrixObj.rotateInPlace(matrix);
        matrixObj.print(rotated);
    }
}
