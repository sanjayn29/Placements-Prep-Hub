/*
Question 20:

Write a Java program to sort the elements of an array based on their frequency.

Sorting Rules:
1. Elements with higher frequency should appear first.
2. If two or more elements have the same frequency, arrange them in ascending order.
3. Print each element as many times as it appears in the original array.

Input Format:
- First line contains an integer N, the size of the array.
- Second line contains N integers.

Output Format:
- Print the elements sorted according to their frequency.

Example:

Input:
9
4 5 6 5 4 4 6 5 2

Output:
4 4 4 5 5 5 6 6 2

Explanation:
Frequencies:
4 → 3
5 → 3
6 → 2
2 → 1

Elements with the highest frequency (4 and 5) appear first.
Since 4 and 5 have the same frequency, they are arranged in ascending order.
Then comes 6 (frequency = 2), followed by 2 (frequency = 1).
 */
public class Q20 {
    public static void main(String[] args) {

        int arr[] = {4, 5, 6, 5, 4, 4, 6, 5, 2};

        int n = arr.length;

        int freq[] = new int[n];
        boolean visited[] = new boolean[n];

        // Count frequency
        for (int i = 0; i < n; i++) {

            if (visited[i])
                continue;

            int count = 1;

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            freq[i] = count;
        }

        // Bubble sort based on frequency
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (freq[j] < freq[j + 1] ||
                   (freq[j] == freq[j + 1] && arr[j] > arr[j + 1])) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    temp = freq[j];
                    freq[j] = freq[j + 1];
                    freq[j + 1] = temp;

                    boolean b = visited[j];
                    visited[j] = visited[j + 1];
                    visited[j + 1] = b;
                }
            }
        }

        // Print result
        boolean printed[] = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (printed[i])
                continue;

            for (int k = 0; k < freq[i]; k++) {
                System.out.print(arr[i] + " ");
            }

            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j])
                    printed[j] = true;
            }
        }
    }
}
