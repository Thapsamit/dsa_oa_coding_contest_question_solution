package Binary_search;

import java.util.*;

public class zscalerOASession22 {
    static Vector<Integer> b = new Vector<>();

    public static boolean check(int mid, int n) {
        Vector<Integer> temp = new Vector<>(b);
        for (int i = n - 1; i >= 1; i--) {
            if (b.get(i) >= mid) {
                int diff = Math.abs(b.get(i) - mid);
                b.set(i - 1, b.get(i - 1) + diff);
            }

        }
        if (b.get(0) <= mid) {
            // means possible
            b = temp;
            return true;
        }
        b = temp;
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            b.add(scn.nextInt());
        }
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, b.get(i));
        }
        int low = b.get(0);
        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(mid, n)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);

    }
}
