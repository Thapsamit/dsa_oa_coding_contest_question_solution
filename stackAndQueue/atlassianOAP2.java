package stackAndQueue;

import java.util.*;

public class atlassianOAP2 {
    public static int[] rightGreater(int n, int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                while (!st.isEmpty() && arr[st.peek()] <= val) {
                    st.pop(); // pop if less
                }
                if (st.isEmpty()) {
                    ans[i] = n;
                } else {
                    ans[i] = st.peek();
                }
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] leftGreater(int n, int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                while (!st.isEmpty() && arr[st.peek()] <= val) {
                    st.pop(); // pop if less
                }
                if (st.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = st.peek();
                }
            }
            st.push(i);
        }
        return ans;
    }

    public static int solution(int[] arr, int n) {
        int[] right = rightGreater(n, arr);
        int[] left = leftGreater(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.print(right[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(left[i] + " ");
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int rightGreaterIndex = right[i];
            int leftGreaterIndex = left[i];
            int y = rightGreaterIndex - i - 1;
            int x = i - leftGreaterIndex - 1;
            ans += arr[i] * (x * y + 1 + x + y);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = solution(arr, n);
        System.out.println(ans);
    }
}
