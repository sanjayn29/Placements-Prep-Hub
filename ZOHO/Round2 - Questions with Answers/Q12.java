/*
Given a string containing only alphabets and numbers, remove duplicate characters such that:

For alphabets, keep the first occurrence.
For numbers, keep the last occurrence.
Example 1
Input:
a1b2a3b1c2

Output:
ab31c2
 */
public class Q12 {
    public static void main(String[] args){

        String ip = "a1b2a3b1c2";
        boolean res[] = new boolean[26];

        for(int i=0;i<ip.length();i++){
            char n = ip.charAt(i);
            if(Character.isLetter(n)){
                if(!res[n -'a']){
                    res[n -'a']=true;
                    System.out.print(n);
                }
            }
            else{
                boolean last = true;
                for(int j=i+1;j<ip.length();j++){
                    if(ip.charAt(j)==n){
                        last=false;
                        break;
                    }
                }
                if(last){
                    System.out.print(n);
                }
            }
        }
    }
}
