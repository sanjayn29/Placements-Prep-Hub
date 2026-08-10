/*
Write a Java program to find the contiguous subarray containing only positive integers that has the maximum sum. Print both the maximum sum and the elements of that subarray.

The array contains both positive and negative integers.

Important Note:
Solve the problem using a single traversal of the array.

Example 1:
Input:
[-8, 12, 15, -10, 13, 1, 18]

Output:
Max Sum = 32
Array Elements = {13, 1, 18}

Explanation:
The two contiguous subarrays containing only positive numbers are:
{12, 15} and {13, 1, 18}

Their sums are:
12 + 15 = 27
13 + 1 + 18 = 32

Hence, the required output is:
Max Sum = 32
Array Elements = {13, 1, 18}

Example 2:
Input:
[-11, 11, 15, -1, 30, -2]

Output:
Max Sum = 30
Array Elements = {30}

Explanation:
The two contiguous subarrays containing only positive numbers are:
{11, 15} and {30}

Their sums are:
11 + 15 = 26
30 = 30

Hence, the required output is:
Max Sum = 30
Array Elements = {30}
 */
class Q4{
    public static void main(String[] args){

        int arr[] = {-8,12,15,-10,13,1,18};
        int maxx = 0;
        int curr = 0;
        int start = 0;
        int bstart = 0;
        int bend = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0){
                curr += arr[i];
            }else{
                if(maxx < curr){
                    maxx = curr;
                    bstart = start;
                    bend = i-1;
                }
                curr = 0;
                start = i+1;
            }
        }
        if(curr > maxx){
            maxx = curr;
            bstart = start;
            bend = arr.length-1;
        }
        System.out.println("Max sum : "+maxx);
        System.out.print("the sub array = {");
        for(int i=bstart;i<=bend;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("}");
    }
}