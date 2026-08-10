/*
21. Given a String, remove the palindromic words from the string and print the remaining string.
Input:    I love malayalam language
Output: I love language
 */
public class Q21 {
    static boolean isPalindrome(String word) {

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {

            if (word.charAt(left) != word.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String str = "I love malayalam language";

        String words[] = str.split(" ");

        for (int i = 0; i < words.length; i++) {

            if (!isPalindrome(words[i])) {
                System.out.print(words[i] + " ");
            }

        }
    }
}
