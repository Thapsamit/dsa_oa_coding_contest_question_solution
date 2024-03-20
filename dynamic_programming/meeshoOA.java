package dynamic_programming;

import java.util.*;;

public class meeshoOA {
    public static int solution(int[] b, int n) {
        int[][] dp = new int[n + 1][2];
        int[] ans = new int[n + 1];
        HashMap<Integer, Integer> k = new HashMap<>();
        dp[1][0] = 1; // As we haven't picked this element to be removed so size will be one
        dp[1][1] = Integer.MAX_VALUE;
        ans[1] = Math.min(dp[1][0], dp[1][1]);
        k.put(b[1], 0);

        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1 + ans[i - 1];
            int v = Integer.MAX_VALUE;

            if (k.containsKey(b[i])) {
                v = Math.min(v, k.get(b[i]));
            }

            dp[i][1] = v;
            ans[i] = Math.min(dp[i][0], dp[i][1]);

            if (!k.containsKey(b[i])) {
                k.put(b[i], ans[i - 1]);
            } else {
                k.put(b[i], Math.min(k.get(b[i]), ans[i - 1]));
            }
        }
        return Math.min(dp[n][0], dp[n][1]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        int ans = solution(b, n);
        System.out.println(ans);

    }
}
