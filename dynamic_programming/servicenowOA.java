package dynamic_programming;

import java.util.*;

public class servicenowOA {
    public static int solution(int n) {
        int[][] dp = new int[n + 1][4];
        // Col 1 is full
        // col 2 is left
        // col 3 is right
        dp[1][1] = 0;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 3;
        dp[2][2] = 1;
        dp[2][3] = 1;
        for (int i = 3; i <= n; i++) {

            dp[i][1] = 3 * dp[i - 2][1] + dp[i - 2][2] + dp[i - 2][3];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 2][1] + dp[i - 2][3];
        }
        return dp[n][1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = solution(n);
        System.out.println(ans);
    }
}
