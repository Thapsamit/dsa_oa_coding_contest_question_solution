package Recursion;

import java.util.*;

public class printIncreasingDecreasing {
    public static void printing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printing(n - 1);
        System.out.println(n);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printing(n);
    }
}
