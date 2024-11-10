import java.util.Scanner;

public class GA_makingChange {
    public static void findMinCoin(int[] denomination, int amount) {
        int coinCount = 0;
        System.out.println("coins used to make the amount:");

        for (int i = 0; i < denomination.length; i++) {
            if (amount >= denomination[i]) {
                int numCoins = amount / denomination[i];
                amount = amount % denomination[i];
                coinCount += numCoins;
                System.out.println(denomination[i] + " X " + numCoins);
            }
        }
        if (amount != 0) {
            System.out.println("The amount cannot be made with given demomations.");
        } else {
            System.out.println("minimum number of coins required: " + coinCount);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] denomination = { 1000, 500, 100, 50, 25, 10, 5, 1 };

        System.out.print("Enter the amount in Rupees: ");
        int amount = scanner.nextInt();

        findMinCoin(denomination, amount);
        scanner.close();
    }
}