/*
Question 18:

Write a Java program to sort all the odd numbers in ascending order and all the even numbers in descending order, while preserving their original positions in the array.

The positions of odd and even numbers must remain unchanged:
- Elements originally at odd-number positions (odd values) should still contain odd numbers.
- Elements originally at even-number positions (even values) should still contain even numbers.
- Only the values are rearranged according to the required sorting order.

Requirements:
- Sort all odd numbers in ascending order.
- Sort all even numbers in descending order.
- Preserve the original odd/even positions in the array.

Input Format:
- First line contains an integer N, the size of the array.
- Second line contains N integers.

Output Format:
- Print the rearranged array.

Example:

Input:
8
5 2 8 1 7 4 3 6

Output:
1 8 6 3 5 4 7 2

Explanation:
Odd numbers: 5, 1, 7, 3
Sorted ascending: 1, 3, 5, 7

Even numbers: 2, 8, 4, 6
Sorted descending: 8, 6, 4, 2

The sorted odd numbers are placed back into the positions originally occupied by odd numbers, and the sorted even numbers are placed back into the positions originally occupied by even numbers.
 */
public class Q18 {
    public static void main(String[] args) {

        int arr[] = {5, 2, 8, 1, 7, 4, 3, 6};

        int oddCount = 0;
        int evenCount = 0;

        // Count odd and even
        for (int x : arr) {
            if (x % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        int odd[] = new int[oddCount];
        int even[] = new int[evenCount];

        int oi = 0, ei = 0;

        // Separate odd and even
        for (int x : arr) {
            if (x % 2 == 0)
                even[ei++] = x;
            else
                odd[oi++] = x;
        }

        // Bubble sort odd (Ascending)
        for (int i = 0; i < odd.length - 1; i++) {
            for (int j = 0; j < odd.length - i - 1; j++) {
                if (odd[j] > odd[j + 1]) {
                    int temp = odd[j];
                    odd[j] = odd[j + 1];
                    odd[j + 1] = temp;
                }
            }
        }

        // Bubble sort even (Descending)
        for (int i = 0; i < even.length - 1; i++) {
            for (int j = 0; j < even.length - i - 1; j++) {
                if (even[j] < even[j + 1]) {
                    int temp = even[j];
                    even[j] = even[j + 1];
                    even[j + 1] = temp;
                }
            }
        }

        oi = 0;
        ei = 0;

        // Put back into original positions
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 0)
                arr[i] = even[ei++];
            else
                arr[i] = odd[oi++];
        }

        // Print result
        for (int x : arr)
            System.out.print(x + " ");
    }
}
