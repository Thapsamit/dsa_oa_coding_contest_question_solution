package dynamic_programming;

import java.util.*;;

public class googleInternOA {
    public static int minMaxDp(int n, int[] a, int[] b) {
        int[] dp = new int[n + 1];
        dp[1] = a[1];
        for (int i = 2; i <= n; i++) {
            int mini = a[i] + dp[i - 1]; // When only last one is fixed
            int bSum = b[i] + b[i - 1]; // When last two is fixed
            int j = i - 1;
            while (j >= 1) {
                int t = bSum + dp[j - 1];
                mini = Math.min(t, mini);
                j--;
                bSum += b[j];
            }
            dp[i] = mini;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scn.nextInt();
        }

        int ans = minMaxDp(n, a, b);
        System.out.println(ans);

    }
}
