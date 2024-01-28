package dynamic_programming;

import java.util.*;

public class cVacation {
    public static int pointsCollected(int n, int[][] points) {
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = points[0][i]; // first row initialize
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int maxi = Integer.MIN_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        maxi = Math.max(points[i][j] + dp[i - 1][k], maxi);
                    }
                }
                dp[i][j] = maxi;
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.max(dp[n - 1][i], ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = scn.nextInt();
            }
        }
        int ans = pointsCollected(n, points);
        System.out.println(ans);
    }
}