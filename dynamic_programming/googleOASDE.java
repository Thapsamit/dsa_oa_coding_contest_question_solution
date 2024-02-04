package dynamic_programming;

import java.util.*;

public class googleOASDE {
    public static int summation(int[] arr, int start, int end) {
        int sum = 0;
        while (start <= end) {
            sum += arr[start];
            start++;
        }
        return sum;
    }

    public static int mergingCost(int[] arr, int n) {
        int[][] dp = new int[n][n];
        // length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }
        // length 2
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = arr[i] + arr[i + 1];
        }
        // length 3 onwards
        int l = 3;
        while (l <= n) {
            int i = 0;
            int j = i + l - 1;
            while (j < n) {
                int s = i;
                int mini = Integer.MAX_VALUE;

                while (s < j) {
                    int temp = dp[i][s] + dp[s + 1][j] + summation(arr, i, j);
                    mini = Math.min(temp, mini);
                    s++;
                }
                dp[i][j] = mini;
                i++;
                j++;
            }
            l++;
        }
        return dp[0][n - 1];

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = mergingCost(arr, n);
        System.out.println(ans);
    }
}
