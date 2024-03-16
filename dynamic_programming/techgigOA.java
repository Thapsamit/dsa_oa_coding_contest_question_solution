package dynamic_programming;

import java.util.*;;

public class techgigOA {
    public static long findStringBreak(long n, String s, long k) {

        long[] dp = new long[(int) (n + 1)];
        long[] b = new long[(int) (n + 1)];
        long md = (long) 1e9 + 7;
        int i = 0;
        while (i <= n - 1) {
            char g = s.charAt(i);
            b[i + 1] = (long) g;
            i++;
        }
        dp[0] = 1;
        i = 1;
        while (i <= n) {
            long j = i - 1;
            while (j >= 0) {
                long l = Math.abs(j - i);
                String sub = s.substring((int) j, (int) (j + l));
                long subToNum = Long.parseLong(sub);
                if (subToNum <= k && b[(int) j + 1] != 0) {
                    dp[(int) i] = (dp[(int) i] + dp[(int) j]) % md;
                }
                j--;
            }
            i++;
        }
        return dp[(int) n] % md;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        String s = scanner.next();
        long ans = findStringBreak(n, s, k);
        System.out.println(ans);
    }
}
