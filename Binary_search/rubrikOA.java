package Binary_search;

import java.util.*;

public class rubrikOA {
    public static boolean check(int mid, int[] arr, int n, int p) {
        int count = 0;
        int i = 0;
        while (i < n - 1) {
            int diff = arr[i + 1] - arr[i];
            if (diff <= mid) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >= p;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int p = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        int low = 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxi = Math.max((arr[i + 1] - arr[i]), maxi);
        }
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, arr, n, p)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}
