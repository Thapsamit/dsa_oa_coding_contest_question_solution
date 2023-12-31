package Recursion;

import java.util.*;;

public class powerLogarithmic {
    public static int calPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xn = calPower(x, n / 2);
        int val = xn * xn;
        if (n % 2 != 0) {
            val *= xn;
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int powerVal = calPower(x, n);
        System.out.println(powerVal);
    }
}
