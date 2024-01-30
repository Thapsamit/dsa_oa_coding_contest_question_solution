package dynamic_programming;

import java.util.*;

public class amazonOA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] b = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }

        dp[1] = 0;
        int mxv = dp[1] - b[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i], b[i] + mxv);
            int v = dp[i] - b[i];
            mxv = Math.max(mxv, v);
        }

        int r = 0;
        for (int i = 1; i <= n; i++) {
            r = Math.max(r, dp[i]);
        }

        System.out.println(r);

    }

}
