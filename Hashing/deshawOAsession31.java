package Hashing;

public class deshawOAsession31 {
    public static void main(String[] args) {
        int[] arr = { -4, 1, -1 };
        int n = arr.length;
        int tot = 0;
        int[] pref = new int[n]; // initialize with zero by default
        int[] suff = new int[n]; // initializes with zero by default
        for (int i = 0; i < n; i++) {
            tot += arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                pref[i] = Math.min(arr[i], arr[i] + pref[i - 1]); // calculate part 2 minimum but not necessarily
                                                                  // include firts element
            } else {
                pref[i] = arr[i];
            }
        }
        int suffSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffSum += arr[i];
            if (i == n - 1) {
                suff[i] = arr[i];

            } else {
                int minVal = Math.min(suffSum, suff[i + 1]); // calculate part 4 but necessarily include last element or
                                                             // may be complete empty
                suff[i] = minVal;
            }
        }
        int t = 0;
        int d = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int v = 0;
            if (i < n - 1) {
                v = Math.min(t, pref[i]) + Math.min(t, suff[i + 1]); // p2 should be till i and p4 only from i+1;
            } else {
                v = Math.min(t, pref[i]);
            }

            d = Math.min(d, v);
        }
        // Now we know remTwoParts = tot - (d);
        // tehn again need finalAnswer = tot-remTwoParts;
        // Instead we can do finalAnswer = tot-(tot-d);
        // therefore finalAnswer = d so the rest part is d only
        // therefore ans = tot-2*d;
        System.out.println(tot - 2 * d);

    }
}
