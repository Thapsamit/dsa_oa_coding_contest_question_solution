package Hashing;

import java.util.*;

public class zScalerSession57 {
    public static int maxSum(int[] b, int[] p, int n, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparing(Map.Entry::getKey));
        Map.Entry<Integer, Integer> me = Map.entry(0, 0);
        q.add(me);
        int i = 1;
        int maxi = 0;
        while (i <= n) {
            int r = i - 1;
            int l = i - k;
            int k5 = 0;

            int bb = Integer.MAX_VALUE;
            while (!q.isEmpty() && k5 == 0) {
                Map.Entry<Integer, Integer> entry = q.peek();
                int x = entry.getKey();
                int y = entry.getValue();

                if (y >= l && y <= r) {
                    bb = Math.min(bb, x);
                    k5 = 1;
                } else {
                    q.poll();
                }
            }

            if (bb == Integer.MAX_VALUE) {
                // do nothing
            } else {
                int vv = p[i] - bb;
                maxi = Math.max(maxi, vv);
            }
            Map.Entry<Integer, Integer> mg = Map.entry(p[i], i);

            q.add(mg);
            i++;
        }
        return maxi;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] b = new int[n + 1];
        int[] p = new int[n + 1];

        int i = 1;
        while (i <= n) {
            b[i] = sc.nextInt();
            p[i] = p[i - 1] + b[i];
            i++;
        }
        int ans = maxSum(b, p, n, k);
        System.out.println(ans);
    }
}
