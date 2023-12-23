package String;

import java.util.*;;

public class amazonSessionOA {
    public static int findPattern(String s, String t) {
        int ans = Integer.MAX_VALUE;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (tMap.containsKey(c) && !sMap.containsKey(c)) {
                ans = 0;
                return ans;
            } else if (tMap.containsKey(c) && sMap.containsKey(c)) {
                int cnt = sMap.get(c) / tMap.get(c);
                ans = Math.min(ans, cnt);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String t = scn.next();
        int ans = findPattern(s, t);
        System.out.println(ans);
    }
}
