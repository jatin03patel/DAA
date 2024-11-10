import java.util.Arrays;
import java.util.Scanner;

public class DA_makingChangeDP {

    public static void findMinCoinDP(int[] denomination, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : denomination) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] > amount) {
            System.out.println("The amount cannot be made with given denominations.");
        } else {
            System.out.println("Minimum number of coins required: " + dp[amount]);
            printCoinsUsed(denomination, dp, amount);
        }
    }

    public static void printCoinsUsed(int[] denomination, int[] dp, int amount) {
        System.out.println("Coins used to make the amount:");
        int remainingAmount = amount;
        while (remainingAmount > 0) {
            for (int coin : denomination) {
                if (remainingAmount >= coin && dp[remainingAmount] == dp[remainingAmount - coin] + 1) {
                    System.out.println(coin);
                    remainingAmount -= coin;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] denomination = {1000, 500, 100, 50, 25, 10, 5, 1};
        System.out.print("Enter the amount in Rupees: ");
        int amount = scanner.nextInt();
        findMinCoinDP(denomination, amount);
        scanner.close();
    }
}