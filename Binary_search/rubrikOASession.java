package Binary_search;

import java.util.Scanner;

public class rubrikOASession {
    static int maxChocolates(int G) {
        if (G % 2 == 0) {
            return (G / 2 * (G / 2 + 1));
        } else {
            int V = G / 2;
            int Y = G / 2 + 1;
            int G1 = V * (V + 1) / 2; // where V = G // 2 (integer division)
            int G2 = Y * (Y + 1) / 2; // where Y = G // 2 + 1 (integer division)
            return (G1 + G2);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (maxChocolates(mid) >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}
