package Hashing;

import java.util.*;

public class googleSession28 {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, -1, -3, 2, 1 };
        int n = arr.length;
        int sum = 0;
        int answer = Integer.MIN_VALUE;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, arr[i]); // to handle case when no number repeats so the single max will bethere
            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], sum);
            } else {
                int mapVal = hashMap.get(arr[i]);
                int gg = sum + arr[i] - mapVal;
                answer = Math.max(answer, gg);
                int minVal = Math.min(hashMap.get(arr[i]), sum);
                hashMap.put(arr[i], minVal);
            }
            sum += arr[i];
        }
        System.out.println(answer);
    }
}
