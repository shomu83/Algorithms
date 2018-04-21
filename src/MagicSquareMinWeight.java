public class MagicSquareMinWeight {

    static int formingMagicSquare(int[][] s) {

        int[][] ms = getMagicSquare();
        int minCost = Integer.MAX_VALUE;
        for (int i=0; i<4; i++) {
            ms = rotateSquare(ms);
            minCost = Math.min(minCost, getCost(s, ms));
        }
        ms = inversedSquare(ms);
        for (int i=0; i<4; i++) {
            ms = rotateSquare(ms);
            minCost = Math.min(minCost, getCost(s, ms));
        }

        return minCost;
    }

    static int getCost(int[][] s, int [][] magicSquare) {
        int cost = 0;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                cost += Math.abs(s[i][j] - magicSquare[i][j]);
            }
        }
        return cost;
    }

    static int[][] getMagicSquare() {
        int[][] magicSq = new int[][] {
                {8, 3, 4},
                {1, 5, 9},
                {6, 7, 2}
        };

        print(magicSq);
        return magicSq;
    }

    static int[][] rotateSquare(int[][] square) {
        int size = 3;
        int[][] rotated = new int[size][size];
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                rotated[j][size - i - 1] = square[i][j];
            }
        }
        print(rotated);
        return rotated;
    }

    static int[][] inversedSquare(int[][] square) {
        int size = 3;
        int[][] inversed = new int[size][size];
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                inversed[i][size - j - 1] = square[i][j];
            }
        }
        print(inversed);
        return inversed;
    }

    static void print(int[][] square) {
        System.out.println();
        System.out.println();

        int size = 3;
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        int[][] s = new int[][] {
            {4, 9, 2},
            {3, 5, 7},
            {8, 1, 5}};

//        for(int s_i = 0; s_i < 3; s_i++){
//            for(int s_j = 0; s_j < 3; s_j++){
//                s[s_i][s_j] = in.nextInt();
//            }
//        }
        int result = formingMagicSquare(s);
        System.out.println(result);
//        in.close();
    }
}