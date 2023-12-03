package Hashing;

import java.util.*;

public class intuitSession29 {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2 };
        int n = arr.length;
        int k = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int hashkey = entry.getKey();
            int hashVal = entry.getValue();
            if (k == 0 && hashVal > 1) {
                count++;
            } else {
                if (hashMap.containsKey(hashkey + k)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
