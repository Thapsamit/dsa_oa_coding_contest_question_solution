package dynamic_programming;

import java.util.*;

public class intuitOA {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] mat = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                mat[row][col] = scn.nextInt();
            }
        }

        scn.close();

    }
}
