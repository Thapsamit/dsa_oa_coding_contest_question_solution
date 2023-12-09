package Hashing;

import java.util.*;

public class VmwareSession49 {
    public static int equalBinary(String str, int n) {
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        int[] pref0 = new int[n + 1];
        int[] pref1 = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (str.charAt(i - 1) == '0') {
                pref0[i] = pref0[i - 1] + 1;
                pref1[i] = pref1[i - 1];
            } else {
                pref0[i] = pref0[i - 1];
                pref1[i] = pref1[i - 1] + 1;
            }
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            int lhs = pref0[i - 1] - pref1[i - 1];
            hashMap.put(lhs, hashMap.getOrDefault(lhs, 0) + 1);
            int rhs = pref0[i] - pref1[i];
            int val = hashMap.getOrDefault(rhs, 0);
            ans += val;

        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = str.length();
        int ans = equalBinary(str, n);
        System.out.println(ans);
    }
}
