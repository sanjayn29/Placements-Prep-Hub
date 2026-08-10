/*
1. Minimum Operations to Make an Array Palindrome Given an integer array, in one operation you can choose any contiguous subarray and add 1 to every element in it. Find the minimum number of operations required to make the entire array a palindrome. Sample Input [1, 2, 3, 2, 1, 0] Sample Output : 1
 */
public class Q13 {
    static int operations(int arr[]) {
        int n = arr.length;

        // Build the smallest possible palindrome
        int[] finalArr = new int[n];
        for (int i = 0; i < (n + 1) / 2; i++) {
            int val = Math.max(arr[i], arr[n - 1 - i]);
            finalArr[i] = val;
            finalArr[n - 1 - i] = val;
        }

        // Required increments
        int[] inc = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = finalArr[i] - arr[i];
        }

        // Minimum interval additions
        int ans = inc[0];
        for (int i = 1; i < n; i++) {
            if (inc[i] > inc[i - 1]) {
                ans += inc[i] - inc[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 2, 1, 0};
        System.out.println(operations(arr));
    }
}