package dynamic_programming;

import java.util.*;;

public class microsoftOA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }
        // Considering 1 based indexing
        int[][][] dp = new int[1005][1005][4];

        int sum1 = b[n] + b[n - 1];
        int sum2 = b[1] + b[2];
        int sum3 = b[1] + b[n];
        // Find for Length 2
        for (int i = 1; i <= n - 1; i++) {
            int sum = b[i] + b[i + 1];
            int g = 1;
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
                int g = 1;

                // Possibility 1 take first two elements
                int sum = b[start] + b[start + 1];
                if (sum == sum1) {
                    dp[start][end][1] = Math.max(dp[start][end][1], g + dp[start + 2][end][1]);
                }
                if (sum == sum2) {
                    dp[start][end][2] = Math.max(dp[start][end][2], g + dp[start + 2][end][2]);
                }
                if (sum == sum3) {
                    dp[start][end][3] = Math.max(dp[start][end][3], g + dp[start + 2][end][3]);
                }
                // Possibility 2 take last two elements

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
                // Possibility 3 take first and last element

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

        int a1 = dp[1][n][1];
        int a2 = dp[2][n][2];
        int a3 = dp[3][n][3];
        int ans = Math.max(a1, Math.max(a2, a3));
        System.out.println(ans);

    }
}
