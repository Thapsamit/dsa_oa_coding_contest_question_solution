package Hashing;

import java.util.*;

class atlassianOA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = new long[n + 1];
        int k = sc.nextInt();
        int i = 1;
        while (i <= n) {
            a[i] = sc.nextLong();
            i++;
        }
        Arrays.sort(a, 1, n + 1);

        long[] pref = new long[n + 1];
        i = 1;
        while (i <= n) {
            pref[i] = pref[i - 1] + a[i];
            i++;
        }

        long my = (long) 1e18;
        i = 1;
        while (i <= n - k + 1) {

            int start = i;
            int d = k + i - 1;

            if (k % 2 != 0) {

                int md = (start + d) / 2;

                // start-->md-1

                int l1 = Math.abs(md - start);

                long sum1 = pref[md - 1] - pref[start - 1]; // pref[y]-pref[x-1]

                long ans1 = Math.abs(l1 * a[md] - sum1);

                // md+1-->d

                int l2 = Math.abs(d - md);

                long sum2 = pref[d] - pref[md]; // pref[y]-pref[x-1]

                long ans2 = Math.abs(l2 * a[md] - sum2);

                long final_ans = ans1 + ans2;
                my = Math.min(my, final_ans);

            } else {

                int md1 = (start + d) / 2;
                int md2 = md1 + 1;

                // start-->md-1

                int l1 = Math.abs(md1 - start);

                long sum1 = pref[md1 - 1] - pref[start - 1]; // pref[y]-pref[x-1]

                long ans1 = Math.abs(l1 * a[md1] - sum1);

                // md+1-->d

                int l2 = Math.abs(d - md1);

                long sum2 = pref[d] - pref[md1]; // pref[y]-pref[x-1]

                long ans2 = Math.abs(l2 * a[md1] - sum2);

                long final_ans = ans1 + ans2;
                my = Math.min(my, final_ans);

                // start-->md-1

                l1 = Math.abs(md2 - start);

                sum1 = pref[md2 - 1] - pref[start - 1]; // pref[y]-pref[x-1]

                ans1 = Math.abs(l1 * a[md2] - sum1);

                // md+1-->d

                l2 = Math.abs(d - md2);

                sum2 = pref[d] - pref[md2]; // pref[y]-pref[x-1]

                ans2 = Math.abs(l2 * a[md2] - sum2);

                final_ans = ans1 + ans2;
                my = Math.min(my, final_ans);

            }

            i++;
        }

        System.out.println(my);
    }

}