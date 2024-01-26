package Binary_search;

import java.util.*;

public class amazonOASde {
    static int count(int[] b, int n, int k) {
        int i = 1;
        int j = 1;
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(b[0], 1);
        while (j < n) {
            int v = hashMap.size();
            if (v <= k) {
                int l = Math.abs(i - j) + 1;
                count += l;
                j++;
                if (j < n) {
                    hashMap.put(b[j], hashMap.getOrDefault(b[j], 0) + 1);
                }
            } else {
                hashMap.put(b[i], hashMap.get(b[i]) - 1);
                if (hashMap.get(b[i]) == 0) {
                    hashMap.remove(b[i]);
                }
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int tot = n * (n + 1) / 2;
        int ans = 0;
        int low = 1;
        int high = n;
        int v = 0;
        if (tot % 2 == 0) {
            v = tot / 2;
        } else {
            v = tot / 2 + 1;
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (count(b, n, mid) >= v) {
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }
        System.out.print(low);
    }
}
