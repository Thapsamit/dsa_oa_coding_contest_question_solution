package Binary_search;

import java.util.*;

public class salesforceSession21 {

    public static boolean check(int mid, int[] arr, int n) {
        int parts = 1; // starting from as to fill part 1
        int sum = 0;
        int i = 0;

        while (i < arr.length) {
            sum += arr[i];
            if (sum <= mid) {
                i++;
            } else {
                parts++;
                sum = 0;
            }
        }
        return parts <= n;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 20, 16, 18, 1, 10, 10, 9, 8 };
        int n = 3;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
            sum += arr[i];
        }
        int low = maxi;
        int high = sum;
        int v = 0;
        int k = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, arr, n)) {
                // possible then go left side as we need as min as possible

                high = mid - 1;
            } else {
                // not possible then go ahead
                low = mid + 1;
            }

        }
        System.out.println(low);

    }
}
