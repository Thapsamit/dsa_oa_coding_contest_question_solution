package Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class infosysDoubleBinarySearch {
    public static long solve(long gg, long b1) {

        long low = 0;
        long high = 10000000;
        long bb = gg / b1;
        long vv = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long gg1 = mid * mid - mid + 1;
            if (gg1 <= bb) {
                if (gg1 == bb) {
                    return mid;
                } else {
                    vv = Math.max(vv, mid);
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return vv;
    }

    public static boolean check(long gg, long n, long k, long[] b) {

        int i = 1;
        long Tot_k = 0;
        while (i <= n) {
            long ki = solve(gg, b[i]);
            Tot_k += (ki);
            i++;
        }

        return Tot_k >= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long n = sc.nextLong();
        long[] b = new long[(int) n + 1];
        long i = 1;
        while (i <= n) {
            b[(int) i] = sc.nextLong();
            i++;
        }
        Arrays.sort(b);

        long low = 1;
        long answer = -1;
        long high = Long.MAX_VALUE;
        long kv = 0;
        while (low <= high && kv == 0) {
            long mid = (low + high) / 2;
            if (check(mid, n, k, b)) {
                if (mid == 1) {
                    kv = 1;
                    answer = 1;
                } else {
                    if (!check(mid - 1, n, k, b)) {
                        answer = mid;
                        kv = 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
