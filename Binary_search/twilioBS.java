package Binary_search;

import java.util.*;

public class twilioBS {
    public static boolean check(int mid, int[] A, int[] B, int budget) {
        int tot = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < mid) {
                if (mid % A[i] == 0) {
                    int v1 = mid / A[i];
                    tot += (v1 - 1) * B[i];
                } else {
                    int v2 = (mid / A[i]) + 1;
                    tot += (v2 - 1) * B[i];
                }
            }
        }
        return tot <= budget;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = scn.nextInt();
        }
        int budget = scn.nextInt();
        int low = 1;
        int high = budget;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, A, B, budget)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);

    }
}
