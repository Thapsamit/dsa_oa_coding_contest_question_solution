package dynamic_programming;

import java.util.*;

public class googleDPOA {
    public static int[][] oddEvenJourney(int[] arr, int n, int[][] dp) {
        if (arr[0] % 2 == 0) {
            dp[0][1] = 1;
        } else {
            dp[0][0] = 1;
        }
        if (arr[1] % 2 == 0) {
            dp[1][1] = dp[0][1];
            dp[1][0] = dp[0][0];
        } else {
            dp[1][1] = dp[0][0];
            dp[1][0] = dp[0][1];
        }

        int i = 2;
        while (i < n) {
            if (arr[i] % 2 == 0) {
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1] + (i - 3 >= 0 ? dp[i - 3][1] : 0);
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0] + (i - 3 >= 0 ? dp[i - 3][0] : 0);
            } else {
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0] + (i - 3 >= 0 ? dp[i - 3][0] : 0);
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1] + (i - 3 >= 0 ? dp[i - 3][1] : 0);
            }
            i++;
        }
        return dp;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[][] dp = new int[n][2];
        // 0th col for odd and 1th col for even
        oddEvenJourney(arr, n, dp);
        System.out.println(dp[n - 1][0] + " " + dp[n - 1][1]);

    }
}
