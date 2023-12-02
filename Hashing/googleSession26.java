package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class googleSession26 {
    public static int maxOperations(Vector<Integer> nums, int k, int n) {
        int maxP = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int target = k - nums.get(i);
            if (hashMap.containsKey(target) && hashMap.get(target) > 0) {
                hashMap.put(target, hashMap.get(target) - 1);
                maxP++;
                if (hashMap.get(target) == 0) {
                    hashMap.remove(target);
                }
            } else {
                hashMap.put(nums.get(i), hashMap.getOrDefault(nums.get(i), 0) + 1);
            }
        }
        return maxP;
    }

    public static void main(String[] args) {
        Integer temp[] = { 1, 2, 1, 2, 5, 5, 1, 2 };
        Vector<Integer> nums = new Vector<>(Arrays.asList(temp));
        int n = nums.size();
        int maxPairs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = nums.get(i) + nums.get(j);

                int ans = maxOperations(nums, k, n);

                maxPairs = Math.max(maxPairs, ans);

            }
        }
        System.out.println(maxPairs);
    }

}