package Recursion;

import java.util.*;;

public class powerLinear {
    public static int calPower(int x, int n) {
        if (n == 1) {
            return x;
        }
        return x * calPower(x, n - 1);
    }

    public static void main(String[] args) {
        // we have X^n => x*X*X...n
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int power = calPower(x, n);
        System.out.println(power);
    }
}
