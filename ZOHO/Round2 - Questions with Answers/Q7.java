/*
Question 7:

Write a Java program to accept two strings, S1 and S2. Reverse the words in S1, starting from the word where the first occurrence of S2 is found in S1.

The spaces between the words must be preserved exactly as they appear in the input.

Important Note:
1. Do not split the string into an array of words.
2. Do not use built-in String functions such as split(), indexOf(), replace(), substring(), etc.

Example:

Input:
S1 = This is  a test input string
S2 = st

Output:
This is  a string input test */
public class Q7 {
    static boolean pattern(String word1, String word2){
        for(int i=0;i<=word1.length()-word2.length();i++){
            int j;
            for(j=0;j<word2.length();j++){
                if(word1.charAt(i+j) != word2.charAt(j)){
                    break;
                }
            }
            if(j==word2.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String s1 = "This is  a test input string";
        String s2 = "st";

        char res[] = s1.toCharArray();
        String word = "";

        for(int i=0;i<res.length;i++){
            if(res[i] != ' '){
                word+=res[i];
            }
            else{
                if(!word.equals("")){
                    if(pattern(word,s2)){
                        System.out.println("First matching word = " + word);
                        
                    }
                    System.out.print(word);
                    word="";
                }
                System.out.print(" ");
            }
        }
    }
}
