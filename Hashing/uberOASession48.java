package Hashing;

import java.util.*;

public class uberOASession48 {
    public static int minCostConversion(String s, int n) {
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] pref_a = new int[n];
        int[] suff_b = new int[n];
        int[] pref_b = new int[n];
        int[] suff_a = new int[n];
        if (s.charAt(0) == 'a') {
            pref_a[0] = 0;
            pref_b[0] = 1;
        } else {
            pref_a[0] = 1;
            pref_b[0] = 0;
        }
        if (s.charAt(n - 1) == 'a') {
            suff_a[n - 1] = 0;
            suff_b[n - 1] = 1;
        } else {
            suff_a[n - 1] = 1;
            suff_b[n - 1] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'a') {
                pref_a[i] = pref_a[i - 1];
                pref_b[i] = pref_b[i - 1] + 1;
            } else {
                pref_a[i] = pref_a[i - 1] + 1;
                pref_b[i] = pref_b[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                suff_a[i] = suff_a[i + 1];
                suff_b[i] = suff_b[i + 1] + 1;
            } else {
                suff_a[i] = suff_a[i + 1] + 1;
                suff_b[i] = suff_b[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            int cost1 = Integer.MAX_VALUE;
            int cost2 = Integer.MAX_VALUE;
            if (i < n - 1) {
                cost1 = pref_a[i] + suff_b[i + 1];
                cost2 = pref_b[i] + suff_a[i + 1];
            } else {
                cost1 = pref_a[i];
                cost2 = pref_b[i];
            }

            ans = Math.min(ans, cost1);
            ans = Math.min(ans, cost2);

        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int n = s.length();

        int ans = minCostConversion(s, n);
        System.out.println(ans);
    }
}
