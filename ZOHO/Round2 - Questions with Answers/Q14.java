/*
Question:

Write a Java program to rotate all the elements of a given N × M matrix in spiral order by K positions in the clockwise direction and print the resultant matrix.

The matrix should first be traversed in spiral order (clockwise) to obtain the sequence of elements. Rotate this sequence by K positions in the clockwise direction, then place the rotated elements back into the matrix following the same spiral order.

Input Format:
- First line contains two integers N and M representing the number of rows and columns.
- Next N lines contain M integers each, representing the matrix.
- Last line contains an integer K, the number of positions to rotate.

Output Format:
- Print the matrix after rotating its elements in spiral order by K positions.

Example:

Input:
4 4
1  2  3  4
5  6  7  8
9 10 11 12
13 14 15 16
3

Spiral Traversal:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

After Rotating by K = 3:
7 11 10 1 2 3 4 8 12 16 15 14 13 9 5 6

Output:
7 11 10 1
6 13  9 2
5 14 15 3
16 12  8 4 */

public class Q14{
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int n = 4, m = 4;
        int k = 3;
        int[] spiral = new int[n * m];
        int idx = 0;
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        // Store spiral order
        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                spiral[idx++] = mat[top][i];
            top++;

            for (int i = top; i <= bottom; i++)
                spiral[idx++] = mat[i][right];
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    spiral[idx++] = mat[bottom][i];
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    spiral[idx++] = mat[i][left];
                left++;
            }
        }

        // Right rotate by k
        int len = spiral.length;
        k %= len;

        int[] rotated = new int[len];

        for (int i = 0; i < len; i++) {
            rotated[(i + k) % len] = spiral[i];
        }

        // Fill back into matrix
        idx = 0;
        top = 0;
        bottom = n - 1;
        left = 0;
        right = m - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                mat[top][i] = rotated[idx++];
            top++;

            for (int i = top; i <= bottom; i++)
                mat[i][right] = rotated[idx++];
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    mat[bottom][i] = rotated[idx++];
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    mat[i][left] = rotated[idx++];
                left++;
            }
        }

        // Print Result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}