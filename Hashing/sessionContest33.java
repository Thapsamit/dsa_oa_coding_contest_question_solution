package Hashing;

import java.util.*;

public class sessionContest33 {
    public static void main(String[] args) {
        String s = "1011001";
        int n = s.length();

        if (s.charAt(0) != s.charAt(n - 1)) {
            System.out.println(2);
        } else {
            System.out.println(n - 2);
        }
    }
}
