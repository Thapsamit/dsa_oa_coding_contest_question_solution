package dynamic_programming;

import java.util.*;;

public class rubrikOA {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long mod = 1000000007;
        String s = scn.next();
        int n = s.length();
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i + 1);
            if (ch == ch1) {
                dp[i][i + 1] = 3;
            } else {
                dp[i][i + 1] = 2;
            }
        }
        int length = 3;
        while (length <= n) {
            int i = 0;
            while (i < n - length + 1) {
                int j = i + length - 1;
                char ch3 = s.charAt(i);
                char ch4 = s.charAt(j);
                if (ch3 != ch4) {
                    dp[i][j] = (dp[i][j - 1] % mod + dp[i + 1][j] % mod - dp[i + 1][j - 1] + mod) % mod;
                } else {
                    dp[i][j] = (1 + dp[i][j - 1] % mod + dp[i + 1][j] % mod) % mod;
                }
                i++;
            }
            length++;
        }

        int q = scn.nextInt();
        for (int x = 0; x < q; x++) {
            int l = scn.nextInt();
            int r = scn.nextInt();

            System.out.println(dp[l][r]);
        }

    }
}
