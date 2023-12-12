package Hashing;

import java.util.*;

public class googleSession55 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();

        }
        for (int i = 0; i < n; i++) {
            b[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int y = scn.nextInt();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int xp = a[i] - b[i] + (y - x);
            if (hashMap.containsKey(xp)) {
                ans += hashMap.get(xp);
            }
            hashMap.put(xp, hashMap.getOrDefault(xp, 0) + 1);
        }
        System.out.println(ans);

    }
}
