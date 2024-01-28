package dynamic_programming;

import java.util.*;;

public class googleDPReduceCost {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int y = scn.nextInt();
        int x = scn.nextInt();
        int z = scn.nextInt();
        int b = scn.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 0;
        int i = 2;
        while (i <= n) {
            int c1 = dp[i - 1] + y;
            int c2 = Integer.MAX_VALUE;
            int c3 = Integer.MAX_VALUE;
            int c4 = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                // means divisible by 3
                c2 = dp[i / 3] + z;
            }
            if (i % 5 == 0) {
                // means divisible by 5
                c3 = dp[i / 5] + b;
            }
            if (i % 7 == 0) {
                c4 = dp[i / 7] + x;
            }
            dp[i] = Math.min(c1, Math.min(c2, Math.min(c3, c4)));
            i++;
        }
        System.out.println(dp[n]);
    }
}
