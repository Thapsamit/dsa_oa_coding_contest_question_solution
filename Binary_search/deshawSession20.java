package Binary_search;

public class deshawSession20 {

    public static boolean isCheck(int x, int k, int[] b, int n) {
        int i = 0;
        int g = 0;

        while (i < n) {
            if (b[i] % x == 0) {
                g = g + (b[i] / x);
            } else {
                g = g + (b[i] / x) + 1;
            }
            i++;
        }

        return g <= k;
    }

    public static void main(String[] args) {

        int[] b = { 1, 2, 3, 4, 5 };
        int k = 10;
        int n = b.length;

        int low = 1;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < b.length; i++) {
            maxi = Math.max(maxi, b[i]);
        }
        int high = maxi;
        boolean isNotFound = true;
        int answer = -1;
        while (low <= high && isNotFound) {
            int mid = (low + high) / 2;

            if (isCheck(mid, k, b, n)) {
                if (mid == 1) {
                    answer = 1;
                    isNotFound = false;
                } else if (!isCheck(mid - 1, k, b, n)) {
                    answer = mid;
                    isNotFound = false;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
