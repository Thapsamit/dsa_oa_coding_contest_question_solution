package TwoPointer;

import java.util.*;

public class testq {
    public static void main(String[] args) {
        int[] arr = { 6, 9, 7, 83, 612, 92, 10, -2 };
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int k = 90;
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int a = arr[low];
            int b = arr[high];
            if (a + b == k) {
                ArrayList<Integer> ob = new ArrayList<>();
                ob.add(a);
                ob.add(b);
                ans.add(ob);
            } else if (a + b < k)
                low++;
            else if (a + b > k)
                high--;
        }
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; i < 2; j++) {
                System.out.print(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}
