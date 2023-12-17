package implementation;

import java.util.*;;

public class googleSession8 {

    public static int minDeletionSize(String[] A, int n) {
        int ans = 0;
        HashSet<Integer> di = new HashSet<>();

        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j < A[i].length(); ++j) {
                // we skip in two cases: if the current column is present in the set, it means
                // it has been removed, so skip it and look for the next column
                // the second case is when the adjacent elements are the same, then we look for
                // further columns
                if (di.contains(j) || A[i - 1].charAt(j) == A[i].charAt(j)) {
                    continue;
                }
                // in case the rule is violated, put it in the set
                if (A[i - 1].charAt(j) > A[i].charAt(j)) {
                    di.add(j);
                    i = 0; // in the next iteration, this i will be set to 1 as i++ will be done by the
                           // loop
                }
                // if the above if condition is skipped and we have reached here, it means the
                // condition A[i-1][j] < A[i][j] is satisfied
                // and in that case, simply increment the row counter (i) to compare between two
                // strings
                break;
            }
        }
        return di.size();
    }

    public static void main(String[] args) {
        String[] strs = { "case", "care", "test", "code" };
        System.out.println(minDeletionSize(strs, strs.length));
    }
}
