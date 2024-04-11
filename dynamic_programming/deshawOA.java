package dynamic_programming;

import java.util.*;;

public class deshawOA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] cost = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            cost[i] = scanner.nextLong();
        }

        n = scanner.nextInt();
        long[] happy = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            happy[i] = scanner.nextLong();
        }

        n = scanner.nextInt();
        long[] mn = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            mn[i] = scanner.nextLong();
        }

        n = scanner.nextInt();
        long[] my = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            my[i] = scanner.nextLong();
        }

        int m = scanner.nextInt();

        long[][] dp = new long[105][105];
        for (int i = 1; i < 105; i++) {
            for (int j = 0; j < 105; j++) {
                dp[i][j] = -1000000000000000000L;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long finalAnswer = -1000000000000000000L;
                long count = mn[i];
                while (count <= my[i]) {
                    long g = count * cost[i];
                    if (j - g >= 0) {
                        long answer = dp[i - 1][j - (int) g] + count * happy[i];
                        finalAnswer = Math.max(finalAnswer, answer);
                    }
                    count++;
                }
                dp[i][j] = finalAnswer;

                System.out.println(i + " " + j + " " + dp[i][j]);
            }
        }

        if (dp[n][m] < 0) {
            System.out.println("0");
        } else {
            System.out.println(dp[n][m]);
        }
    }
}
