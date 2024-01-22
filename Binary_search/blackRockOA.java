package Binary_search;

import java.util.*;

public class blackRockOA {
    public static boolean isPossible(int m, int[] arr) {
        if (m == 0) {
            return true;
        }
        int n = arr.length;
        int i = m - 1;
        int k = n - 1;
        while (i >= 0) {
            if (arr[i] >= arr[k]) {
                return false;
            }
            i--;
            k--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(mid, arr)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}
