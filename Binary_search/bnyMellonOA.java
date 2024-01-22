package Binary_search;

import java.util.*;;

public class bnyMellonOA {
    public static boolean isPossible(int mid, int tot, int sell, int upgrade, int money) {
        int profitFromSelling = mid * sell;
        int totalMoneyAfterSelling = money + profitFromSelling;
        int leftHouseToUpgrade = tot - mid;
        if (totalMoneyAfterSelling >= leftHouseToUpgrade * upgrade) {
            return true;
        } else {
            return false;
        }
    }

    public static int solve(int tot, int money, int sell, int upgrade) {

        int low = 0;
        int high = tot - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(mid, tot, sell, upgrade, money)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (tot - low);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] tot = new int[n];
        int[] money = new int[n];
        int[] sell = new int[n];
        int[] upgrade = new int[n];
        for (int i = 0; i < n; i++) {
            tot[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            money[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sell[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            upgrade[i] = scn.nextInt();
        }

        for (int j = 0; j < n; j++) {
            int maxUpgrade = solve(tot[j], money[j], sell[j], upgrade[j]);
            System.out.println(maxUpgrade);
        }

    }
}
