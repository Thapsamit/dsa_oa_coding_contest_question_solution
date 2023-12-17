package implementation;

import java.util.*;;

public class amazonSession7 {
    public static int parties(int[] person, char[] inOut, int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            char ch = inOut[i];
            int p = person[i];
            if (ch == '+') {
                if (hashSet.contains(p)) {
                    return -1;
                } else {
                    hashSet.add(p);
                }
            } else {
                if (hashSet.contains(p)) {
                    hashSet.remove(p);
                } else {
                    return -1;
                }
            }
            ans = Math.max(ans, hashSet.size());
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] person = new int[n];
        char[] inOut = new char[n];
        for (int i = 0; i < n; i++) {
            person[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inOut[i] = scn.next().charAt(0);
        }
        int ans = parties(person, inOut, n);
        System.out.println(ans);

    }
}
