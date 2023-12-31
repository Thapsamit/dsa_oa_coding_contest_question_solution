package Recursion;

import java.util.*;

public class printIncreasing {
    public static void printing(int n) {
        if (n == 0) {
            return;
        }
        printing(n - 1);
        System.out.println(n);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printing(n);
    }
}
