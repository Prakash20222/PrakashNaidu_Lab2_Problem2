package currency.solver.currencysolver;

import java.util.Arrays;
import java.util.Scanner;

public class CurrencyPaymentSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of currency denominations
        System.out.println("Enter the size of currency denominations:");
        int size = scanner.nextInt();

        // Input the currency denominations values
        System.out.println("Enter the currency denominations values:");
        int[] denominations = new int[size];
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        // Sort the denominations in descending order
        Arrays.sort(denominations);
        reverseArray(denominations);

        // Input the amount you want to pay
        System.out.println("Enter the amount you want to pay:");
        int amount = scanner.nextInt();

        // Calculate the minimum number of notes
        calculateMinimumNotes(denominations, amount);

        scanner.close();
    }

    // Function to reverse the array
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to calculate the minimum number of notes
    private static void calculateMinimumNotes(int[] denominations, int amount) {
        System.out.println("Your payment approach in order to give the minimum number of notes will be:");

        for (int denomination : denominations) {
            int count = amount / denomination;
            if (count > 0) {
                System.out.println(denomination + ":" + count);
                amount %= denomination;
            }
        }
    }
}
