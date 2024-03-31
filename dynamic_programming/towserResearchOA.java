package dynamic_programming;

import java.util.*;;

public class towserResearchOA {
    static long md = 1000000007;
    static long e = md;

    public static long solution(long n, Map<Long, Long> map1, Map<Long, Long> map2) {
        long[] c = new long[100001];
        long i = 1;
        c[0] = 1;
        while (i <= 100000) {
            c[(int) i] = (2 * c[(int) (i - 1)]) % md;
            i++;
        }
        long[] dp1 = new long[100001];
        long[] dp2 = new long[100001];
        long[] p = new long[100001];
        i = 1;
        long g = 0;
        while (i <= 100000) {
            long v = map1.getOrDefault(i, 0L);
            dp1[(int) i] = ((c[(int) g] % e) * ((c[(int) v] % e - 1 + e) % e)) % e;
            g = g + map1.getOrDefault(i, 0L);
            i = i + 1;
        }
        long j = 1;
        g = 0;
        while (j <= 100000) {
            long v = map2.getOrDefault(j, 0L);
            dp2[(int) j] = ((c[(int) g] % e) * ((c[(int) v] % e - 1 + e) % e)) % e;
            p[(int) j] = (p[(int) (j - 1)] + dp2[(int) j]) % e;
            g = g + map2.getOrDefault(j, 0L);
            j = j + 1;
        }
        i = 1;
        long answer = 0;
        while (i <= 100000) {
            answer = (answer % e + (dp1[(int) i] * p[(int) i]) % e) % e;
            i = i + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        Map<Long, Long> map1 = new HashMap<>();
        Map<Long, Long> map2 = new HashMap<>();
        long i = 1;
        while (i <= n) {
            long yy = scanner.nextLong();
            map1.put(yy, map1.getOrDefault(yy, 0L) + 1);
            i = i + 1;
        }
        i = 1;
        while (i <= n) {
            long yy = scanner.nextLong();
            map2.put(yy, map2.getOrDefault(yy, 0L) + 1);
            i = i + 1;
        }
        long answer = solution(n, map1, map2);
        System.out.println(answer);
    }
}
