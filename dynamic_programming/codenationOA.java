package dynamic_programming;

import java.util.*;

public class codenationOA {
    public static int solution(int[] a, int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = a[i];
        }
        for (int i = 1; i <= n; i++) {
            for (int p = 2; p <= k; p++) {
                int part = i;
                int oring = 0;
                while (part >= p) {
                    oring |= a[part];
                    dp[i][p] = Math.max(dp[i][p], dp[part - 1][p - 1]) + oring;
                    part--;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextInt();
        }
        int ans = solution(a, n, k);
        System.out.println(ans);
    }
}
