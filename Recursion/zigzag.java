package Recursion;

import java.util.*;;

public class zigzag {
    public static void printZigZag(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("pre = " + n);
        printZigZag(n - 1);
        System.out.println("In = " + n);
        printZigZag(n - 1);
        System.out.println("Post = " + n);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printZigZag(n);
    }
}
