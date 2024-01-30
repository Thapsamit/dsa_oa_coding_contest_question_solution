package dynamic_programming;

import java.util.*;

public class googleOA {
    public static int maxCost(int[] a, int[] b, int n) {
        if (n == 1) {
            return Math.max(a[1], b[1]);
        }
        if (n == 2) {
            return Math.max(a[1] + a[2], b[1] + b[2]);
        }
        int[][] dp = new int[n + 1][2];
        dp[1][0] = a[1];
        dp[1][1] = b[1];
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + a[i], dp[i - 2][1] + a[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + b[i], dp[i - 2][0] + b[i]);

        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = scn.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            b[i] = scn.nextInt();
        }
        int ans = maxCost(a, b, n);
        System.out.println(ans);
    }
}
