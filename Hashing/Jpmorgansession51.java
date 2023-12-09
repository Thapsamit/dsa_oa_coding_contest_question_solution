package Hashing;

import java.util.*;

public class Jpmorgansession51 {

    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character ch = s1.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        for (int j = 0; j < s2.length(); j++) {
            Character cs = s2.charAt(j);
            if (sMap.containsKey(cs)) {
                sMap.put(cs, sMap.get(cs) - 1);
                if (sMap.get(cs) == 0) {
                    sMap.remove(cs);
                }
            } else {
                return false;
            }
        }

        return sMap.size() == 0 ? true : false;

    }

    public static List<String> funAnagram(String[] arr, int n) {
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                stk.push(arr[i]);
            } else {
                String str = stk.peek();
                String curr = arr[i];
                if (isAnagram(str, curr)) {
                    continue;
                } else {
                    stk.push(arr[i]);
                }
            }
        }

        List<String> ans = new ArrayList<String>();
        while (!stk.empty()) {
            ans.add(stk.pop());
        }
        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.next();
        }
        List<String> ans = funAnagram(arr, n);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }

    }
}
