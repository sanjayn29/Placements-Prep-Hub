/*
Rearrange the Array in Max-Min Order

Given an array of N integers, rearrange the elements such that:

The largest element appears first.
The smallest element appears second.
The second largest element appears third.
The second smallest element appears fourth.
Continue this pattern until all elements are arranged.

Print the final rearranged array.

Input Format
N
a1 a2 a3 ... aN
Output Format
Rearranged array
Example 1

Input

6
1 2 3 4 5 6

Output

6 1 5 2 4 3
 */
import java.util.Scanner;

public class Q26 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i += 2) {

            // Find maximum in remaining array
            int maxIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Place maximum at index i
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            // If odd position exists
            if (i + 1 < n) {

                // Find minimum in remaining array
                int minIndex = i + 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }

                // Place minimum at index i+1
                temp = arr[i + 1];
                arr[i + 1] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}