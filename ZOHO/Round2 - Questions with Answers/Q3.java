/*
Question 3:

Write a Java program to reverse only the alphanumeric characters in a given string while keeping all spaces and other punctuation characters (non-alphanumeric) in their original positions.

Important Note:
Solve the problem by traversing the character array only once without using any additional arrays.

Example 1:
Input:
house ! no: 12

Output:
21one ! su: oh

Example 2:
Input:
I brought 3 items : a pen, a notebook, and a scale.

Output:
e lacsadn a koobe : t ona, n epasmeti, 3th g uorbl.
*/
class Q3{
    static boolean alpnum(char n){
        if( (n>='A' && 'Z'>= n) || (n>='a' && 'z'>=n) || (n>='0' && '9'>=n) ){
            return true;
        }
        return false;
    }
    public static void main(String[] args){

        String input = "house ! no: 12";
        char res[] = input.toCharArray();
        int i=0;
        int j=res.length-1;

        while(i<j){
            if(!alpnum(res[i])){
                i++;
            }else if(!alpnum(res[j])){
                j--;
            }else{
                char temp = res[i];
                res[i]=res[j];
                res[j]=temp;

                i++;
                j--;
            }
        }
        System.out.print(new String(res));
    }
}