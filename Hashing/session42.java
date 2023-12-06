package Hashing;

import java.util.*;

public class session42 {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, 9, 8, 7 };
        int n = arr.length;
        int k = 15;
        int start = 0;
        int end = 0;
        int sum = 0;
        int minWindowKey = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hashMap.containsKey(sum - k)) {
                minWindowKey = Math.max(minWindowKey, i - hashMap.get(sum - k));
            }
            hashMap.put(sum, i);
        }
        sum = 0;
        int count = 0;
        while (end < n) {
            sum += arr[end];
            if (end - start + 1 == minWindowKey) {
                if (sum == k) {
                    count++;
                }
            } else if (end - start + 1 > minWindowKey) {
                sum -= arr[start];
                if (sum == k) {
                    count++;
                }
                start++;
            }
            end++;
        }
        System.out.println(count);

    }
}
