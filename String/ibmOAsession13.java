package String;

import java.util.*;

public class ibmOAsession13 {
    public static int winner(String str) {
        int n = str.length();
        int vowel = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            }
        }
        if (vowel == 0) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int ans = winner(str);
        System.out.println(ans);
        System.out.println(ans == 1 ? "Alex" : "Chris");
    }
}
