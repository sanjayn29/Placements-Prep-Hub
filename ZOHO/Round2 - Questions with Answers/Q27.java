/*
Convert a Number into Words
Write a program to convert a given positive integer into its equivalent English words.

Input Format
A single integer N
Output Format
Print the number in words.
Constraints
0 ≤ N ≤ 999999999 (or any range specified by the interviewer)

Example 1 :

Input
1

Output
One

Example 2 :

Input
99

Output
Ninety Nine

Example 3 :

Input
1982

Output
One Thousand Nine Hundred Eighty Two

Example 4 :

Input
25007

Output
Twenty Five Thousand Seven

*/

import java.util.Scanner;
public class Q27 {

    static String[] ones = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    static String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    static String convert(int n) {

        if (n == 0)
            return "";
        if (n < 20)
            return ones[n];
        if (n < 100)
            return tens[n / 10] + (n % 10 != 0 ? " " + convert(n % 10) : "");
        if (n < 1000)
            return ones[n / 100] + " Hundred" +
                    (n % 100 != 0 ? " " + convert(n % 100) : "");
        if (n < 1000000)
            return convert(n / 1000) + " Thousand" +
                    (n % 1000 != 0 ? " " + convert(n % 1000) : "");
        if (n < 1000000000)
            return convert(n / 1000000) + " Million" +
                    (n % 1000000 != 0 ? " " + convert(n % 1000000) : "");
        return "";

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0)
            System.out.println("Zero");
        else
            System.out.println(convert(n));
        sc.close();

    }
}