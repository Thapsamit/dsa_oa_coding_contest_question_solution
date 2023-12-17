package implementation;

import java.util.*;;

public class amazonSession4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        HashSet<Double> hashSet = new HashSet<>();
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        while (left < right) {
            double x = ((double) arr[left] + (double) arr[right]) / 2.0;
            hashSet.add(x);
            left++;
            right--;
        }
        System.out.println(hashSet.size());
    }
}
