/*
Given a sentence and the width of a screen, replace the spaces between words with '*' characters so that the total length of the string becomes equal to the screen width.

Distribute the extra '*' characters as evenly as possible among all spaces.
If the extra characters cannot be distributed equally, assign the remaining '*' characters from left to right.
Input Format
A string
Screen width (integer)
Output Format
The justified string
Example 1

Input

Enter the String : I LOVE INDIA
Screen length : 20

Output

Ans: I****LOVE****INDIA
 */

import java.util.Scanner;

public class Q25 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str = sc.nextLine();

        System.out.print("Screen length: ");
        int n=sc.nextInt();

        int len = str.length();
        int space = 0;

        for(int i=0;i<len-1;i++){
            char k =str.charAt(i);
            if(k == ' '){
                space++;
            }        
        }
        int sp1 = (n-len);
        int sp2 = sp1/space;
        int mod = sp1%space;

        String res ="";
        for(int i=0;i<len-1;i++){
            char k =str.charAt(i);
            if(k == ' '){
                if(mod>0){
                    res+="*";
                    mod--;
                }
                res+="***";
            }
            else{
                res+=k;
            }    
        }
        System.out.print("Ans: "+res);
    }
}
