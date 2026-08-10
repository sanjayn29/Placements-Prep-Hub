/*
Question 16:

Write a Java program to find the maximum sum of any K × K submatrix in a given N × N matrix.

A K × K submatrix is formed by selecting K consecutive rows and K consecutive columns from the given matrix.

Your task is to find the submatrix whose elements have the maximum possible sum and print that sum.

Input Format:
- First line contains two integers N and K.
- Next N lines contain N integers each, representing the matrix.

Output Format:
- Print the maximum sum among all possible K × K submatrices.

Example:

Input:
3 2
1 2 3
4 5 6
7 8 9

Output:
28

Explanation:
The 2 × 2 submatrix with the maximum sum is:

5 6
8 9

Sum = 5 + 6 + 8 + 9 = 28
 */
public class Q16 {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int n = 3;
        int k = 2;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int sum = 0;
                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        sum += mat[r][c];
                    }
                }
                if (sum > max)
                    max = sum;
            }
        }
        System.out.print(max);
    }
}