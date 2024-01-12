package Recursion;

import java.util.*;

public class maxOfArr {
    public static int findMax(int[] arr, int idx, int maxi) {
        if (idx == arr.length) {
            return maxi;
        }
        if (arr[idx] > maxi) {
            maxi = arr[idx];
        }
        return findMax(arr, idx + 1, maxi);

    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 7, -1, 3, 5, 6, -3 };
        int maxi = Integer.MIN_VALUE;
        int ans = findMax(arr, 0, maxi);
        System.out.println(ans);
    }
}
