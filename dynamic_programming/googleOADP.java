package dynamic_programming;

import java.util.*;

public class googleOADP {

    public static int solution(int n, int m, int k, int[][] b) {
        boolean[][] l = new boolean[n + 1][5001];
        l[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= 5000; sum++) {
                for (int j = 1; j <= m; j++) {
                    int y1 = b[i][j];
                    int p = sum - y1;
                    if (p >= 0 && l[i - 1][p]) {
                        l[i][sum] = true;
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 5000; i++) {
            if (l[n][i]) {
                int po = Math.abs(i - k);
                res = Math.min(res, po);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n, m, k;
        n = scn.nextInt();
        m = scn.nextInt();
        k = scn.nextInt();
        int[][] b = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] = scn.nextInt();
            }
        }

        int ans = solution(n, m, k, b);
        System.out.println(ans);

    }
}
