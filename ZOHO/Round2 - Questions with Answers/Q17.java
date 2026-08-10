/*
Question 17:

Write a Java program to find the minimum possible sum of the digits of all elements in an array after adding the same non-negative integer to every element.

Let:

f(x) = sum of the digits of x

You may choose any non-negative integer X and add it to every element of the array.

Your task is to determine the value of X that minimizes:

f(A[0] + X) + f(A[1] + X) + ... + f(A[N-1] + X)

and print the minimum possible sum.

Input Format:
- First line contains an integer N, the size of the array.
- Second line contains N integers representing the array elements.

Output Format:
- Print the minimum possible sum of digits after adding the same non-negative integer to every element.

Example:

Input:
4
4 13 8 6

Output:
14

Explanation:
Choose X = 7.

Modified array:
11 20 15 13

Sum of digits:
f(11) = 2
f(20) = 2
f(15) = 6
f(13) = 4

Total = 2 + 2 + 6 + 4 = 14
 */
public class Q17 {
    static int digitSum(int n) {

        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        int arr[] = {4, 13, 8, 6};

        int min = Integer.MAX_VALUE;
        int bestX = 0;

        // Try every x
        for (int x = 0; x <= 1000; x++) {

            int total = 0;

            for (int i = 0; i < arr.length; i++) {
                total += digitSum(arr[i] + x);
            }

            if (total < min) {
                min = total;
                bestX = x;
            }
        }

        System.out.println("Minimum Sum = " + min);
        System.out.println("Best x = " + bestX);
    }
}