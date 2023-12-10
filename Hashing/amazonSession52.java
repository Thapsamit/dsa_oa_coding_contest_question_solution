package Hashing;

import java.util.*;

public class amazonSession52 {
    public static int[] locMove(int[] locations, int[] mfrom, int[] mto, int l, int m) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int val : locations) {
            hashSet.add(val);
        }
        for (int i = 0; i < m; i++) {
            int v = mfrom[i];
            int s = mto[i];
            if (hashSet.contains(v)) {
                hashSet.remove(v);
                hashSet.add(s);
            }
        }
        int[] arr = new int[hashSet.size()];
        int st = 0;
        for (int x : hashSet) {
            arr[st++] = x;

        }
        Arrays.sort(arr);
        return arr;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int l = scn.nextInt();
        int[] locations = new int[l];
        for (int i = 0; i < l; i++) {
            locations[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] mfrom = new int[m];
        int[] mto = new int[m];

        for (int i = 0; i < m; i++) {
            mfrom[i] = scn.nextInt();
        }
        for (int i = 0; i < m; i++) {
            mto[i] = scn.nextInt();
        }
        int[] ans = locMove(locations, mfrom, mto, l, m);
        for (int a : ans) {
            System.out.print(a + " ");
        }

    }
}
