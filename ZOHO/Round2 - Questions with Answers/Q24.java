/*
Problem: Maximum Profit from Buying and Selling a Stock

You are given an array of integers where each element represents the price of a stock on a particular day.

You are allowed to:

Buy the stock only once.
Sell the stock only once.
The stock must be bought before it is sold.

Find the maximum profit that can be earned. If no profit is possible, print 0.

Input Format
n
price1 price2 price3 ... priceN
Output Format
Maximum value : <profit>
 */

import java.util.Scanner;
public class Q24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int buy = arr[0];
        int sell = arr[n-1];
        int i=0;
        int j=n-1;
        while(i<j){
            if(arr[i]<buy){
                buy=arr[i];
            }
            if(arr[j]>sell){
                sell=arr[j];
            }
            i++;
            j--;
        }
        int cur = sell - buy;
        if(cur < 0){
            System.out.print("Maximum : 0 ");
        }
        else{
        System.out.print("Maximum value : "+cur);
        }
    }
}
