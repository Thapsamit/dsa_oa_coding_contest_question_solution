package implementation;

import java.util.Scanner;

public class amazonSession2 {
    public static void main(String[] args) {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        char[] arr = new char[n];
        int g = 0;
        int diff = 2;

        for (int i = 0; i < n; i++) {
            arr[i] = scn.next().charAt(0);
        }
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                g++;
            } else {
                g--;
            }
            prefix[i] = g;
        }
        int d = prefix[n - 1];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int ch = prefix[i];
            if (d == 0) {
                // means AP difference is 0 so we need to check if any of prefix[i] is == diff
                if (prefix[i] == diff) {
                    answer++;
                }
            } else if ((diff - ch) % d == 0) {
                g = (diff - ch) / d;
                if (g >= 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
