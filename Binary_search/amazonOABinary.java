package Binary_search;

import java.util.*;

public class amazonOABinary {
    public static int isCheck(int m, ArrayList<Integer> t, int k) {
        int x = 0;
        for (int i = 1; i < m; i++) {
            x += t.get(i) - t.get(i - 1) - 1;
        }
        if (x <= k) {
            return 1;
        }
        for (int i = m; i < t.size(); i++) {
            x += t.get(i) - t.get(i - 1) - 1;
            x -= t.get(i - m + 1) - t.get(i - m) - 1;
            if (x <= k) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 8, k = 3;
        ArrayList<Integer> v = new ArrayList<Integer>(Arrays.asList(1, -2, 1, 1, 3, 2, 1, -2));
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {

            int key = v.get(i);
            if (!mp.containsKey(key)) { // if the element is not present in the map, then create a new ArrayList for
                                        // that element
                mp.put(key, new ArrayList<Integer>());
            }
            mp.get(key).add(i); // add the index of the element to the corresponding ArrayList
        }
        int finalAns = 0;
        // iterating through the keys of the map
        for (Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet()) {
            ArrayList<Integer> t = entry.getValue(); // storing the ArrayList containing all the positions (indices) of
                                                     // the current element in t
            int l = 0;
            int h = t.size();
            int ans = 0;
            // applying binary search to to check that whether we are able to get a valid
            // answer for the current window size (mid)
            while (l <= h) {
                int mid = (l + h) / 2;
                int x = isCheck(mid, t, k);
                if (x == 1) { // if answer is valid for the current window size mid (or m) then it might be
                              // the case that it is possible for larger size so we increase mid to get a
                              // larger window
                    ans = mid;
                    l = mid + 1; // continuing further to obtain a better answer or larger window (if possible)
                } else {
                    h = mid - 1; // else we decrease the window size which we are checking
                }
            }
            finalAns = Math.max(finalAns, ans); // updating the answer
        }
        System.out.println(finalAns);
    }
}
