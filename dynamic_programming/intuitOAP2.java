package dynamic_programming;

import java.util.*;;

public class intuitOAP2 {
    public static int solution(int n, int[] power, int[] cost) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int minCost = Integer.MAX_VALUE;
            int j = i;
            while (j >= 1) {
                if (power[j] != 0) {
                    int left = j - power[j];
                    int right = j + power[j];

                    if (right >= i) {
                        int mini = Integer.MAX_VALUE;
                        if (left <= 1) {
                            mini = Math.min(mini, cost[j]);
                        } else {
                            mini = Math.min(mini, cost[j] + dp[left]);
                        }
                        minCost = Math.min(minCost, mini);

                    }

                }
                j--;
            }
            dp[i] = minCost;
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] power = new int[n + 1];
        int[] cost = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            power[i] = scn.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            cost[i] = scn.nextInt();
        }
        int ans = solution(n, power, cost);
        System.out.println(ans);

    }
}
