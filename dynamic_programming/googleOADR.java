package dynamic_programming;

import java.util.*;

public class googleOADR {
    static long[] a = new long[200005];
    static Map<Pair<Long, Long>, Pair<Long, Long>> dp1 = new HashMap<>();
    static Map<Pair<Long, Long>, Pair<Long, Long>> dp2 = new HashMap<>();

    static Pair<Long, Long> r(long i, long j) {
        Pair<Long, Long> key = new Pair<>(i, j);
        if (dp2.containsKey(key)) {
            return dp2.get(key);
        }

        if (i == j) {
            Pair<Long, Long> d1 = new Pair<>(0L, a[(int) i]);
            dp2.put(key, d1);
            return d1;
        }

        Pair<Long, Long> d1, d2;
        d1 = d(i + 1, j); // Corrected to call `d`
        d1 = new Pair<>(d1.getKey(), d1.getValue() + a[(int) i]);

        d2 = d(i, j - 1); // Corrected to call `d`
        d2 = new Pair<>(d2.getKey(), d2.getValue() + a[(int) j]);

        if (a[(int) i] > a[(int) j]) {
            dp2.put(key, d1);
            return d1;
        } else if (a[(int) i] == a[(int) j]) {
            if ((d1.getKey() - d1.getValue()) >= (d2.getKey() - d2.getValue())) {
                dp2.put(key, d1);
                return d1;
            }
            dp2.put(key, d2);
            return d2;
        }

        dp2.put(key, d2);
        return d2;
    }

    static Pair<Long, Long> d(long i, long j) {
        Pair<Long, Long> key = new Pair<>(i, j);
        if (dp1.containsKey(key)) {
            return dp1.get(key);
        }

        if (i == j) {
            Pair<Long, Long> d1 = new Pair<>(a[(int) i], 0L);
            dp1.put(key, d1);
            return d1;
        }

        Pair<Long, Long> d1, d2;
        d1 = r(i + 1, j); // `r` is called correctly here
        d1 = new Pair<>(a[(int) i] + d1.getKey(), d1.getValue());

        d2 = r(i, j - 1); // `r` is called correctly here
        d2 = new Pair<>(a[(int) j] + d2.getKey(), d2.getValue());

        if ((d1.getKey() - d1.getValue()) >= (d2.getKey() - d2.getValue())) {
            dp1.put(key, d1);
            return d1;
        }

        dp1.put(key, d2);
        return d2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
        }

        Pair<Long, Long> kk = d(1, n);
        System.out.println(kk.getKey() + " " + kk.getValue());

        sc.close();
    }

    // Utility Pair class
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
