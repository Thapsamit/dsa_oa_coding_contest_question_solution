package dynamic_programming;

import java.util.*;

public class microsoftOA5 {
    public static int solution(int[] arr, int n) {
        Arrays.sort(arr);
        int[][] dp = new int[n][105];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 100; j++) {
                int k = i - 1;
                int large = 0;
                while (k >= 0) {
                    if (arr[k] + j == arr[i]) {
                        large = Math.max(large, dp[k][j]);
                    }
                    k--;
                }
                dp[i][j] = large + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = solution(arr, n);
        System.out.println(ans);
    }
}
