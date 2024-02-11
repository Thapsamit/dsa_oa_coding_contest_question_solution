package String;

import java.util.*;

public class stringRotate {
    public static int findRotate(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int ans = Integer.MAX_VALUE;
        if (n1 != n2) {
            return ans;
        }
        int idx = (s2 + s2).indexOf(s1);
        if (idx == -1) {
            return ans; // rotation not found so return MAX_VALUE;
        }
        int leftRotateVal = n1 - idx; // how many moves required for left rotations
        int rightRotateVal = n1 - leftRotateVal; // how many moves required for right rotation
        if (leftRotateVal < rightRotateVal) {
            return -1 * leftRotateVal;
        } else {
            return rightRotateVal;
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int ans = findRotate(s1, s2);
        System.out.println(ans == Integer.MAX_VALUE ? "null" : ans);

    }
}
