/*
Write a Java program to traverse a given (m × n) matrix and print the values encountered along a specified path.

The program must validate every move in the path. If the path goes outside the matrix boundaries, print an appropriate error message.

Matrix (5 × 5):

[
 [1, 2, 3, 4, 5],
 [6, 7, 8, 9, 0],
 [1, 2, 3, 4, 5],
 [6, 7, 8, 9, 0],
 [1, 2, 3, 4, 5]
]

Path Notations:
>  : Move Right
v  : Move Down
<  : Move Left
^  : Move Up

Example 1:

Input:
Start Position (Row, Column): (1, 2)
Path:
> > > v

Output:
2 3 4 5 0

Example 2:

Input:
Start Position (Row, Column): (2, 3)
Path:
v > > v < ^ > > v v

Output:
8 3 4 5 0 9 8 3 4 5 0 5

Example 3:

Input:
Start Position (Row, Column): (1, 4)
Path:
> v > >

Output:
Invalid Path*/
public class Q8 {
    public static void main(String[] args){

        int mat[][] = {
                {1,2,3,4,5},
                {6,7,8,9,0},
                {1,2,3,4,5},
                {6,7,8,9,0},
                {1,2,3,4,5}
        };
        int  row = 1;
        int col = 2;
        String path = ">>>v";

        row--;
        col--;
        System.out.print(mat[row][col]+" ");
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='>'){
                col++;
            }
            else if(path.charAt(i)=='<'){
                col--;
            }
            else if(path.charAt(i)=='v'){
                row++;
            }
            else if(path.charAt(i)=='^'){
                row--;
            }
            if(row < 0 || row >= mat.length || col < 0 || col >= mat[0].length){
                System.out.print("Invalid");
                break;
            }
            System.out.print(mat[row][col]+" ");
        }
    }
}   
