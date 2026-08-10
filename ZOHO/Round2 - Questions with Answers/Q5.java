/*
Write a Java program to form lines using the given set of words based on the following rules.

Rules:
1. The total number of characters in a single line, excluding spaces between words and excluding the favorite character, must not exceed the given maximum limit.
2. The favorite character is case-insensitive. For example, if the favorite character is 'd', both 'd' and 'D' should be ignored while counting characters.
3. Words must not be split. Only complete words can be placed in a line.
4. A word can appear in only one line.

Example 1:

Input:
Max characters per line: 10
Favorite character: o
Words:
Zoho, Eating, Watching, Pogo, Loving, Mango

Output:
Watching Zoho (10)
Eating Mango (10)
Loving Pogo (7)

Example 2:

Input:
Max characters per line: 15
Favorite character: w
Words:
Twinkle, Twinkle, little, star, how, I, wonder, what, you, are

Output:
Twinkle Twinkle what (15)
little wonder star (15)
you are how I (9)
 */
class Q5{

    static int lencal(String n,char fav){
        int count = 0;
        for(int i=0;i<n.length();i++){
            char cur = n.charAt(i);
            if(Character.toLowerCase(cur) != Character.toLowerCase(fav)){
                count++;
            }
        }
        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args){

        int max = 10;
        char fav = 'o';
        String words[] = {"Zoho", "Eating", "Watching", "Pogo", "Loving", "Mango"};
        String line = "";
        int curr = 0;

        for(int i=0;i<words.length;i++){
            int len = lencal(words[i],fav);
            if(len+curr <= max){
                if(line.isEmpty()){
                    line = words[i];
                }
                else{
                    line = line+" "+words[i];
                }
                curr+=len;
            }
            else{
            System.out.println(line+"("+curr+")");
            line = words[i];
            curr = len;
            }
        }
        
        if(!line.isEmpty()){
            System.out.println(line+"("+curr+")");
        }
    }
}