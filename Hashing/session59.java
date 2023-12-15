package Hashing;

import java.util.*;

public class session59 {
    public static int pairCheck(ArrayList<ArrayList<Integer>> q, int[] arr, int nq, int n) {
        int count = 0;
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nq; i++) {
            ArrayList<Integer> pair = q.get(i);
            parent.put(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            count = count + freq.getOrDefault(val, 0);
            if (parent.containsKey(val)) {
                int p = parent.get(val);
                freq.put(p, freq.getOrDefault(p, 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nq;
        Scanner scn = new Scanner(System.in);
        nq = scn.nextInt();
        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
        for (int i = 0; i < nq; i++) {
            ArrayList<Integer> tem = new ArrayList<>();
            int fir = scn.nextInt();
            int sec = scn.nextInt();
            tem.add(fir);
            tem.add(sec);
            q.add(tem);
        }
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = pairCheck(q, arr, nq, n);
        System.out.println(ans);

    }
}
