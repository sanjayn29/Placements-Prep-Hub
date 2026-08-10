/*
Question 9:

Write a Java program to find the longest chain that can be formed from a given set of pairs.

Rules:
1. Each pair contains two numbers (a, b), where a < b.
2. A pair (c, d) can follow another pair (a, b) only if b < c.
3. Print the length of the longest possible chain and the pairs that form the chain.
4. If multiple longest chains exist, print all such valid chains.

Example 1:

Input:
{(5, 24), (39, 60), (15, 28), (27, 40), (50, 90)}

Output:
Length = 3
Pairs = {(5, 24), (27, 40), (50, 90)}

Example 2:

Input:
{(20, 30), (12, 25), (12, 20), (2, 10), (15, 25), (25, 40), (40, 60)}

Output:
Length = 4

Pairs:
{(2, 10), (12, 20), (20, 30), (40, 60)}
{(2, 10), (12, 25), (25, 40), (40, 60)}
 */
public class Q9 {
    public static void main(String[] args){
        int pair[][] = {
            {5,24},
            {39,60},
            {15,28},
            {27,40},
            {50,90}
        };

        for(int i=0;i<pair.length-1;i++){
            for(int j=0;j<pair.length-i-1;j++){
                if(pair[j][1] > pair[j+1][1]){
                    int t1 = pair[j][0];
                    int t2 = pair[j][1];

                    pair[j][0] = pair[j+1][0];
                    pair[j][1] = pair[j+1][1];

                    pair[j+1][0] = t1;
                    pair[j+1][1] = t2;
                }
            }
        }

        int len = 1;
        int end = pair[0][1];
        System.out.print("("+pair[0][0]+","+pair[0][1]+")");
        for(int i=1;i<pair.length;i++){
            if(end < pair[i][0]){
            System.out.print("("+pair[i][0]+","+pair[i][1]+")");
            end = pair[i][1];
            len++;
            }
        }
        System.out.println("length : "+len);
    }
}