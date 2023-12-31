package Recursion;

import java.util.*;

public class factorial {
    public static int calculateFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fact = calculateFactorial(n);
        System.out.println(fact);
    }
}
