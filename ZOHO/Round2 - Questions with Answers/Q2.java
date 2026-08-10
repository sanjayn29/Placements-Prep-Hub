/*
Question 2:

Write a Java program using recursion to find the decimal equivalent of a given binary number.

Example 1:
Input: 110010
Output: 50

Example 2:
Input: 100100
Output: 36

Example 3:
Input: 100
Output: 4
*/
public class Q2 {
    static int binarycal(long n,int pos){
        if(n==0){
            return 0;
        }
        int lastbit = (int)(n%10);
        return lastbit*(1<<pos) + binarycal(n/10,pos+1);
    }
    public static void main(String[] args){
        long binary = 100100;
        int decimal = binarycal(binary,0);
        System.out.println(decimal);
    }
}
