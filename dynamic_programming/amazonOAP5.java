package dynamic_programming;

import java.util.*;

public class amazonOAP5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Map<Integer, Integer> sortedMap = new TreeMap<>();
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            sortedMap.put(arr[i], 1);
        }
        int finalAnswer = 1;

        // Update sortedMap
        for (int current : sortedMap.keySet()) {

            int search = (int) Math.sqrt(current);
            if (search * search == current && sortedMap.containsKey(search)) {
                sortedMap.put(current, 1 + sortedMap.get(search));
            }
            finalAnswer = Math.max(finalAnswer, sortedMap.get(current));
        }

        System.out.println(finalAnswer);
    }
}
