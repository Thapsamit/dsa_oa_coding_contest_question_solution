package Hashing;

import java.util.*;

public class googleOASession59 {
    public static int quad(int[] arr, int[] pref, int[] suff, int n) {
        int i = 1;
        int ans = 0;
        while (i <= n) {
            int j = i + 1;
            while (j <= n) {
                if (arr[i] < arr[j]) {
                    ans += pref[i] * suff[j];
                }

                j++;
            }
            i++;
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = scn.nextInt();
        }
        int[] pref = new int[n + 1];
        int[] suff = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[i]) {
                    pref[i] = pref[i] + 1;
                }
            }
        }
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (arr[j] > arr[i]) {
                    suff[i] = suff[i] + 1;
                }
            }
        }
        int ans = quad(arr, pref, suff, n);
        System.out.println(ans);
    }
}
