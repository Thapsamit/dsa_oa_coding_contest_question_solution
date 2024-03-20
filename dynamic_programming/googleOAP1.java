package dynamic_programming;

import java.util.*;

public class googleOAP1 {
    public static int solution(int[] b, int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int l = 1; l <= k; l++) {
            for (int i = 1; i <= n; i++) {
                int v = dp[i - 1][l];
                int sum = 0;
                for (int j = i; j >= 1; j--) {
                    sum += b[j];
                    v = Math.max(v, sum + dp[j - 1][l - 1]);
                }
                dp[i][l] = v;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][k];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n, k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[] b = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            b[i] = scanner.nextInt();
        }
        int ans = solution(b, n, k);
        System.out.println(ans);
    }
}
