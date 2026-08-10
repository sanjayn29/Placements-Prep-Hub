/*Question 1:

Write a Java program to find the next bigger number for each element in a given array of integers.

Example 1:
Array Size: 6
Array Elements: 8, 4, 1, 9, 6, 2

Output:
8 -> 9
4 -> 6
1 -> 2
9 -> -
6 -> 8
2 -> 4

Example 2:
Array Size: 9
Array Elements: 12, 9, 3, 7, 4, 9, 10, 2, 1

Output:
12 -> -
9 -> 10
3 -> 4
7 -> 9
4 -> 7
9 -> 10
10 -> 12
2 -> 3
1 -> 2

*/

import java.util.Scanner;
class Q1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter the n size : ");
        n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the values for the array : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //copy
        int sort[] = new int[n];
        for(int i=0;i<n;i++){
            sort[i]=arr[i];
        }

        //bubble sort
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(sort[j]>sort[j+1]){
                    int temp = sort[j];
                    sort[j]=sort[j+1];
                    sort[j+1]=temp;
                }
            }
        }

        //next bigger number
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i]==sort[j]){
                    if(j==n-1){
                        System.out.print(arr[i]+"-> -");
                    }
                    else{
                        System.out.print(arr[i]+"->"+sort[j+1]+"  ");
                        break;
                    }
                }
            }
        }
    }
}