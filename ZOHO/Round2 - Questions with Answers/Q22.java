public class Q22 {
     public static void main(String[] args) {

        String arr[] = {
                "team",
                "teal",
                "teem",
                "tear"
        };

        int n = arr.length;
        int len = arr[0].length();

        int sameCount = 0;
        int maxCount = 0;

        for (int i = 0; i < len; i++) {

            int freq[] = new int[26];

            for (int j = 0; j < n; j++) {
                freq[arr[j].charAt(i) - 'a']++;
            }

            int max = 0;
            char ans = '*';
            boolean tie = false;

            for (int k = 0; k < 26; k++) {

                if (freq[k] > max) {
                    max = freq[k];
                    ans = (char) ('a' + k);
                    tie = false;
                }
                else if (freq[k] == max && max != 0) {
                    tie = true;
                }
            }

            if (max == n) {
                System.out.print(ans);
                sameCount++;
            }
            else if (!tie) {
                System.out.print(ans);
                maxCount++;
            }
            else {
                System.out.print("*");
            }
        }

        System.out.println();
        System.out.println(sameCount);
        System.out.println(maxCount);
    }
}
