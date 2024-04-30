package dynamic_programming;

import java.util.*;

public class walmartOAP5 {
    public static int solution(int[] arr, int n) {
        int[] dp = new int[n];
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(arr[0], 1);
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            hashMap.put(arr[i], Math.max(1, hashMap.getOrDefault(arr[i], 0)));
            if (arr[i] % 3 == 0) {
                int val = arr[i] / 3;
                int k = 1 + hashMap.getOrDefault(val, 0);
                dp[i] = Math.max(dp[i], k);
                hashMap.put(arr[i], dp[i]);
            }
        }
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;

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
