package Hashing;

import java.util.*;

public class amzonSession63 {

    public static int longestSubstring(String str, int n) {
        HashMap<Character, Integer> start = new HashMap<>();
        HashMap<Character, Integer> end = new HashMap<>();
        int[][] prefix = new int[n][27];
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            end.put(ch, i);
            int u = ch - 'a' + 1;
            prefix[i][u] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            char v = str.charAt(i);
            start.put(v, i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 27; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j];
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (char che = 'a'; che <= 'z'; che++) {

            }
        }
        return 0;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n;
        n = scn.nextInt();
        String s = scn.next();
        int ans = longestSubstring(s, n);

    }
}
