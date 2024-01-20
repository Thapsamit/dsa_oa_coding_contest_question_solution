package Binary_search;

import java.util.Scanner;

public class paypalSession {
    static int check(int vl, int k, int n, int m) {
        int[] b = new int[n + 1];
        b[k] = vl;
        int i = k + 1;
        int l = 0;

        while (i <= n) {
            b[i] = b[i - 1] - 1;
            if (b[i] == 0) {
                b[i] = 1;
            }
            l = l + b[i];
            i++;
        }

        l = l + b[k];
        i = k - 1;

        while (i >= 1) {
            b[i] = b[i + 1] - 1;
            if (b[i] == 0) {
                b[i] = 1;
            }
            l = l + b[i];
            i--;
        }

        int h = 0;
        i = k + 1;

        while (i <= n) {
            b[i] = b[i - 1] + 1;
            h = h + b[i];
            i++;
        }

        h = h + b[k];
        i = k - 1;

        while (i >= 1) {
            b[i] = b[i + 1] + 1;
            h = h + b[i];
            i--;
        }

        if (l <= m && m <= h) {
            return 1;
        }

        if (h < m) {
            return 2;
        }

        if (m < l) {
            return 3;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int answer = -1;
        int low = 1;
        int high = m;
        int kk = 0;

        while (low <= high && kk == 0) {
            int mid = (low + high) / 2;

            if (check(mid, k, n, m) == 1) {
                if (check(mid + 1, k, n, m) != 1) {
                    kk = 1;
                    answer = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (check(mid, k, n, m) == 2) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        System.out.println(answer);
    }
}
