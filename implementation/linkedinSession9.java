package implementation;

import java.util.*;;

public class linkedinSession9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char last = 'A';
        int ans = 0;

        for (char i : s.toCharArray()) {
            ans += Math.min((i - last + 26) % 26, (last - i + 26) % 26);
            last = i;
        }

        System.out.println(ans);
    }
}
