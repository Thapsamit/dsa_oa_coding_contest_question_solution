package implementation;

import java.util.Scanner;

public class linkedinSession10 {
    public static int findIndex(int[] pre, int[] suff, int n) {
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (pre[i] == suff[i]) {
                ans = i;
                break;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] pre = new int[n];
        int[] suff = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        pre[0] = arr[0];
        suff[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = arr[i] + pre[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + arr[i];
        }
        int ans = findIndex(pre, suff, n);
        System.out.println(ans);

    }
}
