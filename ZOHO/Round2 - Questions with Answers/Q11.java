/*
Question 11:

Write a Java program to implement regular expression matching between an input string and a pattern.

The pattern supports the following special characters:

'.'  : Matches any single character.
'*'  : Matches zero or more occurrences of the immediately preceding character.

The program should return a boolean value indicating whether the entire input string matches the given pattern. Partial matches are not allowed.

Requirements:
1. Match the entire input string against the pattern.
2. Support '.' as a wildcard for any single character.
3. Support '*' to represent zero or more occurrences of the preceding element.
4. Return true if the entire string matches the pattern; otherwise, return false.

Example 1:

Input:
s = "aa"
p = "a"

Output:
false

Explanation:
The pattern "a" matches only one character, but the input string contains two characters.

Example 2:

Input:
s = "aa"
p = "a*"

Output:
true

Explanation:
'a*' means zero or more occurrences of 'a', so it matches "aa".

Example 3:

Input:
s = "ab"
p = ".*"

Output:
true

Explanation:
'.*' matches zero or more occurrences of any character, so it matches the entire string "ab".
*/
public class Q11 {
    static boolean match(String s,String p){
        if(p.length()==0){
            return s.length()==0;
        }

        boolean first = (s.length() > 0) && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.');

        if(p.length() >= 2 && p.charAt(1)=='*'){
            return match(s,p.substring(2)) || (first&&match(s.substring(1),p));
        }

        return first&&match(s.substring(1),p.substring(1));
    }

    public static void main(String[] args){
        String s = "aa";
        String p = "a*";
        System.out.print(match(s,p));
    }
}
