/*
Question:

Write a Java program to rearrange a given array into a wave-like array.

A wave array is an arrangement of elements such that:

a1 >= a2 <= a3 >= a4 <= a5 ...

That is,
- Every element at an even position (2nd, 4th, ...) is less than or equal to its adjacent elements.
- Every element at an odd position (1st, 3rd, ...) is greater than or equal to its adjacent elements.

If multiple valid wave arrangements are possible, print any one of them.

Input Format:
- First line contains an integer N, the size of the array.
- Second line contains N integers.

Output Format:
- Print the array in wave form.

Example 1:

Input:
4
1 2 3 4

Output:
2 1 4 3

Another Valid Output:
4 1 3 2

Example 2:

Input:
6
10 5 6 3 2 20

Output:
10 5 6 2 20 3
*/
import java.util.Arrays;
public class Q15 {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i += 2) {

            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;

        }

        System.out.print("Wave Array : ");

        for (int x : arr)
            System.out.print(x + " ");
    }
}