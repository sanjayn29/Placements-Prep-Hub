/*
This is a triangular number pattern. The trick is that the first number of each row is not consecutive—it is calculated, and then the remaining numbers are obtained by subtracting increasing values.

For n = 5:

    1
   6 2
 10 7 3
13 11 8 4
15 14 12 9 5

 */
import java.util.Scanner;

class Q23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Size: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            // Print spaces
            for (int s = 1; s <= n - i; s++) {
                System.out.print("   ");
            }

            // First number of the row
            int num = 1 + (i - 1) * n - ((i - 1) * (i - 2)) / 2;

            // Print row
            for (int j = 1; j <= i; j++) {
                System.out.printf("%2d ", num);

                // Difference between consecutive numbers
                num -= (n - i + j);
            }

            System.out.println();
        }

        sc.close();
    }
}