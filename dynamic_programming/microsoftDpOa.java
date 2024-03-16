package dynamic_programming;

import java.util.*;;

public class microsoftDpOa {

    public static int my(int x, int y, int z, int w) {
        return Math.max(x, Math.max(y, Math.max(z, w)));
    }

    public static int findPattern(String s, int n) {
        int[] dpa1 = new int[n];
        int[] dpa2 = new int[n];
        int[] dpb1 = new int[n];
        int[] dpb2 = new int[n];
        if (s.charAt(0) == 'a') {
            dpa1[1] = 1;
        }

        if (s.charAt(0) == 'b') {
            dpb1[1] = 1;
        }
        int answer = 1;
        int r = 0;
        for (int i = 1; i <= n - 1; i++) {
            if (s.charAt(i) == 'a') {
                dpa1[i] = 1 + Math.max(dpb1[i - 1], dpb2[i - 1]);
                if (i >= 2 && s.charAt(i - 1) == 'a') {
                    dpa2[i] = 2 + Math.max(dpb1[i - 2], dpb2[i - 2]);
                } else if (s.charAt(i - 1) == 'a') {
                    dpa2[i] = 2; // means i is 1 so dpa2[2] will also be
                }
                dpb1[i] = 0;
                dpb2[i] = 0;
            } else {
                dpb1[i] = 1 + Math.max(dpa1[i - 1], dpa2[i - 1]);

                if (i >= 2 && s.charAt(i - 1) == 'b') {
                    dpb2[i] = 2 + Math.max(dpa1[i - 2], dpa2[i - 2]);
                } else if (s.charAt(i - 1) == 'b') {
                    dpb2[i] = 2;
                }
                dpa1[i] = 0;
                dpa2[i] = 0;

            }
            answer = my(dpa1[i], dpa2[i], dpb1[i], dpb2[i]);
            r = Math.max(r, answer);
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int ans = findPattern(s, n);
        System.out.println(ans);
    }
}
