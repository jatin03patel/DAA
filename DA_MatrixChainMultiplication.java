import java.util.Scanner;

public class DA_MatrixChainMultiplication {

    public static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];

        // dp[i][i] is 0 since only one matrix, so no cost of multiplication
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L is chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1]; // Minimum cost to multiply the full chain of matrices
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of matrices: ");
        int n = scanner.nextInt();

        int[] p = new int[n + 1];
        System.out.println("Enter the dimensions of matrices:");
        for (int i = 0; i <= n; i++) {
            System.out.print("p[" + i + "] = ");
            p[i] = scanner.nextInt();
        }

        int minMultiplications = matrixChainOrder(p, n + 1);
        System.out.println("Minimum number of scalar multiplications: " + minMultiplications);

        scanner.close();
    }
}
