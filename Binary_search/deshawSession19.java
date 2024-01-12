package Binary_search;

import java.util.*;

public class deshawSession19 {

    public static boolean check(long g, long[] b, int k) {
        long total = g * k;
        for (int i = 0; i < b.length; i++) {
            if (b[i] >= g) {
                total = total - g;
            } else {
                total = total - b[i];
            }
        }
        if (total <= 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        long lo = 1;
        long hi = (long) 1e9;
        long ans = 0;
        long[] b = { 4, 3, 2 };
        int k = 3;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (check(mid, b, k) == true) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }
        System.out.println(ans);
    }
}
