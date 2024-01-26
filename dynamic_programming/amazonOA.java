package dynamic_programming;

import java.util.Scanner;

public class amazonOA {
    public static int flightCost(int[] cost, int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return Math.abs(cost[1] - cost[0]);
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(cost[1] - cost[0]);
        dp[2] = dp[1] + Math.abs(cost[2] - cost[1]);
        for (int i = 3; i < n; i++) {
            int step3Cost = dp[i - 3] + Math.abs(cost[i] - cost[i - 3]);
            int step1Cost = dp[i - 1] + Math.abs(cost[i] - cost[i - 1]);
            int mini = Math.min(step1Cost, step3Cost);
            dp[i] = mini;
        }
        return dp[n - 1];

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scn.nextInt();
        }
        int ans = flightCost(cost, n);
        System.out.println(ans);

    }
}
