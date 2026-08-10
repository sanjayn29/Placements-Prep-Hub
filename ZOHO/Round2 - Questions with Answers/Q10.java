/*
Question 10:

Write a Java program to group together all anagrams from a given array of words and print the groups.

Definition:
Two words are anagrams if they contain exactly the same letters with the same frequency, but arranged in a different order.

Requirements:
1. Group all words that are anagrams of each other.
2. Print the anagram groups.
3. Print the remaining words under "Others".
4. Design the most efficient algorithm possible.

Example 1:

Input:
{tar, rat, banana, atr, nanaba}

Output:
Anagrams:
{{tar, rat, atr}, {banana, nanaba}}

Example 2:

Input:
{abc, cde, xyz, dec}

Output:
Anagrams:
{{cde, dec}}

Others:
{{abc}, {xyz}}

Example 3:

Input:
{a, bc, c}

Output:
Anagrams:
{}

Others:
{{a}, {bc}, {c}} */

public class Q10 {

    static void sort(char arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    char temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static boolean anagram(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();
        
        sort(str1);
        sort(str2);

        for(int i=0;i<str1.length;i++){
            if(str1[i] != str2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        String words[]={
                "tar",
                "rat",
                "banana",
                "atr",
                "nanaba"
        };
        boolean visit[] = new boolean[words.length];
        System.out.print("Anagram Groups : ");
        
        for(int i=0;i<words.length;i++){
            if(visit[i]){
                continue;
            }
            int count = 0;
            for(int j=i+1;j<words.length;j++){
                if(anagram(words[i],words[j])){
                    if(count==0){
                        System.out.print("{"+words[i]);
                        visit[i]=true;
                    }
                    System.out.print(","+words[j]);
                    visit[j]=true;
                    count++;
                }
            }
            if(count>0){
                System.out.print("}");
            }
        }
    }
}
