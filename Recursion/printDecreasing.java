package Recursion;

import java.util.*;

public class printDecreasing {
    public static void printing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);

        printing(n - 1);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printing(n);
    }
}
