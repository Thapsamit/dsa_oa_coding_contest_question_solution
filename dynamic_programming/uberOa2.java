package dynamic_programming;

import java.util.*;

public class uberOa2 {
    public static int solution(int n, int[] b, int[] c) {
        int[][][] dp = new int[n + 1][3][3];
        dp[1][1][1] = b[1];
        dp[1][1][2] = b[1];
        dp[1][2][1] = c[1];
        dp[1][2][2] = c[1];
        int i = 2;
        while (i <= n) {
            dp[i][1][1] = b[i] + b[i - 1] + Math.max(dp[i - 2][2][2], dp[i - 2][2][1]);
            dp[i][1][2] = b[i] + c[i - 1] + Math.max(Math.max(dp[i - 2][1][1], dp[i - 2][1][2]), dp[i - 2][2][1]);
            dp[i][2][1] = c[i] + b[i - 1] + Math.max(Math.max(dp[i - 2][2][1], dp[i - 2][2][2]), dp[i - 2][1][2]);
            dp[i][2][2] = c[i] + c[i - 1] + Math.max(dp[i - 2][1][2], dp[i - 2][1][1]);
            i++;
        }
        return Math.max(Math.max(dp[n][1][1], dp[n][1][2]), Math.max(dp[n][2][2], dp[n][2][1]));

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            b[i] = scn.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            c[i] = scn.nextInt();
        }

        int ans = solution(n, b, c);
        System.out.println(ans);
    }
}
