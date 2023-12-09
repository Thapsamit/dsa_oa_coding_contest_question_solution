package Hashing;

import java.util.*;

public class intuitOASession47 {
    public static int ratioMatching(int[] arr, int n, int x, int y) {
        int[] pref0 = new int[n + 1];
        int[] pref1 = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] == 1) {
                pref1[i] = pref1[i - 1] + 1;
                pref0[i] = pref0[i - 1];
            } else {
                pref0[i] = pref0[i - 1] + 1;
                pref1[i] = pref1[i - 1];
            }
        }
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            int lhs = pref0[i - 1] * y - pref1[i - 1] * x;
            hashMap.put(lhs, hashMap.getOrDefault(lhs, 0) + 1);

            int rhs = pref0[i] * y - pref1[i] * x;
            ans += hashMap.getOrDefault(rhs, 0);

        }
        return ans;

    }

    public static void main(String[] args) {
        int n;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter size of array");
        n = obj.nextInt();
        int[] arr = new int[n + 1];
        System.out.println("Enter array elements");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = obj.nextInt();
        }
        System.out.println("Enter x");
        int x = obj.nextInt();
        System.out.println("Enter y");
        int y = obj.nextInt();
        int ans = ratioMatching(arr, n, x, y);
        System.out.println(ans);

    }
}
