package dynamic_programming;

import java.util.*;

public class countSubsetSum {
    public static int solution(int n, int sum, int[] arr) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // If sum 0 required then all will be true
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                int idx = j - arr[i];
                dp[i][j] = dp[i - 1][j] + (idx >= 0 ? dp[i - 1][idx] : 0);
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sum = scn.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = solution(n, sum, arr);
        System.out.println(ans);
    }
}
