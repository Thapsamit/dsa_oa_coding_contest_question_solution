package Hashing;

import java.util.*;

public class atlassianSession30 {
    public static void main(String[] args) {
        int[] arr = { 1, 5, -5, 8, 8, 8, 10, 15 };
        int n = arr.length;
        int k = 5;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int yy = arr[i];
            int abs1 = yy - k;
            int abs2 = yy + k;
            if (!hashMap.containsKey(yy)) {
                hashMap.put(yy, sum);
            }
            if (hashMap.containsKey(abs1)) {
                int totalSum = sum + yy - hashMap.get(abs1);
                ans = Math.max(ans, totalSum);
                int minSum = Math.min(hashMap.get(yy), sum);
                hashMap.put(yy, minSum);
            }
            if (hashMap.containsKey(abs2)) {
                int totalSum = sum + yy - hashMap.get(abs2);
                ans = Math.max(ans, totalSum);
                int minSum = Math.min(hashMap.get(yy), sum);
                hashMap.put(yy, minSum);
            }
            sum += yy;
        }
        if (ans == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }

    }
}
