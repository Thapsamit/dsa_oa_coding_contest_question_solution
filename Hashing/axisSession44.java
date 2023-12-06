package Hashing;

import java.util.*;
import java.io.*;
import java.lang.*;

public class axisSession44 {
    public static void main(String[] args) {
        System.out.println("Enter n :- \n");

        Scanner scn = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scn.next();
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            if (v > 1) {
                ans.add(k);
            }
        }
        Collections.sort(ans);
        for (String sh : ans) {
            System.out.println(sh);
        }
    }
}
