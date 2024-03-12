package dynamic_programming;

import java.util.*;;

public class microsoftOA {

    static long yy(long x, long y, long z) {
        return Math.max(x, Math.max(y, z));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }
        long[][][] dp = new long[n + 5][n + 5][4];

        long sum1 = b[n] + b[n - 1];
        long sum2 = b[1] + b[2];
        long sum3 = b[1] + b[n];

        for (int i = 1; i <= n - 1; i++) {
            long sum = b[i] + b[i + 1];
            long g = 1;
            if (sum == sum1) {
                dp[i][i + 1][1] = Math.max(g, dp[i][i + 1][1]);
            }
            if (sum == sum2) {
                dp[i][i + 1][2] = Math.max(g, dp[i][i + 1][2]);
            }
            if (sum == sum3) {
                dp[i][i + 1][3] = Math.max(g, dp[i][i + 1][3]);
            }
        }

        for (int l = 3; l <= n; l++) {
            for (int start = 1; start <= n - l + 1; start++) {
                int end = start + l - 1;
                long g = 1;

                long sum = b[start] + b[start + 1];
                if (sum == sum1) {
                    dp[start][end][1] = Math.max(dp[start][end][1], g + dp[start + 2][end][1]);
                }
                if (sum == sum2) {
                    dp[start][end][2] = Math.max(dp[start][end][2], g + dp[start + 2][end][2]);
                }
                if (sum == sum3) {
                    dp[start][end][3] = Math.max(dp[start][end][3], g + dp[start + 2][end][3]);
                }

                sum = b[end - 1] + b[end];
                if (sum == sum1) {
                    dp[start][end][1] = Math.max(dp[start][end][1], g + dp[start][end - 2][1]);
                }
                if (sum == sum2) {
                    dp[start][end][2] = Math.max(dp[start][end][2], g + dp[start][end - 2][2]);
                }
                if (sum == sum3) {
                    dp[start][end][3] = Math.max(dp[start][end][3], g + dp[start][end - 2][3]);
                }

                sum = b[start] + b[end];
                if (sum == sum1) {
                    dp[start][end][1] = Math.max(dp[start][end][1], g + dp[start + 1][end - 1][1]);
                }
                if (sum == sum2) {
                    dp[start][end][2] = Math.max(dp[start][end][2], g + dp[start + 1][end - 1][2]);
                }
                if (sum == sum3) {
                    dp[start][end][3] = Math.max(dp[start][end][3], g + dp[start + 1][end - 1][3]);
                }
            }
        }

        System.out.println(yy(dp[1][n][1], dp[1][n][2], dp[1][n][3]));

    }
}
