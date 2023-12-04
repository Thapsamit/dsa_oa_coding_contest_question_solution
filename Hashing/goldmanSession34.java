package Hashing;

import java.util.*;

public class goldmanSession34 {
    public static void main(String[] args) {
        List<String> dates = new ArrayList<>();
        dates.add("20th Oct 2052");
        dates.add("6th Jun 1933");
        dates.add("26th May 1960");

        List<String> ans = new ArrayList<>();

        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        for (String date : dates) {
            String day = "";
            String month = "";
            String year = "";

            if (Character.isDigit(date.charAt(1))) {
                day = date.substring(0, 2);
            } else {
                day = "0" + date.substring(0, 1);
            }

            String[] parts = date.split(" ");
            String monthName = parts[1];
            month = monthMap.get(monthName);

            year = parts[2];

            ans.add(year + "-" + month + "-" + day);
        }

        for (String date : ans) {
            System.out.println(date);
        }
    }
}
