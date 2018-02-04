package week6.intq;
/*Interview Question 1 - Edit Distance
Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1
step.)

You have the following 3 operations permitted on a word:

Insert a character Delete a character Replace a character Example : edit distance between "Anshuman" and "Antihuman" is
2.

Operation 1: Replace s with t. Operation 2: Insert i.
*/
public class EditDistance {

    //Converting str1 to str2 strl is on left axis and str2 on top axis
    //Time complexity is O(m x n)
    //Space complexity is O(m x n)
    static int editDist(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();
        // Create a table to store results of subproblems
        int dp[][] = new int[m+1][n+1];

        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                // If first string is empty, only option is to
                // isnert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                    // If last character are different, consider all
                    // possibilities and find minimum
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                            dp[i-1][j],  // Remove
                            dp[i-1][j-1]); // Replace
                System.out.print(dp[i][j] + " ");

            }
            System.out.println( " ");

        }
        System.out.println("Convert "+str1+" to "+str2);

        printActualEdits(dp, str1, str2);
        return dp[m][n];
    }

    static int min(int x,int y, int z) {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }
    static public void printActualEdits(int T[][], String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int i = T.length - 1;
        int j = T[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i-1] == str2[j-1]) {
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j-1] + 1){
                System.out.println("Replace " + str2[j-1] + " in "+s2+" to " + str1[i-1] + " in "+s1);
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j] + 1) {
                System.out.println("Delete in "+s1+" " + str1[i-1]);
                i = i-1;
            } else if (T[i][j] == T[i][j-1] + 1){
                System.out.println("Delete in "+s2+" " + str2[j-1]);
                j = j -1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }

    public static void main(String[] args)  {
        String s1 = "Anshuman";
        String s2 = "Antihuman";

        s1 = "ad";
        s2 = "abc";
        System.out.println(editDist(s1, s2));

    }
}
