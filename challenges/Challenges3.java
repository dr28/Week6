package week6.challenges;
/*Challenge 3 - Regular Expression Matching
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character. '*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p) Some examples:

isMatch("aa","a") → 0 isMatch("aa","aa") → 1 isMatch("aaa","aa") → 0 isMatch("aa", "a*") → 1 isMatch("aa", ".") → 1
isMatch("ab", ".") → 1 isMatch("aab", "c*a*b") → 1*/
public class Challenges3 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
        dp[A.length()][B.length()] = true;

        for (int i = A.length(); i >= 0; i--){
            for (int j = B.length() - 1; j >= 0; j--){
                boolean first_match = (i < A.length() &&
                        (B.charAt(j) == A.charAt(i) ||
                                B.charAt(j) == '.'));
                if (j + 1 < B.length() && B.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0]?1:0;
    }
}
