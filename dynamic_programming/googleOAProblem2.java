package dynamic_programming;

import java.util.*;

public class googleOAProblem2 {
    public static long solution(long n, Map<Long, Long> arrayMap) {
        long[] dp = new long[100002];
        long[] g = new long[100002];
        long answer = 0;
        for (long i = 1; i <= 100000 + 1; i++) {
            if (arrayMap.getOrDefault(i, 0L) >= 1) {
                dp[(int) i] = 1 + dp[(int) i - 1];
            } else {
                if (arrayMap.getOrDefault(i - 1, 0L) >= 1) {
                    dp[(int) i] = 1 + g[(int) i - 1];
                } else {
                    dp[(int) i] = 0;
                }
            }
            if (arrayMap.getOrDefault(i, 0L) >= 2) {
                g[(int) i] = 1 + dp[(int) (i - 1)]; // Pick only 1 and just left others
            } else if (arrayMap.getOrDefault(i, 0L) == 1) {
                if (arrayMap.getOrDefault(i - 1, 0L) >= 1) {
                    g[(int) i] = 1 + g[(int) (i - 1)];
                } else {
                    g[(int) i] = 0;
                }
            } else {
                g[(int) i] = 0;
            }
            answer = Math.max(answer, dp[(int) i]);

        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        Map<Long, Long> arrayMap = new HashMap<>();
        for (long i = 1; i <= n; i++) {
            long yy = scanner.nextLong();
            arrayMap.put(yy, arrayMap.getOrDefault(yy, 0L) + 1);
        }
        long ans = solution(n, arrayMap);
        System.out.println(ans);
    }
}
