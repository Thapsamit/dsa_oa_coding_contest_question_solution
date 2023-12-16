package implementation;

import java.util.*;;

public class amazonSession3 {
    public static void main(String[] args) {
        int n, m;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        ArrayList<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scn.next();
            patterns.add(s);
        }
        int ans = 0;

        for (int i = 0; i < m; i++) {
            char ch = '?';
            for (int j = 0; j < n; j++) {

                char currCh = patterns.get(j).charAt(i);

                if (currCh == '?') {
                    continue;
                }
                if (ch == '?' && ch != currCh) {
                    // we got first unique character other than ? now ideally all other should be
                    // equal to this only
                    ch = currCh;
                } else if (ch != '?' && ch != currCh) {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
