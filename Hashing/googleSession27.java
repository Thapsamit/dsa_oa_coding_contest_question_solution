package Hashing;

import java.util.*;

public class googleSession27 {

    public static void main(String[] args) {
        int arr[] = { 31, 25, 85, 29, 35 };
        int k = 60;
        int n = arr.length;
        int sum = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int modVal = arr[i] % k;
            int gg = k - modVal;
            sum = sum + hashMap.getOrDefault(gg, 0);
            hashMap.put(modVal, hashMap.getOrDefault(modVal, 0) + 1);
        }
        System.out.println(sum);
    }
}
