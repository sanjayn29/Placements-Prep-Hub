/*
Question 19:

Write a Java program to process a string containing lowercase letters and digits.

Each digit represents the number of positions that the character immediately following it should move to the left in the string.

Replace the digit with the moved character. If moving the character to the left causes it to go beyond the beginning of the string, use '#' as a placeholder.

Input Format:
- A string containing lowercase English letters and digits.

Output Format:
- Print the transformed string after applying the movement for every digit.

Example:

Input:
ab2x1c

Output:
abaxxc

Explanation:
- Digit '2' indicates that the character immediately after it ('x') should move 2 positions to the left.
- Digit '1' indicates that the character immediately after it ('c') should move 1 position to the left.
- If any movement exceeds the beginning of the string, replace the moved position with '#'.

*/
public class Q19 {
    public static void main(String[] args) {

        String s = "ab2x1c";
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {

            if (Character.isDigit(arr[i])) {

                int move = arr[i] - '0';
                char ch = arr[i + 1];

                int newPos = i - move;

                if (newPos >= 0)
                    arr[newPos] = ch;
                else
                    arr[0] = '#';

                arr[i] = ch;
            }
        }

        // Print only letters (ignore digits)
        for (char ch : arr) {
            if (!Character.isDigit(ch))
                System.out.print(ch);
        }
    }
}
