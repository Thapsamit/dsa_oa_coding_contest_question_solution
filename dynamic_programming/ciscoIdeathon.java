package dynamic_programming;

import java.util.*;

public class ciscoIdeathon {
    public static int findMaxMin(int[] b, int[] dp, int m, int k, int n) {
        for (int i = 0; i <= n; i++) {
            int maxi = b[i];
            int mini = b[i];
            for (int j = i - 1; j >= 0; j--) {
                if (maxi - mini >= m && (i - j) >= k) {
                    dp[i] = Math.min(dp[i], 1 + dp[i]);
                }
                maxi = Math.max(maxi, b[i]);
                mini = Math.min(mini, b[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] b = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            b[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int k = scn.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int ans = findMaxMin(b, dp, m, k, n);
        System.out.println(ans);
    }
}
