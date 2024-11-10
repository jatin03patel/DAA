import java.util.Scanner;

public class DA_knapsackDP {

    public static int knapsackDP(int[] val, int[] weight, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i - 1]] + val[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] val = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int W = 50; // Maximum weight capacity of the knapsack

        int maxValue = knapsackDP(val, weight, W);
        System.out.println("Maximum value in knapsack = " + maxValue);
        scanner.close();
    }
}
