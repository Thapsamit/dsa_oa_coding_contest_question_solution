package Hashing;

import java.util.*;

public class ciscoSession43 {
    public static void main(String[] args) {
        long[][] request = { { 1, 8 }, { 4, 9 }, { 6, 7 } };
        long rate = 2;
        long maxPacket = 10;
        long i = 0;
        long n = request.length;
        HashMap<Long, Long> hashMap = new HashMap<>();
        while (i < n) {
            hashMap.put(request[(int) i][0], request[(int) i][1]);
            i++;
        }
        i = 0;
        long current = 0;
        long dropped = 0;
        while (i < n) {
            long t = request[(int) i][0];
            current += hashMap.get(t);
            if (current > maxPacket) {
                long drop = current - maxPacket;
                dropped += drop;
                current = maxPacket;
            }
            if (i <= n - 2) {
                long t1 = request[(int) i + 1][0];
                long diff = t1 - t;
                current -= (rate * diff);

            }
            if (current < 0) {
                current = 0;
            }
            i++;
        }
        System.out.println(dropped);
    }
}
