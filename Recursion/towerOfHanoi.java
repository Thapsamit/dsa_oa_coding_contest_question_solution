package Recursion;

import java.util.*;

public class towerOfHanoi {
    public static void toh(int n, String t1, String t2, String t3) {
        if (n == 0) {
            return;
        }
        toh(n - 1, t1, t3, t2); // print instr. to move n-1 disks from t1 to t3 using t2
        System.out.println(n + "[" + t1 + " -> " + t2 + "]");
        toh(n - 1, t3, t2, t1);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String t1 = scn.next();
        String t2 = scn.next();
        String t3 = scn.next();
        toh(n, t1, t2, t3);

    }
}
