package dynamic_programming;

import java.util.*;;

public class atlassianOA {
    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading 't'
        while (t > 0) {
            int b = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading 'b'
            int[] dp1 = new int[b + 1];
            int[] dp2 = new int[b + 1];
            dp1[0] = 1;
            dp2[0] = dp1[0];
            for (int i = 1; i <= b; i++) {
                String line = scanner.nextLine();
                char g = line.charAt(0);
                int e = 0;
                if (line.length() > 2) {
                    e = Integer.parseInt(line.substring(2)); // Extract the integer value
                }
                if (g == '+') {
                    dp1[i] = max(dp1[i - 1] + e, dp2[i - 1] + e, dp1[i - 1]);
                    dp2[i] = min(dp1[i - 1] + e, dp2[i - 1] + e, dp2[i - 1]);
                } else if (g == '-') {
                    dp1[i] = max(dp1[i - 1] - e, dp2[i - 1] - e, dp1[i - 1]);
                    dp2[i] = min(dp1[i - 1] - e, dp2[i - 1] - e, dp2[i - 1]);
                } else if (g == '*') {
                    dp1[i] = max(dp1[i - 1] * e, dp2[i - 1] * e, dp1[i - 1]);
                    dp2[i] = min(dp1[i - 1] * e, dp2[i - 1] * e, dp2[i - 1]);
                } else if (g == '/') {
                    dp1[i] = max(dp1[i - 1] / e, dp2[i - 1] / e, dp1[i - 1]);
                    dp2[i] = min(dp1[i - 1] / e, dp2[i - 1] / e, dp2[i - 1]);
                } else {
                    dp1[i] = max(-1 * dp1[i - 1], -1 * dp2[i - 1], dp1[i - 1]);
                    dp2[i] = min(-1 * dp1[i - 1], -1 * dp2[i - 1], dp2[i - 1]);
                }
            }
            t--;
            System.out.println(dp1[b]);
        }
        scanner.close();
    }
}
